
package net.atomorachad.wilderness.mixin;

import net.atomorachad.wilderness.variant.FoxRenderStateAccess;
import net.atomorachad.wilderness.variant.FoxVariant;
import net.atomorachad.wilderness.variant.FoxVariantAccess;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.FoxRenderer;
import net.minecraft.client.renderer.entity.state.FoxRenderState;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.fox.Fox;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FoxRenderer.class)
public abstract class FoxRendererMixin {

    @Inject(method = "extractRenderState", at = @At("TAIL"))
    private void wilderness$extractVariant(
            Fox entity,
            FoxRenderState state,
            float partialTick,
            CallbackInfo ci
    ) {
        Identifier id = ((FoxVariantAccess) entity).wilderness$getVariantId();
        ((FoxRenderStateAccess) state).wilderness$setVariantId(id);
    }

    @Inject(method = "getTextureLocation", at = @At("HEAD"), cancellable = true)
    private void wilderness$useVariantTexture(
            FoxRenderState state,
            CallbackInfoReturnable<Identifier> cir
    ) {
        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.level == null) {
            return;
        }

        Identifier id = ((FoxRenderStateAccess) state).wilderness$getVariantId();

        Registry<FoxVariant> registry = minecraft.level.registryAccess()
                .lookupOrThrow(FoxVariant.REGISTRY_KEY);

        Holder.Reference<FoxVariant> holder = registry.get(id).orElse(null);

        if (holder == null) {
            return;
        }

        FoxVariant variant = holder.value();
        boolean baby = state.isBaby;
        boolean sleeping = state.isSleeping;

        FoxVariant.Assets assets = baby
                ? variant.babyAssets()
                : variant.assets();

        Identifier texture = sleeping
                ? assets.sleeping()
                : assets.normal();

        cir.setReturnValue(Identifier.fromNamespaceAndPath(
                texture.getNamespace(),
                "textures/" + texture.getPath() + ".png"
        ));
    }
}
