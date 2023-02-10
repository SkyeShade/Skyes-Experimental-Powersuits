package net.skyeshade.expowersuits.item.custom.armor;

import com.sun.jna.platform.win32.OaIdl;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.skyeshade.expowersuits.item.ModArmorMaterials;
import net.skyeshade.expowersuits.item.custom.PowersuitArmorItem;

public class TitaniumArmorBody extends PowersuitArmorItem {

    public TitaniumArmorBody() {
        super(ModArmorMaterials.TITANIUM, EquipmentSlot.CHEST, 2);
    }


    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {


        //fun little jetpack boost thing
        //TODO: when pressing W it should activate jets which will ramp up before providing full thrust
        double climbrate = 1;
        if (entity.getLookAngle().y > 0) {
            climbrate = 1.1 -entity.getLookAngle().y;
        }

        entity.addDeltaMovement(new Vec3(((entity.getLookAngle().x)/40),(entity.getLookAngle().y/40),(entity.getLookAngle().z/40)));




        //System.out.println(entity.getLookAngle().y);
        return true;
    }
}
