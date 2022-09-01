package net.skyeshade.expowersuits.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {

    public static final ForgeTier TITANIUM = new ForgeTier(4, 1561, 12.0f,
            2.0f, 22, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.TITANIUM_INGOT.get()));

    public static final ForgeTier TUNGSTEN = new ForgeTier(4, 8124, 4.0f,
            4.0f, 2, BlockTags.NEEDS_DIAMOND_TOOL,
            () -> Ingredient.of(ModItems.TUNGSTEN_INGOT.get()));
}
