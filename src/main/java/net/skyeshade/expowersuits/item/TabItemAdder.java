package net.skyeshade.expowersuits.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.registries.RegistryObject;
import net.skyeshade.expowersuits.block.ModBlocks;
import net.skyeshade.expowersuits.item.custom.armor.TitaniumArmorHelmet;

import java.util.ArrayList;

public class TabItemAdder {
    public static void addCreative(CreativeModeTabEvent.BuildContents event) {

        //add to main tab
        if ( event.getTab() == ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB) {
            event.accept(ModItems.SUPERLIGHT_HYDRAULIC);
            event.accept(ModItems.LIGHT_HYDRAULIC);
            event.accept(ModItems.MEDIUM_HYDRAULIC);
            event.accept(ModItems.HEAVY_HYDRAULIC);
            event.accept(ModItems.SUPERHEAVY_HYDRAULIC);
            event.accept(ModItems.INDUSTRIAL_HYDRAULIC);
            event.accept(ModItems.THICC_HYDRAULIC);
            event.accept(ModItems.SUPERLIGHT_ELECTRIC_MOTOR);
            event.accept(ModItems.LIGHT_ELECTRIC_MOTOR);
            event.accept(ModItems.MEDIUM_ELECTRIC_MOTOR);
            event.accept(ModItems.HEAVY_ELECTRIC_MOTOR);
            event.accept(ModItems.SUPERHEAVY_ELECTRIC_MOTOR);
            event.accept(ModItems.INDUSTRIAL_ELECTRIC_MOTOR);

            event.accept(ModBlocks.TUNGSTEN_ORE);
            event.accept(ModBlocks.DEEPSLATE_TUNGSTEN_ORE);
            event.accept(ModItems.RAW_TUNGSTEN);
            event.accept(ModItems.TUNGSTEN_INGOT);
            event.accept(ModItems.TUNGSTEN_AXE);
            event.accept(ModItems.TUNGSTEN_HOE);
            event.accept(ModItems.TUNGSTEN_PICKAXE);
            event.accept(ModItems.TUNGSTEN_SHOVEL);
            event.accept(ModItems.TUNGSTEN_SWORD);

            event.accept(ModBlocks.TITANIUM_ORE);
            event.accept(ModBlocks.DEEPSLATE_TITANIUM_ORE);
            event.accept(ModItems.RAW_TITANIUM);
            event.accept(ModItems.TITANIUM_INGOT);
            event.accept(ModItems.TITANIUM_AXE);
            event.accept(ModItems.TITANIUM_HOE);
            event.accept(ModItems.TITANIUM_PICKAXE);
            event.accept(ModItems.TITANIUM_SHOVEL);
            event.accept(ModItems.TITANIUM_SWORD);

            event.accept(ModItems.TITANIUM_HELMET);
            event.accept(ModItems.TITANIUM_CHESTPLATE);
            event.accept(ModItems.TITANIUM_LEGGINGS);
            event.accept(ModItems.TITANIUM_BOOTS);

            event.accept(ModItems.IRON_LIGHT_PLATING);

            event.accept(ModItems.IRON_MEDIUM_PLATING);

            event.accept(ModItems.IRON_HEAVY_PLATING);


            event.accept(ModBlocks.WORKSTATION);



        }
    }
}
