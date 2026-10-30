package net.atomorachad.wilderness;

import net.atomorachad.wilderness.entity.ModEntities;
import net.atomorachad.wilderness.entity.client.BrownBearRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.animal.polarbear.PolarBearModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class WildernessFallsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRenderers.register(ModEntities.BROWN_BEAR, BrownBearRenderer::new);

    }
}
