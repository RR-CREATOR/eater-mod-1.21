package com.rrop.eatermod.item;

import com.rrop.eatermod.effect.ModEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    public static final FoodComponent COW_SOUL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 100), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200), 1.0f)
            .build();

    public static final FoodComponent CHICKEN_SOUL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1200), 1.0f)
            .statusEffect(new StatusEffectInstance(ModEffects.EGGY, 100), 1.0f)
            .build();

    public static final FoodComponent SPIDER_SOUL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(ModEffects.WEBBY, 200), 1.0f)
            .statusEffect(new StatusEffectInstance(ModEffects.SPIDEY, 300), 1.0f)
            .build();

    public static final FoodComponent SKELETON_SOUL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(ModEffects.SHOOTEY, 100), 1.0f)
            .build();

    public static final FoodComponent GOLEM_SOUL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2400, 28), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 4), 1.0f)
            .build();

    public static final FoodComponent ENDER_SOUL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(ModEffects.ENDY, 100), 1.0f)
            .build();

    public static final FoodComponent BLAZE_SOUL = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(ModEffects.FIREY, 100), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200), 1.0f)
            .build();
}
