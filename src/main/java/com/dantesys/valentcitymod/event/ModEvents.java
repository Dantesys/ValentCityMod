package com.dantesys.valentcitymod.event;

import com.dantesys.valentcitymod.ValentCityMod;
import com.dantesys.valentcitymod.item.ModItens;
import net.minecraft.ChatFormatting;
import net.minecraft.server.ServerScoreboard;
import net.minecraft.util.CommonColors;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Team;
import net.minecraftforge.event.entity.living.LivingSwapItemsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.UUID;

public class ModEvents {
    static HashMap<LivingEntity, PlayerTeam> tempTeams = new HashMap<>();
    @Mod.EventBusSubscriber(modid = ValentCityMod.MODID)
    public static class ForgeEvents {
        @SubscribeEvent
        public void segurar(LivingSwapItemsEvent event){
            ItemStack i = event.getEntity().getMainHandItem();
            if(i.is(ModItens.CEIFADOR.get())){
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION,-1));
                event.getEntity().addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,-1));
                glowColor(event.getEntity(), ChatFormatting.BLACK);
            }
        }
    }
    @Mod.EventBusSubscriber(modid = ValentCityMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void segurar(LivingSwapItemsEvent event) {

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
    public void stopGlowing(LivingEntity player) {
        player.removeEffect(MobEffects.GLOWING);
        PlayerTeam team = tempTeams.get(player);
        team.getScoreboard().removePlayerFromTeam(player.getName().getString());
        team.getScoreboard().removePlayerTeam(team);
        tempTeams.remove(player);
    }
}
