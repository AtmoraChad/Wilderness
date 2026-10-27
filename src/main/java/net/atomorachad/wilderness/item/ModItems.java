package net.atomorachad.wilderness.item;

import net.atomorachad.wilderness.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.atomorachad.wilderness.WildernessFalls;


import java.util.function.Function;

public class ModItems {

    public static final Item ORANGE_SHRUB = registerItem("orange_shrub",
            properties -> new BlockItem(ModBlocks.ORANGE_SHRUB,
                    properties.useItemDescriptionPrefix()));

    public static final Item YELLOW_SHRUB = registerItem("yellow_shrub",
            properties -> new BlockItem(ModBlocks.YELLOW_SHRUB,
                    properties.useItemDescriptionPrefix()));

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name)))));
    }

    private static Item registerSpawnEgg(String name, EntityType<?> type) {
        return registerItem(name, properties -> new SpawnEggItem(
                properties.spawnEgg(type)));
    }

    public static void registerModItems() {
        WildernessFalls.LOGGER.info("Registering Mod Items for" + WildernessFalls.MOD_ID);
    }
}
