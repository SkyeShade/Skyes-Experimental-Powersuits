package net.skyeshade.expowersuits.world;


import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.skyeshade.expowersuits.ExPowersuits;
import net.skyeshade.expowersuits.world.gen.ModOreGeneration;

@Mod.EventBusSubscriber(modid = ExPowersuits.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);
    }
}
