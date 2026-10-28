package net.atomorachad.wilderness.datagen;

import net.atomorachad.wilderness.block.ModBlocks;
import net.atomorachad.wilderness.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        


        tag(ModTags.Items.PUMPKINS)
                .add(ModBlocks.getItemRK(ModBlocks.CREAM_PUMPKIN))
                .add(ModBlocks.getItemRK(Blocks.PUMPKIN))
        ;
    }
}
