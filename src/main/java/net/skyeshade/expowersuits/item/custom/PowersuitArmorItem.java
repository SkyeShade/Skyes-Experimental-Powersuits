package net.skyeshade.expowersuits.item.custom;


import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.*;
import net.minecraftforge.energy.IEnergyStorage;
import net.skyeshade.expowersuits.util.ModEnergyStorage;

import javax.annotation.Nullable;
import java.util.List;

public abstract class PowersuitArmorItem extends ArmorItem {
    private int sortingID;

    public PowersuitArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {

        super(pMaterial, pSlot, pProperties);


    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt){
        return new ModEnergyStorage(stack);
    }





    public PowersuitArmorItem(ArmorMaterial pMaterial, EquipmentSlot slots, int sortID) {
        super(pMaterial, slots, new Properties()
                .stacksTo(1)
                .durability(0)
                .setNoRepair());
        sortingID = sortID;
    }


    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if (getStoredEnergy(stack) > 0)
            setStoredEnergy(stack, getStoredEnergy(stack) - 1);
        //System.out.println(getStoredEnergy(stack));

        //stack.getCapability(ForgeCapabilities )

    }


    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.getCapability(ForgeCapabilities.ENERGY).map(iEnergyStorage -> iEnergyStorage.getMaxEnergyStored() > 1).orElse(false);
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return stack.getCapability(ForgeCapabilities.ENERGY).map(iEnergyStorage -> iEnergyStorage.getEnergyStored() * 13 / iEnergyStorage.getMaxEnergyStored()).orElse(1);
    }

    @Override
    public int getBarColor(ItemStack stack) {
        IEnergyStorage energy = stack.getCapability(ForgeCapabilities.ENERGY).orElse(null);
        if (energy == null) {
            return super.getBarColor(stack);
        }
        return Mth.hsvToRgb(0.5F, 1.0F, 1.0F);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag){
        super.appendHoverText(stack, level, tooltip, flag);

        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("item.powerarmor.desc.energy", getStoredEnergy(stack), getCapacity(stack)).withStyle(ChatFormatting.AQUA));
            tooltip.add(Component.translatable("item.powerarmor.desc.capacity", getCapacity(stack)).withStyle(ChatFormatting.GOLD));

            tooltip.add(Component.literal(" "));


        }else {


            tooltip.add(Component.translatable("item.powerarmor.desc.energy", getStoredEnergy(stack), getCapacity(stack)).withStyle(ChatFormatting.AQUA));
            tooltip.add(Component.translatable("item.powerarmor.desc.capacity", getCapacity(stack)).withStyle(ChatFormatting.GRAY));
            tooltip.add(Component.literal(" "));
            tooltip.add(Component.translatable("item.powerarmor.desc.holdshift", getCapacity(stack)).withStyle(ChatFormatting.GRAY));

        }
    }



    @Override
    public boolean canBeDepleted() {
        return false;
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {

    }



    public static int getStoredEnergy(ItemStack stack){
        return stack.getOrCreateTag().getInt("Energy");
    }

    public static void setStoredEnergy(ItemStack stack, int energy){
        stack.getOrCreateTag().putInt("Energy", energy);
    }

    public static int getCapacity(ItemStack stack){
        return 100000;
    }

    public static int getMaxTransfer(ItemStack stack) {
        return 1000;
    }







    public int getSortingID() {
        return sortingID;
    }
}
