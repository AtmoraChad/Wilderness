package net.atomorachad.wilderness.datagen;

import net.atomorachad.wilderness.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        dropSelf(ModBlocks.CREAM_PUMPKIN);
        dropSelf(ModBlocks.CARVED_CREAM_PUMPKIN);
        dropSelf(ModBlocks.CREAM_JACK_O_LANTERN);

        dropSelf(ModBlocks.ORANGE_SHRUB);
        dropSelf(ModBlocks.YELLOW_SHRUB);

        otherWhenSilkTouch(ModBlocks.DAPPLED_GRASS, Blocks.DIRT);
    }
}
