package com.dantesys.valentcitymod.item;

import com.dantesys.valentcitymod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTier {
    public static final Tier ASCENCIONTIER = new ForgeTier(
            8192,
            11f,
            6f,
            30,
            ModTags.Blocks.NEEDS_RELIC_TOOL,
            () -> Ingredient.of(ModItens.ASCENSION.get()),
            ModTags.Blocks.INCORRECT_FOR_RELIC_TOOL
    );
    public static final Tier PASCENCIONTIER = new ForgeTier(
            4096,
            10f,
            5f,
            25,
            ModTags.Blocks.NEEDS_RELIC_TOOL,
            () -> Ingredient.of(ModItens.ASCENSION.get()),
            ModTags.Blocks.INCORRECT_FOR_RELIC_TOOL
    );
}
