package net.atomorachad.wilderness.entity.client;

import net.atomorachad.wilderness.entity.custom.BrownBearEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.animal.polarbear.PolarBearModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.AgeableMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.PolarBearRenderState;
import net.minecraft.resources.Identifier;

@Environment(EnvType.CLIENT)
public class BrownBearRenderer extends AgeableMobRenderer<BrownBearEntity, PolarBearRenderState, PolarBearModel> {
    private static final Identifier BEAR_LOCATION = Identifier.fromNamespaceAndPath("wilderness", "textures/entity/bear/brown_bear.png");
    private static final Identifier BABY_BEAR_LOCATION = Identifier.fromNamespaceAndPath("wilderness", "textures/entity/bear/brown_bear_baby.png");

    public BrownBearRenderer(final EntityRendererProvider.Context context) {
        super(context, new PolarBearModel(context.bakeLayer(ModelLayers.POLAR_BEAR)), new PolarBearModel(context.bakeLayer(ModelLayers.POLAR_BEAR_BABY)), 0.9F);
    }

    public Identifier getTextureLocation(final PolarBearRenderState state) {
        return state.isBaby ? BABY_BEAR_LOCATION : BEAR_LOCATION;
    }

    public PolarBearRenderState createRenderState() {
        return new PolarBearRenderState();
    }

    public void extractRenderState(final BrownBearEntity entity, final PolarBearRenderState state, final float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
        state.standScale = entity.getStandingAnimationScale(partialTicks);
    }
}
