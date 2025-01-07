package com.rrop.eatermod;

import com.rrop.eatermod.block.ModBlocks;
import com.rrop.eatermod.effect.ModEffects;
import com.rrop.eatermod.item.ModItemGroups;
import com.rrop.eatermod.item.ModItems;
import com.rrop.eatermod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EaterMod implements ModInitializer {
	public static final String MOD_ID = "eatermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModEffects.registerEffects();

		ModWorldGeneration.generateModWorldGen();
	}
}