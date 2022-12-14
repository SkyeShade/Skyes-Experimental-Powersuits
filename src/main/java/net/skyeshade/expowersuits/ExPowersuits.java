package net.skyeshade.expowersuits;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.skyeshade.expowersuits.block.ModBlocks;
import net.skyeshade.expowersuits.item.ModItems;
import net.skyeshade.expowersuits.world.feature.ModConfiguredFeatures;
import net.skyeshade.expowersuits.world.feature.ModPlacedFeatures;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExPowersuits.MOD_ID)
public class ExPowersuits
{
    public static final String MOD_ID = "expowersuits";


    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    //e
    public ExPowersuits()
    {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModConfiguredFeatures.register(eventBus);
        ModPlacedFeatures.register(eventBus);

        eventBus.addListener(this::setup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getName());
    }

}
