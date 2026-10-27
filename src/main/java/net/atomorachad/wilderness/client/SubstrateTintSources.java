
package net.atomorachad.wilderness.client;

import java.util.List;
import java.util.Set;

import net.atomorachad.wilderness.block.ModBlocks;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ARGB;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Property;

public final class SubstrateTintSources {
    private SubstrateTintSources() {}

    private static int substrateTint(BlockState substrate) {
        if (substrate.is(ModBlocks.RED_MOSS)) {
            return ARGB.opaque(0xa92f21);
        }

        if (substrate.is(ModBlocks.YELLOW_MOSS)) {
            return ARGB.opaque(0xff9c12);
        }

        if (substrate.is(ModBlocks.ORANGE_MOSS)) {
            return ARGB.opaque(0xdf6827);
        }

        // No special tint: preserve the normal biome grass color.
        return -1;
    }

    private static final BlockTintSource SINGLE_PLANT_TINT =
            new BlockTintSource() {
        @Override
        public int color(BlockState state) {
            return ARGB.opaque(GrassColor.getDefaultColor());
        }

        @Override
        public int colorInWorld(
                BlockState state,
                BlockAndTintGetter level,
                BlockPos pos
        ) {
            int tint = substrateTint(
                    level.getBlockState(pos.below())
            );

            return tint != -1
                    ? tint
                    : BiomeColors.getAverageGrassColor(level, pos);
        }
    };

    private static final BlockTintSource TALL_PLANT_TINT =
            new BlockTintSource() {
        @Override
        public int color(BlockState state) {
            return ARGB.opaque(GrassColor.getDefaultColor());
        }

        @Override
        public int colorInWorld(
                BlockState state,
                BlockAndTintGetter level,
                BlockPos pos
        ) {
            boolean upper = state.getValue(DoublePlantBlock.HALF)
                    == DoubleBlockHalf.UPPER;

            BlockPos substratePos = upper
                    ? pos.below(2)
                    : pos.below();

            int tint = substrateTint(
                    level.getBlockState(substratePos)
            );

            if (tint != -1) {
                return tint;
            }

            // Use the lower half's position for the normal biome tint.
            BlockPos colorPos = upper ? pos.below() : pos;
            return BiomeColors.getAverageGrassColor(level, colorPos);
        }

        @Override
        public Set<Property<?>> relevantProperties() {
            return Set.of(DoublePlantBlock.HALF);
        }
    };

    public static void register() {
        BlockColorRegistry.register(
                List.of(SINGLE_PLANT_TINT),
                Blocks.SHORT_GRASS,
                Blocks.FERN,
                Blocks.BUSH
        );

        BlockColorRegistry.register(
                List.of(TALL_PLANT_TINT),
                Blocks.TALL_GRASS,
                Blocks.LARGE_FERN
        );
    }
}
