package net.atomorachad.wilderness.datagen;


import net.atomorachad.wilderness.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @SafeVarargs
    private final void addToTags(ResourceKey<Block> block, TagKey<Block>... tags) {
        for (TagKey<Block> tag : tags) {
            builder(tag).add(block);
        }
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.getRK(ModBlocks.RED_MOSS))
                .add(ModBlocks.getRK(ModBlocks.RED_MOSS_CARPET))
                .add(ModBlocks.getRK(ModBlocks.ORANGE_MOSS))
                .add(ModBlocks.getRK(ModBlocks.ORANGE_MOSS_CARPET))
                .add(ModBlocks.getRK(ModBlocks.YELLOW_MOSS))
                .add(ModBlocks.getRK(ModBlocks.YELLOW_MOSS_CARPET))
        ;

        addToTags(
                ModBlocks.getRK(ModBlocks.RED_MOSS),
                BlockTags.AZALEA_GROWS_ON,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.SCULK_REPLACEABLE,
                BlockTags.SUPPORTS_STEM_FRUIT,
                BlockTags.SUPPORTS_SUGAR_CANE,
                BlockTags.BENEATH_BAMBOO_PODZOL_REPLACEABLE,
                BlockTags.SUPPORTS_NETHER_SPROUTS,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.SUPPORTS_MELON_STEM_FRUIT,
                BlockTags.FOREST_ROCK_CAN_PLACE_ON,
                BlockTags.SUPPORTS_BAMBOO,
                BlockTags.SUPPORTS_WARPED_FUNGUS,
                BlockTags.SUPPORTS_PUMPKIN_STEM_FRUIT,
                BlockTags.CANNOT_REPLACE_BELOW_TREE_TRUNK,
                BlockTags.SUPPORTS_WITHER_ROSE,
                BlockTags.SUBSTRATE_OVERWORLD,
                BlockTags.SUPPORTS_BIG_DRIPLEAF,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.SUPPORTS_WARPED_ROOTS,
                BlockTags.SUPPORTS_VEGETATION,
                BlockTags.SUPPORTS_SMALL_DRIPLEAF,
                BlockTags.MOSS_BLOCKS,
                BlockTags.MOSS_REPLACEABLE,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.SCULK_REPLACEABLE_WORLD_GEN,
                BlockTags.BLOCKS_MOTION,
                BlockTags.HUGE_RED_MUSHROOM_CAN_PLACE_ON,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.SUPPORTS_CRIMSON_FUNGUS,
                BlockTags.ENDERMAN_HOLDABLE,
                BlockTags.SUPPORTS_MANGROVE_PROPAGULE,
                BlockTags.AZALEA_ROOT_REPLACEABLE,
                BlockTags.ICE_SPIKE_REPLACEABLE,
                BlockTags.SNIFFER_EGG_HATCH_BOOST,
                BlockTags.SUPPORTS_AZALEA,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.SNIFFER_DIGGABLE_BLOCK,
                BlockTags.SUPPORTS_DRY_VEGETATION,
                BlockTags.BENEATH_TREE_PODZOL_REPLACEABLE,
                BlockTags.HUGE_BROWN_MUSHROOM_CAN_PLACE_ON,
                BlockTags.SUPPORTS_CRIMSON_ROOTS,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.LUSH_GROUND_REPLACEABLE
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.ORANGE_MOSS),
                BlockTags.AZALEA_GROWS_ON,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.SCULK_REPLACEABLE,
                BlockTags.SUPPORTS_STEM_FRUIT,
                BlockTags.SUPPORTS_SUGAR_CANE,
                BlockTags.BENEATH_BAMBOO_PODZOL_REPLACEABLE,
                BlockTags.SUPPORTS_NETHER_SPROUTS,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.SUPPORTS_MELON_STEM_FRUIT,
                BlockTags.FOREST_ROCK_CAN_PLACE_ON,
                BlockTags.SUPPORTS_BAMBOO,
                BlockTags.SUPPORTS_WARPED_FUNGUS,
                BlockTags.SUPPORTS_PUMPKIN_STEM_FRUIT,
                BlockTags.CANNOT_REPLACE_BELOW_TREE_TRUNK,
                BlockTags.SUPPORTS_WITHER_ROSE,
                BlockTags.SUBSTRATE_OVERWORLD,
                BlockTags.SUPPORTS_BIG_DRIPLEAF,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.SUPPORTS_WARPED_ROOTS,
                BlockTags.SUPPORTS_VEGETATION,
                BlockTags.SUPPORTS_SMALL_DRIPLEAF,
                BlockTags.MOSS_BLOCKS,
                BlockTags.MOSS_REPLACEABLE,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.SCULK_REPLACEABLE_WORLD_GEN,
                BlockTags.BLOCKS_MOTION,
                BlockTags.HUGE_RED_MUSHROOM_CAN_PLACE_ON,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.SUPPORTS_CRIMSON_FUNGUS,
                BlockTags.ENDERMAN_HOLDABLE,
                BlockTags.SUPPORTS_MANGROVE_PROPAGULE,
                BlockTags.AZALEA_ROOT_REPLACEABLE,
                BlockTags.ICE_SPIKE_REPLACEABLE,
                BlockTags.SNIFFER_EGG_HATCH_BOOST,
                BlockTags.SUPPORTS_AZALEA,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.SNIFFER_DIGGABLE_BLOCK,
                BlockTags.SUPPORTS_DRY_VEGETATION,
                BlockTags.BENEATH_TREE_PODZOL_REPLACEABLE,
                BlockTags.HUGE_BROWN_MUSHROOM_CAN_PLACE_ON,
                BlockTags.SUPPORTS_CRIMSON_ROOTS,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.LUSH_GROUND_REPLACEABLE
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.YELLOW_MOSS),
                BlockTags.AZALEA_GROWS_ON,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.SCULK_REPLACEABLE,
                BlockTags.SUPPORTS_STEM_FRUIT,
                BlockTags.SUPPORTS_SUGAR_CANE,
                BlockTags.BENEATH_BAMBOO_PODZOL_REPLACEABLE,
                BlockTags.SUPPORTS_NETHER_SPROUTS,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.SUPPORTS_MELON_STEM_FRUIT,
                BlockTags.FOREST_ROCK_CAN_PLACE_ON,
                BlockTags.SUPPORTS_BAMBOO,
                BlockTags.SUPPORTS_WARPED_FUNGUS,
                BlockTags.SUPPORTS_PUMPKIN_STEM_FRUIT,
                BlockTags.CANNOT_REPLACE_BELOW_TREE_TRUNK,
                BlockTags.SUPPORTS_WITHER_ROSE,
                BlockTags.SUBSTRATE_OVERWORLD,
                BlockTags.SUPPORTS_BIG_DRIPLEAF,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.SUPPORTS_WARPED_ROOTS,
                BlockTags.SUPPORTS_VEGETATION,
                BlockTags.SUPPORTS_SMALL_DRIPLEAF,
                BlockTags.MOSS_BLOCKS,
                BlockTags.MOSS_REPLACEABLE,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.SCULK_REPLACEABLE_WORLD_GEN,
                BlockTags.BLOCKS_MOTION,
                BlockTags.HUGE_RED_MUSHROOM_CAN_PLACE_ON,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.SUPPORTS_CRIMSON_FUNGUS,
                BlockTags.ENDERMAN_HOLDABLE,
                BlockTags.SUPPORTS_MANGROVE_PROPAGULE,
                BlockTags.AZALEA_ROOT_REPLACEABLE,
                BlockTags.ICE_SPIKE_REPLACEABLE,
                BlockTags.SNIFFER_EGG_HATCH_BOOST,
                BlockTags.SUPPORTS_AZALEA,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.SNIFFER_DIGGABLE_BLOCK,
                BlockTags.SUPPORTS_DRY_VEGETATION,
                BlockTags.BENEATH_TREE_PODZOL_REPLACEABLE,
                BlockTags.HUGE_BROWN_MUSHROOM_CAN_PLACE_ON,
                BlockTags.SUPPORTS_CRIMSON_ROOTS,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.LUSH_GROUND_REPLACEABLE
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.RED_MOSS_CARPET),
                BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH,
                BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH,
                BlockTags.WASHED_AWAY_BY_FLUIDS,
                BlockTags.COMBINATION_STEP_SOUND_BLOCKS
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.ORANGE_MOSS_CARPET),
                BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH,
                BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH,
                BlockTags.WASHED_AWAY_BY_FLUIDS,
                BlockTags.COMBINATION_STEP_SOUND_BLOCKS
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.YELLOW_MOSS_CARPET),
                BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH,
                BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH,
                BlockTags.WASHED_AWAY_BY_FLUIDS,
                BlockTags.COMBINATION_STEP_SOUND_BLOCKS
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.YELLOW_SHRUB),
                BlockTags.WASHED_AWAY_BY_FLUIDS,
                BlockTags.ENCHANTMENT_POWER_TRANSMITTER,
                BlockTags.REPLACEABLE,
                BlockTags.REPLACEABLE_BY_MUSHROOMS
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.ORANGE_SHRUB),
                BlockTags.WASHED_AWAY_BY_FLUIDS,
                BlockTags.ENCHANTMENT_POWER_TRANSMITTER,
                BlockTags.REPLACEABLE,
                BlockTags.REPLACEABLE_BY_MUSHROOMS
        );
    }
}
