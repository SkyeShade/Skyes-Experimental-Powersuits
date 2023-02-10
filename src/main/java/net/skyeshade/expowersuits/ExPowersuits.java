package net.skyeshade.expowersuits;

import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.skyeshade.expowersuits.block.ModBlocks;
import net.skyeshade.expowersuits.block.entity.ModBlockEntities;
import net.skyeshade.expowersuits.item.ModItems;
import net.skyeshade.expowersuits.item.TabItemAdder;
import net.skyeshade.expowersuits.networking.ModMessages;



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
        ModBlockEntities.register(eventBus);






        eventBus.addListener(TabItemAdder::addCreative);
        eventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        // Register ourselves for server and other game events we are interested in

    }


    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });

        ModMessages.register();
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLCommonSetupEvent event) {




        }
    }

}
