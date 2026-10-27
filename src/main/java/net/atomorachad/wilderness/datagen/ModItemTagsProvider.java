package net.atomorachad.wilderness.datagen;

import net.atomorachad.wilderness.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        

        tag(ItemTags.MOSS_BLOCKS)
                .add(ModBlocks.getItemRK(ModBlocks.RED_MOSS))
                .add(ModBlocks.getItemRK(ModBlocks.ORANGE_MOSS))
                .add(ModBlocks.getItemRK(ModBlocks.YELLOW_MOSS))
        ;
    }
}
