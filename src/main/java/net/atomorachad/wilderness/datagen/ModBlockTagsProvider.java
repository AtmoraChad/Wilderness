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
                .add(ModBlocks.getRK(ModBlocks.DAPPLED_GRASS))

        ;

        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.getRK(ModBlocks.CREAM_PUMPKIN))
                .add(ModBlocks.getRK(ModBlocks.CARVED_CREAM_PUMPKIN))
                .add(ModBlocks.getRK(ModBlocks.CREAM_JACK_O_LANTERN))
        ;

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

        addToTags(
                ModBlocks.getRK(ModBlocks.CREAM_PUMPKIN),
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.SWORD_EFFICIENT,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.ENDERMAN_HOLDABLE,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.BLOCKS_MOTION
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.CARVED_CREAM_PUMPKIN),
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.SWORD_EFFICIENT,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.ENDERMAN_HOLDABLE,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.BLOCKS_MOTION
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.CREAM_JACK_O_LANTERN),
                BlockTags.SWORD_EFFICIENT,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.BLOCKS_MOTION,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD
        );

        addToTags(
                ModBlocks.getRK(ModBlocks.DAPPLED_GRASS),
                BlockTags.AZALEA_GROWS_ON,
                BlockTags.SUPPORTS_VEGETATION,
                BlockTags.GOATS_SPAWNABLE_ON,
                BlockTags.BLOCKS_LAVA_FIRE_SPREAD,
                BlockTags.TURNS_INTO_DIRT_PATH,
                BlockTags.BLOCKS_DOLPHIN_JUMP,
                BlockTags.HUGE_BROWN_MUSHROOM_CAN_PLACE_ON,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP_NO_LEAVES,
                BlockTags.SUPPORTS_CRIMSON_ROOTS,
                BlockTags.SCULK_REPLACEABLE,
                BlockTags.ENTITIES_CAN_TELEPORT_TO,
                BlockTags.SUBSTRATE_OVERWORLD,
                BlockTags.ICE_MELTS_WHEN_DESTROYED_ABOVE,
                BlockTags.ENDERMAN_HOLDABLE,
                BlockTags.SCULK_REPLACEABLE_WORLD_GEN,
                BlockTags.SUPPORTS_MELON_STEM_FRUIT,
                BlockTags.FOREST_ROCK_CAN_PLACE_ON,
                BlockTags.ICE_SPIKE_REPLACEABLE,
                BlockTags.TURNS_INTO_FARMLAND,
                BlockTags.SUPPORTS_AZALEA,
                BlockTags.SUPPORTS_DRY_VEGETATION,
                BlockTags.SUPPORTS_MANGROVE_PROPAGULE,
                BlockTags.CAUSES_SUFFOCATION,
                BlockTags.FOXES_SPAWNABLE_ON,
                BlockTags.GRASS_BLOCKS,
                BlockTags.BLOCKS_MOTION_NO_LEAVES,
                BlockTags.SUPPORTS_BAMBOO,
                BlockTags.SUPPORTS_WARPED_ROOTS,
                BlockTags.WOLVES_SPAWNABLE_ON,
                BlockTags.LUSH_GROUND_REPLACEABLE,
                BlockTags.SUPPORTS_NETHER_SPROUTS,
                BlockTags.ANIMALS_SPAWNABLE_ON,
                BlockTags.SUPPORTS_CRIMSON_FUNGUS,
                BlockTags.VALID_SPAWN,
                BlockTags.SNIFFER_DIGGABLE_BLOCK,
                BlockTags.RABBITS_SPAWNABLE_ON,
                BlockTags.BLOCKS_MOTION,
                BlockTags.PARROTS_SPAWNABLE_ON,
                BlockTags.SUPPORTS_WARPED_FUNGUS,
                BlockTags.BLOCKS_FLUID_FLOW,
                BlockTags.BLOCKS_MOTION_IN_HEIGHTMAP,
                BlockTags.AZALEA_ROOT_REPLACEABLE,
                BlockTags.MOSS_REPLACEABLE,
                BlockTags.SUPPORTS_SUGAR_CANE,
                BlockTags.SUPPORTS_STEM_FRUIT,
                BlockTags.SUPPORTS_PUMPKIN_STEM_FRUIT,
                BlockTags.HUGE_RED_MUSHROOM_CAN_PLACE_ON,
                BlockTags.BENEATH_BAMBOO_PODZOL_REPLACEABLE,
                BlockTags.BENEATH_TREE_PODZOL_REPLACEABLE,
                BlockTags.SUPPORTS_BIG_DRIPLEAF,
                BlockTags.SUPPORTS_WITHER_ROSE,
                BlockTags.FROGS_SPAWNABLE_ON,
                BlockTags.ARMADILLO_SPAWNABLE_ON
        );
    }
}
