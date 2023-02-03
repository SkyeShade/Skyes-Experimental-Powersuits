package net.skyeshade.expowersuits.item.custom;


import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TitaniumPowersuitArmorItem extends ArmorItem {


    public TitaniumPowersuitArmorItem(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public void onArmorTick (ItemStack stack, Level world, Player player) {
        //System.out.println(player.hasEffect());


    }

}
