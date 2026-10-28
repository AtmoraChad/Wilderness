package net.atomorachad.wilderness.datagen;

import net.atomorachad.wilderness.block.ModBlocks;
import net.atomorachad.wilderness.tag.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
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


                shaped(RecipeCategory.BUILDING_BLOCKS, Items.PUMPKIN_SEEDS, 4)
                        .pattern("R")
                        .define('R', ModBlocks.CREAM_PUMPKIN)
                        .unlockedBy(getHasName(ModBlocks.CREAM_PUMPKIN), has(ModBlocks.CREAM_PUMPKIN))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CREAM_JACK_O_LANTERN, 1)
                        .pattern("P")
                        .pattern("T")
                        .define('P', ModBlocks.CREAM_PUMPKIN)
                        .define('T', Items.TORCH)
                        .unlockedBy(getHasName(ModBlocks.CREAM_PUMPKIN), has(ModBlocks.CREAM_PUMPKIN))
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