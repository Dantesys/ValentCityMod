package com.dantesys.valentcitymod;

import com.dantesys.valentcitymod.block.ModBlocks;
import com.dantesys.valentcitymod.item.ModItens;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
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
        ModItens.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.debug("OK");
    }

    private void addCreativeTba(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItens.ASCENSION);
            event.accept(ModBlocks.ASCENSION_CORE);
        }
    }
}
