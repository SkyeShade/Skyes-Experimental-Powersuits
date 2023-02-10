package net.skyeshade.expowersuits.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skyeshade.expowersuits.ExPowersuits;

import net.skyeshade.expowersuits.block.custom.WorkStationBlock;
import net.skyeshade.expowersuits.item.ModCreativeModeTab;
import net.skyeshade.expowersuits.item.ModItems;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;





public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExPowersuits.MOD_ID);

    // add blocks here
    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(10f).requiresCorrectToolForDrops().explosionResistance(1200f)));

    public static final RegistryObject<Block> DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE).strength(12f).requiresCorrectToolForDrops().explosionResistance(1200f)));


    public static final RegistryObject<Block> TUNGSTEN_ORE = registerBlock("tungsten_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(20f).requiresCorrectToolForDrops().explosionResistance(1200f)));

    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.DEEPSLATE).strength(24f).requiresCorrectToolForDrops().explosionResistance(1200f)));


    public static final RegistryObject<Block> WORKSTATION = registerBlock("workstation",
            () -> new WorkStationBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).sound(SoundType.STONE).strength(10f).requiresCorrectToolForDrops().explosionResistance(1200f)));


    //register stuff that i dont understand 100%
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)  {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
