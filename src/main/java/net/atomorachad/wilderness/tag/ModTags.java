package net.atomorachad.wilderness.tag;

import net.atomorachad.wilderness.WildernessFalls;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> PUMPKINS = createTag("pumpkins");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(WildernessFalls.MOD_ID, name));
        }
    }
}
