package net.skyeshade.expowersuits.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab EXPERIMENTAL_POWERSUITS_TAB = new CreativeModeTab("experimental_powersuits_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MEDIUM_HYDRAULIC.get());
        }
    };
}
