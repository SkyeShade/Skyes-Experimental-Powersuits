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


    public static final RegistryObject<Item> LIGHT_HYDRAULIC = ITEMS.register("light_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB)));

    public static final RegistryObject<Item> MEDIUM_HYDRAULIC = ITEMS.register("medium_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB)));

    public static final RegistryObject<Item> HEAVY_HYDRAULIC = ITEMS.register("heavy_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB)));

    public static final RegistryObject<Item> ULTRAHEAVY_HYDRAULIC = ITEMS.register("ultraheavy_hydraulic",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXPERIMENTAL_POWERSUITS_TAB)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
