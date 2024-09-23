package com.dantesys.valentcitymod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class GuerreiroRelic extends SwordItem {
    public static boolean despertada = false;
    public GuerreiroRelic(Tier pTier, Properties pProperties, boolean b) {
        super(pTier, pProperties);
        despertada = b;
    }
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        if(despertada){
            pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,100,2));
            pAttacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,100,2));
            pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,100,2));
            pTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING,100,2));
            pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION,100,2));
        }else{
            pAttacker.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,100,1));
            pAttacker.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,100,1));
            pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,100,1));
            pTarget.addEffect(new MobEffectInstance(MobEffects.GLOWING,100,1));
            pTarget.addEffect(new MobEffectInstance(MobEffects.CONFUSION,100,1));
        }
        super.postHurtEnemy(pStack,pTarget,pAttacker);
    }
}
