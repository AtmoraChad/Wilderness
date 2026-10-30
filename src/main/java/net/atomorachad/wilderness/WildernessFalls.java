package net.atomorachad.wilderness;

import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.atomorachad.wilderness.block.ModBlocks;
import net.atomorachad.wilderness.client.SubstrateTintSources;
import net.atomorachad.wilderness.creativetab.ModCreativeTabs;
import net.atomorachad.wilderness.entity.ModEntities;
import net.atomorachad.wilderness.entity.custom.BrownBearEntity;
import net.atomorachad.wilderness.item.ModItems;
import net.atomorachad.wilderness.variant.ModChickenVariants;
import net.atomorachad.wilderness.variant.WildernessVariantRegistries;
import net.atomorachad.wilderness.worldgen.DappledForestMaterialRules;
import net.atomorachad.wilderness.worldgen.feature.ModFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.chicken.ChickenVariant;
import net.minecraft.world.level.levelgen.Heightmap;
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
		SubstrateTintSources.registerModBlockTint();
		WildernessVariantRegistries.initialize();
		ModEntities.registerModEntities();

		SurfaceGeneration.addOverworldSurfaceRules(
				Identifier.fromNamespaceAndPath("minecraft", "dappled_forest"),
				DappledForestMaterialRules::dappledForest
		);

		FabricDefaultAttributeRegistry.register(ModEntities.BROWN_BEAR, BrownBearEntity.createAttributes());

		SpawnPlacements.register(ModEntities.BROWN_BEAR, SpawnPlacementTypes.ON_GROUND,
				Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, BrownBearEntity::checkBrownBearSpawnRules);
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
