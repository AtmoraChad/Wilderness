package net.atomorachad.wilderness.entity;

import net.atomorachad.wilderness.WildernessFalls;
import net.atomorachad.wilderness.entity.custom.BrownBearEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    public static final ResourceKey<EntityType<?>> BROWN_BEAR_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, "brown_bear"));

    public static final EntityType<BrownBearEntity> BROWN_BEAR = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, "brown_bear"),
            EntityType.Builder.of(BrownBearEntity::new, MobCategory.CREATURE).sized(1.4f, 1.4f).build(BROWN_BEAR_KEY));


    public static void registerModEntities() {
        WildernessFalls.LOGGER.info("Registering Mod Entities for " + WildernessFalls.MOD_ID);
    }
}
