package com.rrop.eatermod.effect;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

public class WebbyEffect extends StatusEffect {

    public WebbyEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.isSneaking() && !entity.getWorld().isClient) {
            ServerWorld world = (ServerWorld) entity.getWorld();
            BlockPos pos = entity.getBlockPos().offset(entity.getHorizontalFacing().getOpposite());

            if (world.getBlockState(pos).isAir()) {
                world.setBlockState(pos, Blocks.COBWEB.getDefaultState());
                return true;
            }
        }

        return super.applyUpdateEffect(entity, amplifier);

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
