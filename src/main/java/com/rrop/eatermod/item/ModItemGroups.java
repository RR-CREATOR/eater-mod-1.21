package com.rrop.eatermod.item;

import com.rrop.eatermod.EaterMod;
import com.rrop.eatermod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup EAT_STUFF_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(EaterMod.MOD_ID, "eat_stuff_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SOUL_GEMSTONE))
                    .displayName(Text.translatable("itemgroup.eatermod.eat_stuff_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAW_SOUL_GEMSTONE_DEEPSLATE_ORE);
                        entries.add(ModBlocks.RAW_SOUL_GEMSTONE_ORE);
                        entries.add(ModItems.SOUL_GEMSTONE);
                        entries.add(ModItems.RAW_SOUL_GEMSTONE);
                        entries.add(ModItems.SOUL_AMULET);
                        entries.add(ModItems.COW_SOUL);
                        entries.add(ModItems.GOLEM_SOUL);
                        entries.add(ModItems.ENDER_SOUL);
                        entries.add(ModItems.CHICKEN_SOUL);
                        entries.add(ModItems.SPIDER_SOUL);
                        entries.add(ModItems.SKELETON_SOUL);
                        entries.add(ModItems.BLAZE_SOUL);
                    }).build());



    public static void registerItemGroups() {
        EaterMod.LOGGER.info("Registering item groups for " + EaterMod.MOD_ID);
    }
}
