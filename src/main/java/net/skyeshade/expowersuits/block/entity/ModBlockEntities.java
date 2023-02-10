package net.skyeshade.expowersuits.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skyeshade.expowersuits.ExPowersuits;
import net.skyeshade.expowersuits.block.ModBlocks;

public class ModBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ExPowersuits.MOD_ID);

      public static final RegistryObject<BlockEntityType<WorkStationBlockEntity>> WORKSTATION =
            BLOCK_ENTITIES.register("workstation_entity", () ->
                    BlockEntityType.Builder.of(WorkStationBlockEntity::new,
                            ModBlocks.WORKSTATION.get()).build(null));



    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
