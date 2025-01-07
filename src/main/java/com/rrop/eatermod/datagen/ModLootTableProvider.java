package com.rrop.eatermod.datagen;

import com.rrop.eatermod.block.ModBlocks;
import com.rrop.eatermod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RAW_SOUL_GEMSTONE_ORE, oreDrops(ModBlocks.RAW_SOUL_GEMSTONE_ORE, ModItems.RAW_SOUL_GEMSTONE));
        addDrop(ModBlocks.RAW_SOUL_GEMSTONE_DEEPSLATE_ORE, oreDrops(ModBlocks.RAW_SOUL_GEMSTONE_DEEPSLATE_ORE, ModItems.RAW_SOUL_GEMSTONE));
    }
}
