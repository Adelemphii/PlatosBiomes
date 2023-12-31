package me.adelemphii.platosbiomes.utility;

import me.adelemphii.platosbiomes.PlatosBiomes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> ARACARA_LOGS = tag("aracara_logs");
        public static final TagKey<Block> ARACARA_WOOD = tag("aracara_wood");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(PlatosBiomes.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {

        public static final TagKey<Item> ARACARA_LOGS = tag("aracara_logs");
        public static final TagKey<Item> ARACARA_WOOD = tag("aracara_wood");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(PlatosBiomes.MODID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }

}
