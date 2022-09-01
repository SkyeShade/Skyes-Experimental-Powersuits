package net.skyeshade.expowersuits.world.gen;

import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.skyeshade.expowersuits.world.feature.ModPlacedFeatures;

import java.util.List;

public class ModOreGeneration {
    public static void generateOres(final BiomeLoadingEvent event) {
        List<Holder<PlacedFeature>> base =
                event.getGeneration().getFeatures((GenerationStep.Decoration.UNDERGROUND_ORES));

        base.add(ModPlacedFeatures.TITANIUM_ORE_PLACED);

        base.add(ModPlacedFeatures.TUNGSTEN_ORE_PLACED);
    }

}
