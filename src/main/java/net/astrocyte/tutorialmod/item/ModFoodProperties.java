package net.astrocyte.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties GLIZZY = new FoodProperties.Builder().nutrition(6).saturationModifier(0.8F)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 200), 1f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 1), 1f)
            .build();
}

