package net.skyeshade.expowersuits.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.skyeshade.expowersuits.ExPowersuits;

@Mod.EventBusSubscriber(modid = ExPowersuits.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab EXPERIMENTAL_POWERSUITS_TAB;
    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        EXPERIMENTAL_POWERSUITS_TAB = event.registerCreativeModeTab(new ResourceLocation(ExPowersuits.MOD_ID, "experimental_powersuits_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.MEDIUM_HYDRAULIC.get())).title(Component.translatable("itemGroup.experimental_powersuits_tab")).build());
    }
}
