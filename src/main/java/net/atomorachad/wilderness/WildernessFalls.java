package net.atomorachad.wilderness;

import net.atomorachad.wilderness.block.ModBlocks;
import net.atomorachad.wilderness.creativetab.ModCreativeTabs;
import net.atomorachad.wilderness.item.ModItems;
import net.atomorachad.wilderness.worldgen.feature.ModFeatures;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WildernessFalls implements ModInitializer {
	public static final String MOD_ID = "wilderness";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Booting into Wilderness Falls");

		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModCreativeTabs.registerModCreativeModeTabs();
		ModFeatures.registerModFeatures();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
