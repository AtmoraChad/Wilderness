
package net.atomorachad.wilderness.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import  net.minecraft.core.registries.codec.RegistryCodecs;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.variant.PriorityProvider;
import net.minecraft.world.entity.variant.SpawnContext;
import net.minecraft.world.entity.variant.SpawnCondition;
import net.minecraft.world.entity.variant.SpawnPrioritySelectors;

public record FoxVariant(
        Assets assets,
        Assets babyAssets,
        SpawnPrioritySelectors spawnConditions
) implements PriorityProvider<SpawnContext, SpawnCondition> {

    public static final Codec<FoxVariant> DIRECT_CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    Assets.CODEC.fieldOf("assets").forGetter(FoxVariant::assets),
                    Assets.CODEC.fieldOf("baby_assets").forGetter(FoxVariant::babyAssets),
                    SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(FoxVariant::spawnConditions)).apply(instance, FoxVariant::new));

    public static final ResourceKey<Registry<FoxVariant>> REGISTRY_KEY = ResourceKey.createRegistryKey(
                    Identifier.withDefaultNamespace("fox_variant"));

    public static final Codec<Holder<FoxVariant>> CODEC = RegistryCodecs.holder(REGISTRY_KEY);


    @Override
    public java.util.List<PriorityProvider.Selector<SpawnContext, SpawnCondition>> selectors() {
        return spawnConditions.selectors();
    }


    public record Assets(Identifier normal, Identifier sleeping)
    {
        public static final Codec<Assets> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                        Identifier.CODEC.fieldOf("normal").forGetter(Assets::normal),
                        Identifier.CODEC.fieldOf("sleeping").forGetter(Assets::sleeping)).apply(instance, Assets::new));
    }
}
