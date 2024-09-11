package com.dantesys.valentcitymod.event;

import com.dantesys.valentcitymod.ValentCityMod;
import com.dantesys.valentcitymod.item.ModItens;
import net.minecraft.ChatFormatting;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraftforge.event.entity.living.LivingSwapItemsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class ModEvents {
    static HashMap<LivingEntity, PlayerTeam> tempTeams = new HashMap<>();
    @Mod.EventBusSubscriber(modid = ValentCityMod.MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public void segurar(LivingSwapItemsEvent event){
            ItemStack i = event.getEntity().getMainHandItem();
            LivingEntity le = event.getEntity();
            if(i.is(ModItens.CEIFADOR.get())){
                le.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,-1));
                le.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,-1));
                glowColor(le, ChatFormatting.BLACK);
            }else{
                stopGlowing(le);
                limpaEfeito(le);
            }
        }
    }
    public static void glowColor(LivingEntity player, ChatFormatting color) {
        Scoreboard scoreboard = new Scoreboard();
        PlayerTeam team = scoreboard.addPlayerTeam("temp-color-team-" + UUID.randomUUID());
        team.setColor(color);
        scoreboard.addPlayerToTeam(player.getName().getString(),team);
        tempTeams.put(player, team);
        player.addEffect(new MobEffectInstance(MobEffects.GLOWING,-1));
    }
    public static void stopGlowing(LivingEntity player) {
        player.removeEffect(MobEffects.GLOWING);
        PlayerTeam team = tempTeams.get(player);
        team.getScoreboard().removePlayerFromTeam(player.getName().getString());
        team.getScoreboard().removePlayerTeam(team);
        tempTeams.remove(player);
    }
    public static void limpaEfeito(LivingEntity player){
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
