package com.rrop.eatermod.item.custom;

import com.rrop.eatermod.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.world.World;

import java.util.List;

public class SoulAmuletItem extends Item{

    public SoulAmuletItem(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand){
        if(entity instanceof CowEntity){
            giveSoulItem(user, stack, ModItems.COW_SOUL);
        }
        if(entity instanceof ChickenEntity){
            giveSoulItem(user, stack, ModItems.CHICKEN_SOUL);
        }
        if(entity instanceof SpiderEntity){
            giveSoulItem(user, stack, ModItems.SPIDER_SOUL);
        }
        if(entity instanceof SkeletonEntity){
            giveSoulItem(user, stack, ModItems.SKELETON_SOUL);
        }
        if(entity instanceof IronGolemEntity){
            giveSoulItem(user, stack, ModItems.GOLEM_SOUL);
        }
        if(entity instanceof EndermanEntity){
            giveSoulItem(user, stack, ModItems.ENDER_SOUL);
        }
        if(entity instanceof BlazeEntity){
            giveSoulItem(user, stack, ModItems.BLAZE_SOUL);
        }
        return ActionResult.SUCCESS;
    }

    private void giveSoulItem(PlayerEntity player, ItemStack stack, Item soulItem){
        World world = player.getWorld();

        if(!world.isClient){
            ItemStack itemStack = new ItemStack(soulItem);
            player.getInventory().insertStack(itemStack);

            stack.damage(1, ((ServerWorld) world), ((ServerPlayerEntity) player),
                    item -> player.sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
            world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.PLAYERS);
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.eatermod.soul_amulet.shift_down"));
            tooltip.add(Text.translatable("tooltip.eatermod.soul_amulet.shift_down1"));
        } else{
            tooltip.add(Text.translatable("tooltip.eatermod.soul_amulet"));
            tooltip.add(Text.translatable("tooltip.eatermod.soul_amulet1"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}