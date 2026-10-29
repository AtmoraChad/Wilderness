
package net.atomorachad.wilderness.mixin;

import net.atomorachad.wilderness.variant.FoxRenderStateAccess;
import net.minecraft.client.renderer.entity.state.FoxRenderState;
import net.minecraft.resources.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(FoxRenderState.class)
public abstract class FoxRenderStateMixin implements FoxRenderStateAccess {

    @Unique
    private Identifier wilderness$variantId =
            Identifier.withDefaultNamespace("red");

    @Override
    public void wilderness$setVariantId(Identifier id) {
        this.wilderness$variantId = id;
    }

    @Override
    public Identifier wilderness$getVariantId() {
        return this.wilderness$variantId;
    }
}
