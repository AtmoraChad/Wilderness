
package net.atomorachad.wilderness.mixin;

import net.atomorachad.wilderness.variant.FoxVariant;
import net.atomorachad.wilderness.variant.FoxVariantAccess;
import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.fox.Fox;
import net.minecraft.world.entity.variant.SpawnContext;
import net.minecraft.world.entity.variant.VariantUtils;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Fox.class)
public abstract class FoxVariantMixin implements FoxVariantAccess {

    @Unique
    private static final EntityDataAccessor<String> WILDERNESS_VARIANT_ID =
            SynchedEntityData.defineId(
                    Fox.class,
                    EntityDataSerializers.STRING
            );

    @Inject(method = "defineSynchedData", at = @At("TAIL"))
    private void wilderness$defineVariantData(
            SynchedEntityData.Builder builder,
            CallbackInfo ci
    ) {
        builder.define(WILDERNESS_VARIANT_ID, "minecraft:red");
    }

    @Override
    public Identifier wilderness$getVariantId() {
        return Identifier.parse(
                ((Fox) (Object) this).getEntityData()
                        .get(WILDERNESS_VARIANT_ID)
        );
    }

    @Override
    public void wilderness$setVariantId(Identifier id) {
        ((Fox) (Object) this).getEntityData()
                .set(WILDERNESS_VARIANT_ID, id.toString());
    }

    @Inject(method = "finalizeSpawn", at = @At("RETURN"))
    private void wilderness$selectVariant(
            ServerLevelAccessor level,
            DifficultyInstance difficulty,
            EntitySpawnReason spawnReason,
            SpawnGroupData groupData,
            CallbackInfoReturnable<SpawnGroupData> cir
    ) {
        Fox fox = (Fox) (Object) this;

        SpawnContext context = SpawnContext.create(
                level,
                fox.blockPosition()
        );

        VariantUtils.selectVariantToSpawn(
                context,
                FoxVariant.REGISTRY_KEY
        ).ifPresent(holder ->
                wilderness$setVariantId(
                        holder.unwrapKey()
                                .orElseThrow()
                                .identifier()
                )
        );
    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void wilderness$saveVariant(
            ValueOutput output,
            CallbackInfo ci
    ) {
        output.store(
                "WildernessVariant",
                Identifier.CODEC,
                wilderness$getVariantId()
        );
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void wilderness$loadVariant(
            ValueInput input,
            CallbackInfo ci
    ) {
        input.read("WildernessVariant", Identifier.CODEC)
                .ifPresent(this::wilderness$setVariantId);
    }


    @Inject(method = "getBreedOffspring", at = @At("RETURN"))
    private void wilderness$inheritVariant(
            ServerLevel level,
            AgeableMob partner,
            CallbackInfoReturnable<Fox> cir
    ) {
        Fox baby = cir.getReturnValue();

        if (baby == null || !(partner instanceof Fox other)) {
            return;
        }

        Fox parent = (Fox) (Object) this;

        Identifier inheritedId = parent.getRandom().nextBoolean()
                ? ((FoxVariantAccess) parent).wilderness$getVariantId()
                : ((FoxVariantAccess) other).wilderness$getVariantId();

        ((FoxVariantAccess) baby).wilderness$setVariantId(inheritedId);
    }

}
