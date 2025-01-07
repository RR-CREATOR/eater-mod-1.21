package com.rrop.eatermod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShooteyEffect extends StatusEffect {

    private int tickCounter = 0;

    public ShooteyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player) {
            World world = player.getWorld();
            if (player.isUsingItem() && player.getActiveHand() == Hand.MAIN_HAND) {
                ItemStack bow = player.getStackInHand(Hand.MAIN_HAND);
                if (bow.getItem() instanceof BowItem) {
                    tickCounter++;
                    if (tickCounter >= 2) {
                        tickCounter = 0;
                        Vec3d lookVec = player.getRotationVec(1.0F);
                        ItemStack arrows = new ItemStack(net.minecraft.item.Items.ARROW);

                        PersistentProjectileEntity arrow = new ArrowEntity(world, player, arrows, bow);
                        arrow.setVelocity(lookVec.x, lookVec.y, lookVec.z, 3.0F, 1.0F);
                        arrow.setCritical(true);

                        world.spawnEntity(arrow);
                        return true;
                    }
                }
            } else {
                tickCounter = 0;
            }
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
