package com.dantesys.valentcitymod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CeifadorRelic extends SwordItem {
    public static boolean despertada = false;
    public CeifadorRelic(Tier pTier, Properties pProperties, boolean b) {
        super(pTier, pProperties);
        despertada = b;
    }
    public void postHurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if(despertada){
            pAttacker.heal(4);
        }else{
            pAttacker.heal(2);
        }
        super.postHurtEnemy(pStack,pTarget,pAttacker);
    }
}
