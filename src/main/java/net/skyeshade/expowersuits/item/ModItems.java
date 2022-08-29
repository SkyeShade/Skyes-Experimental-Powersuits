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


    public static final RegistryObject<Item> SUPERLIGHT_HYDRAULIC = ITEMS.register("superlight_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(2000)));

    public static final RegistryObject<Item> LIGHT_HYDRAULIC = ITEMS.register("light_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(2000)));
    public static final RegistryObject<Item> MEDIUM_HYDRAULIC = ITEMS.register("medium_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(4000)));

    public static final RegistryObject<Item> HEAVY_HYDRAULIC = ITEMS.register("heavy_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(8000)));

    public static final RegistryObject<Item> ULTRAHEAVY_HYDRAULIC = ITEMS.register("ultraheavy_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(16000)));

    public static final RegistryObject<Item> INDUSTRIAL_HYDRAULIC = ITEMS.register("industrial_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(32000)));

    public static final RegistryObject<Item> THICC_HYDRAULIC = ITEMS.register("thicc_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB).durability(64000)));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB)));

    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
