package net.skyeshade.expowersuits.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skyeshade.expowersuits.ExPowersuits;
import net.skyeshade.expowersuits.item.custom.PowersuitArmorItem;
import net.skyeshade.expowersuits.item.custom.armor.TitaniumArmorBody;
import net.skyeshade.expowersuits.item.custom.armor.TitaniumArmorFeet;
import net.skyeshade.expowersuits.item.custom.armor.TitaniumArmorHelmet;
import net.skyeshade.expowersuits.item.custom.armor.TitaniumArmorLegs;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExPowersuits.MOD_ID);

    //Hydraulics
    public static final RegistryObject<Item> SUPERLIGHT_HYDRAULIC = ITEMS.register("superlight_hydraulic",
            () -> new Item(new Item.Properties().durability(2000)));

    public static final RegistryObject<Item> LIGHT_HYDRAULIC = ITEMS.register("light_hydraulic",
            () -> new Item(new Item.Properties().durability(2000)));
    public static final RegistryObject<Item> MEDIUM_HYDRAULIC = ITEMS.register("medium_hydraulic",
            () -> new Item(new Item.Properties().durability(4000)));

    public static final RegistryObject<Item> HEAVY_HYDRAULIC = ITEMS.register("heavy_hydraulic",
            () -> new Item(new Item.Properties().durability(8000)));

    public static final RegistryObject<Item> SUPERHEAVY_HYDRAULIC = ITEMS.register("superheavy_hydraulic",
            () -> new Item(new Item.Properties().durability(16000)));

    public static final RegistryObject<Item> INDUSTRIAL_HYDRAULIC = ITEMS.register("industrial_hydraulic",
            () -> new Item(new Item.Properties().durability(32000)));

    public static final RegistryObject<Item> THICC_HYDRAULIC = ITEMS.register("thicc_hydraulic",
            () -> new Item(new Item.Properties().durability(64000)));
    //Electric Motors

    public static final RegistryObject<Item> SUPERLIGHT_ELECTRIC_MOTOR = ITEMS.register("superlight_electric_motor",
            () -> new Item(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> LIGHT_ELECTRIC_MOTOR = ITEMS.register("light_electric_motor",
            () -> new Item(new Item.Properties().durability(500)));

    public static final RegistryObject<Item> MEDIUM_ELECTRIC_MOTOR = ITEMS.register("medium_electric_motor",
            () -> new Item(new Item.Properties().durability(1000)));

    public static final RegistryObject<Item> HEAVY_ELECTRIC_MOTOR = ITEMS.register("heavy_electric_motor",
            () -> new Item(new Item.Properties().durability(2000)));

    public static final RegistryObject<Item> SUPERHEAVY_ELECTRIC_MOTOR = ITEMS.register("superheavy_electric_motor",
            () -> new Item(new Item.Properties().durability(4000)));

    public static final RegistryObject<Item> INDUSTRIAL_ELECTRIC_MOTOR = ITEMS.register("industrial_electric_motor",
            () -> new Item(new Item.Properties().durability(8000)));


    public static final RegistryObject<Item> IRON_LIGHT_PLATING = ITEMS.register("iron_light_plating",
            () -> new Item(new Item.Properties().durability(40)));

    public static final RegistryObject<Item> IRON_MEDIUM_PLATING = ITEMS.register("iron_medium_plating",
            () -> new Item(new Item.Properties().durability(80)));

    public static final RegistryObject<Item> IRON_HEAVY_PLATING = ITEMS.register("iron_heavy_plating",
            () -> new Item(new Item.Properties().durability(120)));

    //Resources
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_TUNGSTEN = ITEMS.register("raw_tungsten",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium",
            () -> new Item(new Item.Properties()));

    //Armor Items
    public static final RegistryObject<Item> TITANIUM_HELMET = ITEMS.register("titanium_helmet",
            TitaniumArmorHelmet::new);

    public static final RegistryObject<Item> TITANIUM_CHESTPLATE = ITEMS.register("titanium_chestplate",
            TitaniumArmorBody::new);

    public static final RegistryObject<Item> TITANIUM_LEGGINGS = ITEMS.register("titanium_leggings",
            TitaniumArmorLegs::new);

    public static final RegistryObject<Item> TITANIUM_BOOTS = ITEMS.register("titanium_boots",
            TitaniumArmorFeet::new);




    //Tools
    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword",
            () -> new SwordItem(ModTiers.TUNGSTEN, 5, -3.2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe",
            () -> new PickaxeItem(ModTiers.TUNGSTEN, 3, -3.4f,
                    new Item.Properties()));

    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe",
            () -> new AxeItem(ModTiers.TUNGSTEN, 7, -3.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel",
            () -> new ShovelItem(ModTiers.TUNGSTEN, 3.5f, -3.5f,
                    new Item.Properties()));

    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe",
            () -> new HoeItem(ModTiers.TUNGSTEN, -3, -2f,
                    new Item.Properties()));


    public static final RegistryObject<Item> TITANIUM_SWORD = ITEMS.register("titanium_sword",
            () -> new SwordItem(ModTiers.TITANIUM, 4, -2f,
                    new Item.Properties()));

    public static final RegistryObject<Item> TITANIUM_PICKAXE = ITEMS.register("titanium_pickaxe",
            () -> new PickaxeItem(ModTiers.TITANIUM, 2, -2.4f,
                    new Item.Properties()));

    public static final RegistryObject<Item> TITANIUM_AXE = ITEMS.register("titanium_axe",
            () -> new AxeItem(ModTiers.TITANIUM, 6, -2.6f,
                    new Item.Properties()));

    public static final RegistryObject<Item> TITANIUM_SHOVEL = ITEMS.register("titanium_shovel",
            () -> new ShovelItem(ModTiers.TITANIUM, 2.5f, -2.6f,
                    new Item.Properties()));

    public static final RegistryObject<Item> TITANIUM_HOE = ITEMS.register("titanium_hoe",
            () -> new HoeItem(ModTiers.TITANIUM, -2, 2f,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
