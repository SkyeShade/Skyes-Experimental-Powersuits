package net.skyeshade.expowersuits.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.skyeshade.expowersuits.ExPowersuits;
import net.skyeshade.expowersuits.world.feature.ModConfiguredFeatures;
import net.skyeshade.expowersuits.world.feature.ModPlacedFeatures;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);



    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,  BUILDER, Collections.singleton(ExPowersuits.MOD_ID));
    }
}
