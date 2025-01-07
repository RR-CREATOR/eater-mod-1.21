package com.rrop.eatermod.effect;

import com.rrop.eatermod.EaterMod;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> EGGY = registerStatusEffect("eggy",
            new EggyEffect(StatusEffectCategory.NEUTRAL, 0xFFFFFF));
    public static final RegistryEntry<StatusEffect> WEBBY = registerStatusEffect("webby",
            new WebbyEffect(StatusEffectCategory.NEUTRAL, 0xFFFFFF));
    public static final RegistryEntry<StatusEffect> SPIDEY = registerStatusEffect("spidey",
            new SpideyEffect(StatusEffectCategory.NEUTRAL, 0x000000));
    public static final RegistryEntry<StatusEffect> SHOOTEY = registerStatusEffect("shootey",
            new ShooteyEffect(StatusEffectCategory.NEUTRAL, 0xA52A2A));
    public static final RegistryEntry<StatusEffect> ENDY = registerStatusEffect("endy",
            new EndyEffect(StatusEffectCategory.NEUTRAL, 0x800080));
    public static final RegistryEntry<StatusEffect> FIREY = registerStatusEffect("firey",
            new FireyEffect(StatusEffectCategory.NEUTRAL, 0xFFA500));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(EaterMod.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        EaterMod.LOGGER.info("Registering Mod Effects for " + EaterMod.MOD_ID);
    }
}
