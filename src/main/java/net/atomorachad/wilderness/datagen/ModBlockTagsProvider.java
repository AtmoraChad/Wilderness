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
    }
}
