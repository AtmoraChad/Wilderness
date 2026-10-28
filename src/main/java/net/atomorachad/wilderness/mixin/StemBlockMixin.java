
package net.atomorachad.wilderness.mixin;

import net.atomorachad.wilderness.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(net.minecraft.world.level.block.StemBlock.class)
public abstract class StemBlockMixin {

    @Redirect(
            method = "randomTick", at = @At(
                    value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;setBlockAndUpdate(Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;)Z",
                    ordinal = 0
            )
    )

    private boolean wilderness$placeCreamPumpkin(ServerLevel level, BlockPos fruitPos, BlockState originalState)
    {
        if (originalState.is(Blocks.PUMPKIN) && level.getBiome(fruitPos).is(Biomes.DAPPLED_FOREST)) {
            originalState = ModBlocks.CREAM_PUMPKIN.defaultBlockState();
        }
        return level.setBlockAndUpdate(fruitPos, originalState);
    }
}
