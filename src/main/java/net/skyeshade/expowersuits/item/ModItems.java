package net.skyeshade.expowersuits.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skyeshade.expowersuits.ExPowersuits;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExPowersuits.MOD_ID);

    //Hydraulics
    public static final RegistryObject<Item> SUPERLIGHT_HYDRAULIC = ITEMS.register("superlight_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(2000)));

    public static final RegistryObject<Item> LIGHT_HYDRAULIC = ITEMS.register("light_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(2000)));
    public static final RegistryObject<Item> MEDIUM_HYDRAULIC = ITEMS.register("medium_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(4000)));

    public static final RegistryObject<Item> HEAVY_HYDRAULIC = ITEMS.register("heavy_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(8000)));

    public static final RegistryObject<Item> SUPERHEAVY_HYDRAULIC = ITEMS.register("superheavy_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(16000)));

    public static final RegistryObject<Item> INDUSTRIAL_HYDRAULIC = ITEMS.register("industrial_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(32000)));

    public static final RegistryObject<Item> THICC_HYDRAULIC = ITEMS.register("thicc_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(64000)));
    //Electric Motors

    public static final RegistryObject<Item> SUPERLIGHT_ELECTRIC_MOTOR = ITEMS.register("superlight_electric_motor",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(500)));

    public static final RegistryObject<Item> LIGHT_ELECTRIC_MOTOR = ITEMS.register("light_electric_motor",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(500)));

    public static final RegistryObject<Item> MEDIUM_ELECTRIC_MOTOR = ITEMS.register("medium_electric_motor",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(1000)));

    public static final RegistryObject<Item> HEAVY_ELECTRIC_MOTOR = ITEMS.register("heavy_electric_motor",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(2000)));

    public static final RegistryObject<Item> SUPERHEAVY_ELECTRIC_MOTOR = ITEMS.register("superheavy_electric_motor",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(4000)));

    public static final RegistryObject<Item> INDUSTRIAL_ELECTRIC_MOTOR = ITEMS.register("industrial_electric_motor",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(8000)));


    //Resources

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB)));

    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
