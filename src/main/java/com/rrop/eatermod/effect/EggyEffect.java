package com.rrop.eatermod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EggyEffect extends StatusEffect {

    private static final int SHOOT_INTERVAL = 2;

    public EggyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier){
        if(entity instanceof PlayerEntity player){
            World world = player.getWorld();
            if(!world.isClient){
                if((!player.isOnGround() || player.isSneaking()) && world.getTime() % SHOOT_INTERVAL == 0){
                    shootEgg(world, player);
                    return true;
                }
            }
        }
        return super.applyUpdateEffect(entity, amplifier);
    }

    private void shootEgg(World world, PlayerEntity player){
        Vec3d eyePos = player.getEyePos();
        Vec3d lookVec = player.getRotationVector();

        EggEntity egg = new EggEntity(world, player);
        egg.refreshPositionAndAngles(eyePos.x, eyePos.y, eyePos.z, player.getYaw(), player.getPitch());
        egg.setVelocity(lookVec.multiply(1.5));
        world.spawnEntity(egg);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier){
        return true;
    }
}
