package net.atomorachad.wilderness.item;

import net.atomorachad.wilderness.block.ModBlocks;
import net.atomorachad.wilderness.entity.ModEntities;
import net.atomorachad.wilderness.variant.ModChickenVariants;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.chicken.ChickenVariants;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.EggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.atomorachad.wilderness.WildernessFalls;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;


import java.util.function.Function;

public class ModItems {

    public static final Item ORANGE_SHRUB = registerItem("orange_shrub", properties -> new BlockItem(ModBlocks.ORANGE_SHRUB, properties.useItemDescriptionPrefix().compostable(ContextIntProviders.COMPOSTABLE_LOW)));

    public static final Item YELLOW_SHRUB = registerItem("yellow_shrub", properties -> new BlockItem(ModBlocks.YELLOW_SHRUB, properties.useItemDescriptionPrefix().compostable(ContextIntProviders.COMPOSTABLE_LOW)));

    public static final Item BROWN_BEAR_EGG = registerSpawnEgg("brown_bear_spawn_egg", ModEntities.BROWN_BEAR);

    public static final Item GRAY_EGG = registerItem("gray_egg", properties -> new EggItem(properties.stacksTo(16).delayedHolderComponent(DataComponents.CHICKEN_VARIANT, ModChickenVariants.TURKEY)));

    public static ResourceKey<Item> getRK(Item item) {return BuiltInRegistries.ITEM.getResourceKey(item).get();}

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
