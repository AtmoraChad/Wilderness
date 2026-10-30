package net.atomorachad.wilderness.variant;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.animal.chicken.ChickenVariant;

public class ModChickenVariants {

    public static final ResourceKey<ChickenVariant> TURKEY = ResourceKey.create(Registries.CHICKEN_VARIANT, Identifier.fromNamespaceAndPath("wilderness", "turkey"));
}