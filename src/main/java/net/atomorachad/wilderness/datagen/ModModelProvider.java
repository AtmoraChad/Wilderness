package net.atomorachad.wilderness.datagen;


import net.atomorachad.wilderness.block.ModBlocks;
import net.atomorachad.wilderness.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {super(output);}

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {

        blockModelGenerators.createFullAndCarpetBlocks(ModBlocks.RED_MOSS, ModBlocks.RED_MOSS_CARPET);
        blockModelGenerators.createFullAndCarpetBlocks(ModBlocks.ORANGE_MOSS, ModBlocks.ORANGE_MOSS_CARPET);
        blockModelGenerators.createFullAndCarpetBlocks(ModBlocks.YELLOW_MOSS, ModBlocks.YELLOW_MOSS_CARPET);

        blockModelGenerators.createCrossBlock(ModBlocks.YELLOW_SHRUB, BlockModelGenerators.PlantType.NOT_TINTED);
        blockModelGenerators.createCrossBlock(ModBlocks.ORANGE_SHRUB, BlockModelGenerators.PlantType.NOT_TINTED);

    }


    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

        itemModelGenerators.generateFlatItem(ModItems.ORANGE_SHRUB, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.YELLOW_SHRUB, ModelTemplates.FLAT_ITEM);

    }


}
