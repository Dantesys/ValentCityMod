package com.dantesys.valentcitymod.util;

import com.dantesys.valentcitymod.ValentCityMod;
import com.dantesys.valentcitymod.block.ModBlocks;
import com.dantesys.valentcitymod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ValentCityMod.MODID);

    public static final RegistryObject<CreativeModeTab> VALENT_CITY_TAB = CREATIVE_TAB.register("valentcitytab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ASCENSION_CORE.get()))
                    .title(Component.translatable("creativetab.valentcitymod.valentcitytabtitle"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ASCENSION.get());
                        output.accept(ModBlocks.ASCENSION_CORE.get());
                        output.accept(ModItems.CEIFADORPR.get());
                        output.accept(ModItems.CEIFADORR.get());
                    })
                    .build());

    public static void register(IEventBus event){
        CREATIVE_TAB.register(event);
    }
}
