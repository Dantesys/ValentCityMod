package com.dantesys.valentcitymod.event;

import com.dantesys.valentcitymod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;

import java.util.Objects;

public class ModEvents {
    private static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public void foidef(LivingDeathEvent event){
        Entity fontedano = event.getSource().getEntity();
        System.out.println(fontedano);
        LOGGER.info("AQUI",fontedano);
        if(fontedano instanceof LivingEntity atacante){
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
                    if(max<400){
                        player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(max+4);
                        Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(max+4);
                        player.setHealth((float) (max+4));
                    }
                }else if(player.getMainHandItem().is(ModItems.GUERREIROPR.get())){
                    double max = Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).getBaseValue();
                    if(max<100){
                        player.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(max+1);
                        Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(max+1);
                    }
                }else if(player.getMainHandItem().is(ModItems.GUERREIROR.get())){
                    double max = Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).getBaseValue();
                    if(max<200){
                        player.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(max+2);
                        Objects.requireNonNull(player.getAttribute(Attributes.ATTACK_DAMAGE)).setBaseValue(max+2);
                    }
                }
            }
        }
    }
}
