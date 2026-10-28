
package net.atomorachad.wilderness.client;

import java.util.List;

import net.atomorachad.wilderness.block.ModBlocks;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.color.block.BlockTintSources;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ARGB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;

public final class DappledGrassTint {
    private static final int RADIUS = 4;

    // Starting tint target; tune this to match your Dappled Grass texture.
    private static final int ORANGE_TINT = 0xdf6827;

    private DappledGrassTint() {
    }

    public static void registerDappledGrassTint() {
        BlockColorRegistry.register(
                List.of(new BlockTintSource() {
                    @Override
                    public int color(BlockState state) {
                        return BlockTintSources.grass().color(state);
                    }

                    @Override
                    public int colorInWorld(
                            BlockState state,
                            BlockAndTintGetter level,
                            BlockPos pos
                    ) {
                        int vanillaColor =
                                BlockTintSources.grass().colorInWorld(
                                        state, level, pos
                                );

                        int nearestDistance = nearestDappledGrass(
                                level, pos
                        );

                        if (nearestDistance < 0) {
                            return vanillaColor;
                        }

                        // Strongest blend next to Dappled Grass,
                        // fading to the normal biome tint at the radius.
                        float blend = 1.0F
                                - (float) nearestDistance / RADIUS;

                        blend = blend * blend * (3.0F - 2.0F * blend);

                        return blendColors(
                                vanillaColor,
                                ARGB.opaque(ORANGE_TINT),
                                blend
                        );
                    }
                }),
                Blocks.GRASS_BLOCK
        );
    }

    private static int nearestDappledGrass(
            BlockAndTintGetter level,
            BlockPos pos
    ) {
        int nearestSquared = Integer.MAX_VALUE;
        int radiusSquared = RADIUS * RADIUS;

        BlockPos.MutableBlockPos cursor =
                new BlockPos.MutableBlockPos();

        for (int dx = -RADIUS; dx <= RADIUS; dx++) {
            for (int dz = -RADIUS; dz <= RADIUS; dz++) {
                int distanceSquared = dx * dx + dz * dz;

                if (distanceSquared == 0
                        || distanceSquared > radiusSquared
                        || distanceSquared >= nearestSquared) {
                    continue;
                }

                // Account for small height changes on slopes.
                for (int dy = -1; dy <= 1; dy++) {
                    cursor.set(
                            pos.getX() + dx,
                            pos.getY() + dy,
                            pos.getZ() + dz
                    );

                    if (level.getBlockState(cursor)
                            .is(ModBlocks.DAPPLED_GRASS)) {
                        nearestSquared = distanceSquared;
                        break;
                    }
                }
            }
        }

        return nearestSquared == Integer.MAX_VALUE
                ? -1
                : (int) Math.sqrt(nearestSquared);
    }

    private static int blendColors(int from, int to, float amount) {
        int red = Math.round(
                ARGB.red(from) * (1.0F - amount)
                        + ARGB.red(to) * amount
        );
        int green = Math.round(
                ARGB.green(from) * (1.0F - amount)
                        + ARGB.green(to) * amount
        );
        int blue = Math.round(
                ARGB.blue(from) * (1.0F - amount)
                        + ARGB.blue(to) * amount
        );

        return ARGB.opaque(
                (red << 16) | (green << 8) | blue
        );
    }
}
