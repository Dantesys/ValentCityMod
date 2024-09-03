package com.dantesys.valentcitymod.item;

import com.dantesys.valentcitymod.ValentCityMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItens {
    public static final DeferredRegister<Item> ITENS = DeferredRegister.create(ForgeRegistries.ITEMS, ValentCityMod.MODID);

    public static final RegistryObject<Item> ASCENSION = ITENS.register("ascension",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus event){
        ITENS.register(event);
    }
}
