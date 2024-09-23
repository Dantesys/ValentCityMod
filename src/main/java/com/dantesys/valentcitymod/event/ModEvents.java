package com.dantesys.valentcitymod.event;

import com.dantesys.valentcitymod.ValentCityMod;
import com.dantesys.valentcitymod.item.ModItems;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = ValentCityMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    @SubscribeEvent
    public static void segurar(TickEvent.PlayerTickEvent event){
        Player le = event.player;
        ItemStack i = event.player.getMainHandItem();
        if(i.is(ModItems.CEIFADORPR.get()) || i.is(ModItems.CEIFADORR.get())){
            le.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,-1));
            le.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,-1));
            le.addEffect(new MobEffectInstance(MobEffects.GLOWING,-1));
        }else{
            Collection<MobEffectInstance> efeitos = le.getActiveEffects();
            while(!efeitos.isEmpty()){
                MobEffectInstance efeito = efeitos.iterator().next();
                efeitos.remove(efeito);
                if(efeito != null && efeito.getDuration()==-1){
                    le.removeEffect(efeito.getEffect());
                }
            }
        }
    }
    @SubscribeEvent
    public void foidef(LivingDeathEvent event){
        LivingEntity entity =  event.getEntity();
        System.out.println(entity);
        if(entity instanceof Player player){
            if(player.getInventory().contains(ModItems.CEIFADORPR.get().getDefaultInstance()) || player.getInventory().contains(ModItems.CEIFADORR.get().getDefaultInstance())){
                Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(20);
            }
        }else{
            Entity atacante = event.getSource().getEntity();
            System.out.println(atacante);
            if(atacante instanceof Player player){
                if(player.getMainHandItem().is(ModItems.CEIFADORPR.get())){
                    double max = player.getMaxHealth();
                    if(max<200){
                        player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(max+2);
                        Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(max+2);
                        player.setHealth((float) (max+2));
                    }
                }else if(player.getMainHandItem().is(ModItems.CEIFADORR.get())){
                    double max = player.getMaxHealth();
                    if(max<1000){
                        player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(max+4);
                        Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(max+4);
                        player.setHealth((float) (max+4));
                    }
                }
            }
        }
    }
}
