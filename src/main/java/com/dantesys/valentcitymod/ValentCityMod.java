package com.dantesys.valentcitymod;

import com.dantesys.valentcitymod.block.ModBlocks;
import com.dantesys.valentcitymod.event.ModEvents;
import com.dantesys.valentcitymod.item.ModItems;
import com.dantesys.valentcitymod.util.CreativeTab;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

@Mod(ValentCityMod.MODID)
public class ValentCityMod
{
    public static final String MODID = "valentcitymod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public ValentCityMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreativeTba);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ModEvents.class);
        CreativeTab.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::modEventHandler);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    private void modEventHandler(RegisterEvent event) {
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.debug("OK");
    }

    private void addCreativeTba(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.ASCENSION);
            event.accept(ModBlocks.ASCENSION_CORE);
        }
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
