package com.dantesys.valentcitymod.event;

import com.dantesys.valentcitymod.ValentCityMod;
import com.dantesys.valentcitymod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = ValentCityMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    public static final HashMap<Player, PlayerTeam> tempTeams = new HashMap<>();
    @SubscribeEvent
    public static void segurar(TickEvent.PlayerTickEvent event){
        Player le = event.player;
        ItemStack i = event.player.getMainHandItem();
        if(i.is(ModItems.CEIFADORPR.get()) || i.is(ModItems.CEIFADORR.get())){
            le.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,-1));
            le.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,-1));
            glowColor(le, ChatFormatting.BLACK);
        }else{
            if(le.isCurrentlyGlowing()){
                stopGlowing(le);
            }
            limpaEfeito(le);
        }
    }
    @SubscribeEvent
    public void foidef(LivingDeathEvent event){
        LivingEntity entity =  event.getEntity();
        if(entity instanceof Player player){
            if(player.getInventory().contains(ModItems.CEIFADORPR.get().getDefaultInstance()) || player.getInventory().contains(ModItems.CEIFADORR.get().getDefaultInstance())){
                Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(20);
            }
        }else{
            Entity atacante = event.getSource().getEntity();
            if(atacante instanceof Player player){
                if(player.getMainHandItem().is(ModItems.CEIFADORPR.get())){
                    double max = player.getMaxHealth();
                    if(max<200){
                        Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(max+2);
                        player.setHealth((float) (max+2));
                    }
                }else if(player.getMainHandItem().is(ModItems.CEIFADORR.get())){
                    double max = player.getMaxHealth();
                    if(max<1000){
                        Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).setBaseValue(max+2);
                        player.setHealth((float) (max+2));
                    }
                }
            }
        }
    }
    public static void glowColor(Player player, ChatFormatting color) {
        Scoreboard scoreboard = new Scoreboard();
        PlayerTeam team = scoreboard.addPlayerTeam("temp-color-team-" + UUID.randomUUID());
        team.setColor(color);
        scoreboard.addPlayerToTeam(player.getName().getString(),team);
        tempTeams.put(player, team);
        player.addEffect(new MobEffectInstance(MobEffects.GLOWING,-1));
    }
    public static void stopGlowing(Player player) {
        player.removeEffect(MobEffects.GLOWING);
        if(!tempTeams.containsKey(player)) return;
        PlayerTeam team = tempTeams.get(player);
        team.getScoreboard().removePlayerFromTeam(player.getName().getString());
        team.getScoreboard().removePlayerTeam(team);
        tempTeams.remove(player);
    }
    public static void limpaEfeito(Player player){
        Collection<MobEffectInstance> efeitos = player.getActiveEffects();
        while(efeitos.iterator().hasNext()){
            MobEffectInstance efeito = efeitos.iterator().next();
            if(efeito.getDuration()<=0){
                player.removeEffect(efeito.getEffect());
            }
            efeitos.iterator().remove();
        }
    }
}
