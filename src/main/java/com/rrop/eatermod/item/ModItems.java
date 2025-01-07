package com.rrop.eatermod.item;

import com.rrop.eatermod.EaterMod;
import com.rrop.eatermod.item.custom.SoulAmuletItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {

    public static final Item SOUL_GEMSTONE = registerItem("soul_gemstone", new Item(new Item.Settings()));
    public static final Item RAW_SOUL_GEMSTONE = registerItem("raw_soul_gemstone", new Item(new Item.Settings()));

    public static final Item COW_SOUL = registerItem("cow_soul", new Item(new Item.Settings().food(ModFoodComponents.COW_SOUL))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.eatermod.cow_soul.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item CHICKEN_SOUL = registerItem("chicken_soul", new Item(new Item.Settings().food(ModFoodComponents.CHICKEN_SOUL))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.eatermod.chicken_soul.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item SPIDER_SOUL = registerItem("spider_soul", new Item(new Item.Settings().food(ModFoodComponents.SPIDER_SOUL))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.eatermod.spider_soul.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SKELETON_SOUL = registerItem("skeleton_soul", new Item(new Item.Settings().food(ModFoodComponents.SKELETON_SOUL))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.eatermod.skeleton_soul.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item GOLEM_SOUL = registerItem("golem_soul", new Item(new Item.Settings().food(ModFoodComponents.GOLEM_SOUL))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.eatermod.golem_soul.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item ENDER_SOUL = registerItem("ender_soul", new Item(new Item.Settings().food(ModFoodComponents.ENDER_SOUL))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.eatermod.ender_soul.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item BLAZE_SOUL = registerItem("blaze_soul", new Item(new Item.Settings().food(ModFoodComponents.BLAZE_SOUL))
    {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.eatermod.blaze_soul.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item SOUL_AMULET = registerItem("soul_amulet", new SoulAmuletItem(new Item.Settings().maxDamage(5)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(EaterMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        EaterMod.LOGGER.info("Registering Mod Items for " + EaterMod.MOD_ID);
    }
}