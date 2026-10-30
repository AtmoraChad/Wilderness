package net.atomorachad.wilderness.worldgen.feature;

import net.atomorachad.wilderness.WildernessFalls;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModFeatures {

    public static final ResourceKey<PlacedFeature> DAPPLED_GRASS_BONEMEAL = PlacementUtils.createKey("dappled_grass_bonemeal");

    public static void registerModFeatures() {
        WildernessFalls.LOGGER.info("Registering Mod Features for " + WildernessFalls.MOD_ID);
    }
}