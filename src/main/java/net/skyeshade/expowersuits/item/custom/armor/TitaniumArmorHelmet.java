package net.skyeshade.expowersuits.item.custom.armor;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.skyeshade.expowersuits.item.ModArmorMaterials;
import net.skyeshade.expowersuits.item.custom.PowersuitArmorItem;

public class TitaniumArmorHelmet extends PowersuitArmorItem {


    private boolean effectBoolean = false;
    public TitaniumArmorHelmet() {
        super(ModArmorMaterials.TITANIUM, EquipmentSlot.HEAD, 1);
    }



    @Override
    public void onArmorTick (ItemStack stack, Level world, Player player) {
        if (getStoredEnergy(stack) > 0) {
            effectBoolean = true;
            setStoredEnergy(stack, getStoredEnergy(stack) - 1);
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 400,0, false, false, false));
        }else if (player.getActiveEffects().contains(MobEffects.NIGHT_VISION)) {
            player.removeEffect(MobEffects.NIGHT_VISION);
            effectBoolean = false;
        }


    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

        if (pEntity instanceof Player) {
            Player player = (Player)pEntity;
            if (effectBoolean) {
                player.removeEffect(MobEffects.NIGHT_VISION);
                effectBoolean = false;
            }
        }


    }
}
