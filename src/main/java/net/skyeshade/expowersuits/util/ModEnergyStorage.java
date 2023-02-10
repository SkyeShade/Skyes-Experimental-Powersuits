package net.skyeshade.expowersuits.util;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandler;
import net.skyeshade.expowersuits.item.custom.PowersuitArmorItem;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ModEnergyStorage implements IEnergyStorage, ICapabilityProvider {
    private final LazyOptional<IEnergyStorage> holder = LazyOptional.of(() -> this);

    public static Capability<PowerArmorCapabilities> POWERARMOR = CapabilityManager.get(new CapabilityToken<PowerArmorCapabilities>() { });
    private PowerArmorCapabilities stats = null;
    private final LazyOptional<PowerArmorCapabilities> powerArmorOptional = LazyOptional.of(this::createPowerArmor);
    private PowerArmorCapabilities createPowerArmor() {if(this.stats == null) {this.stats = new PowerArmorCapabilities();}return this.stats;}

    private final ItemStack stack;


    public ModEnergyStorage(ItemStack stack) {
        this.stack = stack;
    }

    public void setEnergyStored(int energy){
        PowersuitArmorItem.setStoredEnergy(this.stack, energy);
    }

    @Override
    public int getEnergyStored(){
        return PowersuitArmorItem.getStoredEnergy(this.stack);
    }

    @Override
    public int getMaxEnergyStored(){
        return PowersuitArmorItem.getCapacity(this.stack);
    }

    @Override
    public boolean canExtract(){
        return this.getEnergyStored() > 0;
    }

    @Override
    public boolean canReceive(){
        return this.getEnergyStored() < this.getMaxEnergyStored();
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate){
        if (!canReceive()){
            return 0;
        }

        int stored = this.getEnergyStored();
        int energyReceived = Math.min(this.getMaxEnergyStored() - stored, Math.min(PowersuitArmorItem.getMaxTransfer(this.stack), maxReceive));
        if (!simulate){
            this.setEnergyStored(stored + energyReceived);
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate){
        if (!canExtract()){
            return 0;
        }

        int stored = this.getEnergyStored();
        int energyExtracted = Math.min(stored, Math.min(PowersuitArmorItem.getMaxTransfer(this.stack), maxExtract));
        if (!simulate){
            this.setEnergyStored(stored - energyExtracted);
        }
        return energyExtracted;
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side){

        return ForgeCapabilities.ENERGY.orEmpty(cap, holder);


    }


}



