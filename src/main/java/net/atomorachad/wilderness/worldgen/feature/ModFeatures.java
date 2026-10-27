package net.atomorachad.wilderness.worldgen.feature;

import net.atomorachad.wilderness.WildernessFalls;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModFeatures {

    public static final ResourceKey<Feature> ORANGE_MOSS_PATCH_BONEMEAL = ResourceKey.create(Registries.FEATURE,
            Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, "orange_moss_bonemeal_patch"));

    public static final ResourceKey<Feature> RED_MOSS_PATCH_BONEMEAL = ResourceKey.create(Registries.FEATURE,
                    Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, "red_moss_bonemeal_patch"));

    public static final ResourceKey<Feature> YELLOW_MOSS_PATCH_BONEMEAL = ResourceKey.create(Registries.FEATURE,
                    Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, "yellow_moss_bonemeal_patch"));

    public static void registerModFeatures() {
        WildernessFalls.LOGGER.info("Registering Mod Features for " + WildernessFalls.MOD_ID);
    }
}