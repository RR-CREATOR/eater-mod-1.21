package com.rrop.eatermod.datagen;

import com.rrop.eatermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SOUL_AMULET, 1)
                .pattern(" L ")
                .pattern("DSD")
                .pattern("DDD")
                .input('L', Items.LEATHER)
                .input('D', Items.DIAMOND)
                .input('S', ModItems.SOUL_GEMSTONE)
                .criterion(hasItem(ModItems.SOUL_GEMSTONE), conditionsFromItem(ModItems.SOUL_GEMSTONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SOUL_GEMSTONE, 1)
                .pattern(" R ")
                .pattern(" A ")
                .pattern(" R ")
                .input('R', ModItems.RAW_SOUL_GEMSTONE)
                .input('A', Items.LAVA_BUCKET)
                .criterion(hasItem(ModItems.RAW_SOUL_GEMSTONE), conditionsFromItem(ModItems.RAW_SOUL_GEMSTONE))
                .offerTo(recipeExporter);
    }
}
