package com.rrop.eatermod.effect;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class FireyEffect extends StatusEffect {

    private int tickCounter = 0;

    public FireyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof ServerPlayerEntity player) {
            World world = player.getWorld();

            if (player.isSneaking()) {
                tickCounter++;
                if (tickCounter >= 5) {
                    tickCounter = 0;
                    Vec3d lookVec = player.getRotationVec(1.0F);
                    FireballEntity fireball = new FireballEntity(world, player, lookVec, 1);
                    fireball.setPosition(player.getX() + lookVec.x, player.getEyeY() + lookVec.y, player.getZ() + lookVec.z);
                    world.spawnEntity(fireball);
                }
                return true;
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
