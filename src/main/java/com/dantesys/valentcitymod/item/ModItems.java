package com.dantesys.valentcitymod.item;

import com.dantesys.valentcitymod.ValentCityMod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ValentCityMod.MODID);

    public static final RegistryObject<Item> ASCENSION = ITEMS.register("ascension",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<SwordItem> CEIFADORPR = ITEMS.register("ceifadorpr",
            () -> new SwordItem(ModTier.PASCENCIONTIER,new SwordItem.Properties().fireResistant()));
    public static final RegistryObject<SwordItem> CEIFADORR = ITEMS.register("ceifadorr",
            () -> new SwordItem(ModTier.ASCENCIONTIER,new SwordItem.Properties().fireResistant()));
    public static void register(IEventBus event){
        ITEMS.register(event);
    }
}
