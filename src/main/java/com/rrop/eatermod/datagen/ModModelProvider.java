package com.rrop.eatermod.datagen;

import com.rrop.eatermod.block.ModBlocks;
import com.rrop.eatermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SOUL_GEMSTONE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SOUL_GEMSTONE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_SOUL_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_GEMSTONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SOUL_AMULET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COW_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPIDER_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SKELETON_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLEM_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDER_SOUL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLAZE_SOUL, Models.GENERATED);
    }
}
