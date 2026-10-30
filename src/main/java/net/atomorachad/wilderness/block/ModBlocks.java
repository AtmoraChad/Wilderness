package net.atomorachad.wilderness.block;

import net.atomorachad.wilderness.WildernessFalls;
import net.atomorachad.wilderness.block.blocktype.CreamPumpkinBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProvider;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;


import java.util.function.Function;

public class ModBlocks {


    public static final Block ORANGE_SHRUB = registerBlockWithoutItem("orange_shrub",
            properties -> new BushBlock(properties.mapColor(MapColor.COLOR_ORANGE).replaceable().noCollision().instabreak().sound(SoundType.RED_SHRUB).ignitedByLava().pushReaction(PushReaction.POPPED)));

    public static final Block YELLOW_SHRUB = registerBlockWithoutItem("yellow_shrub",
            properties -> new BushBlock(properties.mapColor(MapColor.COLOR_YELLOW).replaceable().noCollision().instabreak().sound(SoundType.RED_SHRUB).ignitedByLava().pushReaction(PushReaction.POPPED)));


    public static final Block CREAM_PUMPKIN = registerCompostableBlock("cream_pumpkin",
            properties -> new CreamPumpkinBlock(properties.mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED)), ContextIntProviders.COMPOSTABLE_MEDIUM);

    public static final Block CARVED_CREAM_PUMPKIN = registerCompostableBlock("carved_cream_pumpkin",
            properties -> new CarvedPumpkinBlock(properties.mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0F).sound(SoundType.WOOD).pushReaction(PushReaction.POPPED)), ContextIntProviders.COMPOSTABLE_MEDIUM);

    public static final Block CREAM_JACK_O_LANTERN = registerBlock("cream_jack_o_lantern",
            properties -> new CarvedPumpkinBlock(properties.mapColor(MapColor.TERRACOTTA_WHITE).instrument(NoteBlockInstrument.DIDGERIDOO).strength(1.0F).sound(SoundType.WOOD).lightLevel(state -> 15).isValidSpawn(Blocks::always).pushReaction(PushReaction.POPPED)));


    public static final Block DAPPLED_GRASS = registerBlock("dappled_grass_block",
            properties -> new GrassBlock(properties.mapColor(MapColor.COLOR_ORANGE).strength(0.6F).sound(SoundType.GRASS).randomTicks()));


    public static ResourceKey<Block> getRK(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    public static ResourceKey<Item> getItemRK(Block block) {
        Identifier id = BuiltInRegistries.BLOCK.getKey(block);
        return ResourceKey.create(Registries.ITEM, id);
    }

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name)))));
    }

    private static Block registerBlockWithoutItem(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name))));
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name), toRegister);
    }

    public static void registerModBlocks() {
        WildernessFalls.LOGGER.info("Registering Mod Blocks for " + WildernessFalls.MOD_ID);
    }

    private static Block registerCompostableBlock(String name, Function<BlockBehaviour.Properties, Block> function, ResourceKey<ContextIntProvider> layers) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name))));
        registerCompostableBlockItem(name, toRegister, layers);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name), toRegister);
    }

    private static void registerCompostableBlockItem(String name, Block block, ResourceKey<ContextIntProvider> layers) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().compostable(layers)
                        .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name)))));
    }
}
