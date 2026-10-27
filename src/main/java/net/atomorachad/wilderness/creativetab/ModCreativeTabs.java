package net.atomorachad.wilderness.creativetab;

import net.atomorachad.wilderness.WildernessFalls;
import net.atomorachad.wilderness.block.ModBlocks;
import net.atomorachad.wilderness.item.ModItems;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

    public static final CreativeModeTab OR_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, "wilderness_tab"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RED_MOSS))
                    .title(Component.translatable("creativemodetab.wilderness.wilderness_blocks"))
                    .displayItems((parameters, output) -> {

                        output.accept(ModBlocks.RED_MOSS);
                        output.accept(ModBlocks.RED_MOSS_CARPET);
                        output.accept(ModBlocks.ORANGE_MOSS);
                        output.accept(ModBlocks.ORANGE_MOSS_CARPET);
                        output.accept(ModBlocks.YELLOW_MOSS);
                        output.accept(ModBlocks.YELLOW_MOSS_CARPET);

                        output.accept(ModItems.ORANGE_SHRUB);
                        output.accept(ModItems.YELLOW_SHRUB);

                    }).build());

    public static void registerModCreativeModeTabs() {
        WildernessFalls.LOGGER.info("Registering Creative Mode Tabs for " + WildernessFalls.MOD_ID);
    }
}