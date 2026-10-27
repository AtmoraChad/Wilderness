package net.atomorachad.wilderness.datagen;

import net.atomorachad.wilderness.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipeContext,
            BootstrapContext<Advancement> advancementContext) {
        return new RecipeProvider(recipeContext, advancementContext) {

            @Override
            public void buildRecipes() {


                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_MOSS_CARPET, 3)
                        .pattern("RR")
                        .define('R', ModBlocks.RED_MOSS)
                        .unlockedBy(getHasName(ModBlocks.RED_MOSS), has(ModBlocks.RED_MOSS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_MOSS_CARPET, 3)
                        .pattern("RR")
                        .define('R', ModBlocks.ORANGE_MOSS)
                        .unlockedBy(getHasName(ModBlocks.ORANGE_MOSS), has(ModBlocks.ORANGE_MOSS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_MOSS_CARPET, 3)
                        .pattern("RR")
                        .define('R', ModBlocks.YELLOW_MOSS)
                        .unlockedBy(getHasName(ModBlocks.YELLOW_MOSS), has(ModBlocks.YELLOW_MOSS))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "Overworld Revisited " +
                "Recipes";
    }
}