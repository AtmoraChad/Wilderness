package net.atomorachad.wilderness.worldgen;


import net.atomorachad.wilderness.WildernessFalls;
import net.atomorachad.wilderness.block.ModBlocks;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.condition.MaterialCondition;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

public class DappledForestMaterialRules {

    private static final MaterialCondition SURFACE = MaterialRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR);

    private static final MaterialCondition NOT_UNDERWATER = MaterialRules.waterBlockCheck(0, 0);

    private static final ResourceKey<NormalNoise> DAPPLED_FOREST_GRASS_NOISE = ResourceKey.create(
                    Registries.NOISE, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, "dappled_forest_grass"));

    private static final ResourceKey<NormalNoise> SMALL_PATCH_NOISE = ResourceKey.create(
                    Registries.NOISE, Identifier.withDefaultNamespace("small_patch"));

    private static final MaterialCondition COARSE_DIRT_CONDITION = MaterialRules.noiseCondition2d(SMALL_PATCH_NOISE, 1.2D);

    private static final MaterialRule COARSE_DIRT =
            MaterialRules.state(Blocks.COARSE_DIRT.defaultBlockState());

    public static MaterialRule dappledForest(RegistryAccess registryAccess) {
        return MaterialRules.ifTrue(
                MaterialRules.isBiome(
                        registryAccess.lookupOrThrow(Registries.BIOME),
                        ResourceKey.create(
                                Registries.BIOME, Identifier.withDefaultNamespace("dappled_forest"))),

                MaterialRules.ifTrue(
                        SURFACE, MaterialRules.ifTrue(
                                NOT_UNDERWATER, MaterialRules.sequence(

                                        MaterialRules.ifTrue(
                                                COARSE_DIRT_CONDITION, COARSE_DIRT),
                                        MaterialRules.ifTrue(
                                            MaterialRules.noiseCondition2d(
                                                DAPPLED_FOREST_GRASS_NOISE, 0.05D),
                                        MaterialRules.state(Blocks.GRASS_BLOCK.defaultBlockState())),

                                MaterialRules.state(
                                        ModBlocks.DAPPLED_GRASS.defaultBlockState()
                                )
                            )
                        )
                )
        );
    }
}
