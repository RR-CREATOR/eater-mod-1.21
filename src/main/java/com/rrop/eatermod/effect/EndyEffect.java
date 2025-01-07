package com.rrop.eatermod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.item.Items;

public class EndyEffect extends StatusEffect {

    private boolean hasThrown = false;

    public EndyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player) {
            World world = player.getWorld();

            if (player.isSneaking() && !hasThrown) {
                Vec3d lookVec = player.getRotationVec(1.0F);
                EnderPearlEntity enderPearl = new EnderPearlEntity(world, player);
                enderPearl.setVelocity(lookVec.x, lookVec.y, lookVec.z, 1.5F, 1.0F);
                world.spawnEntity(enderPearl);
                player.getItemCooldownManager().set(Items.ENDER_PEARL, 20);
                hasThrown = true;
                return true;
            }

            if (!player.isSneaking()) {
                hasThrown = false;
            }
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}