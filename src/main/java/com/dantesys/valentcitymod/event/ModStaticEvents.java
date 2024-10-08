package com.dantesys.valentcitymod.event;

import com.dantesys.valentcitymod.ValentCityMod;
import com.dantesys.valentcitymod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.Collection;

@Mod.EventBusSubscriber(modid = ValentCityMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModStaticEvents {
    private static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public static void segurar(TickEvent.PlayerTickEvent event){
        Player le = event.player;
        ItemStack i = event.player.getMainHandItem();
        Collection<MobEffectInstance> efeitos = le.getActiveEffects();
        while(!efeitos.isEmpty()){
            MobEffectInstance efeito = efeitos.iterator().next();
            efeitos.remove(efeito);
            if(efeito != null && efeito.getDuration()==-1){
                le.removeEffect(efeito.getEffect());
            }
        }
        if(i.is(ModItems.CEIFADORPR.get()) || i.is(ModItems.CEIFADORR.get())){
            le.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,-1));
            le.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,-1));
            le.addEffect(new MobEffectInstance(MobEffects.GLOWING,-1));
        }else if(i.is(ModItems.CEIFADORPR.get()) || i.is(ModItems.CEIFADORR.get())){
            le.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,-1));
        }
    }
}
