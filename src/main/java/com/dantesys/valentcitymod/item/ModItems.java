package com.dantesys.valentcitymod.item;

import com.dantesys.valentcitymod.ValentCityMod;
import com.dantesys.valentcitymod.item.custom.CeifadorRelic;
import com.dantesys.valentcitymod.item.custom.GuerreiroRelic;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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
            () -> new CeifadorRelic(ModTier.PASCENCIONTIER,new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(ModTier.PASCENCIONTIER,2,-3f)),false));
    public static final RegistryObject<SwordItem> CEIFADORR = ITEMS.register("ceifadorr",
            () -> new CeifadorRelic(ModTier.ASCENCIONTIER,new Item.Properties().fireResistant().rarity(Rarity.EPIC).attributes(SwordItem.createAttributes(ModTier.ASCENCIONTIER,3,-2.4f)),true));
    public static final RegistryObject<SwordItem> GUERREIROPR = ITEMS.register("guerreiropr",
            () -> new GuerreiroRelic(ModTier.PASCENCIONTIER,new Item.Properties().fireResistant().attributes(SwordItem.createAttributes(ModTier.PASCENCIONTIER,3,-3f)),false));
    public static final RegistryObject<SwordItem> GUERREIROR = ITEMS.register("guerreiror",
            () -> new GuerreiroRelic(ModTier.ASCENCIONTIER,new Item.Properties().fireResistant().rarity(Rarity.EPIC).attributes(SwordItem.createAttributes(ModTier.ASCENCIONTIER,4,-2.4f)),true));
    public static void register(IEventBus event){
        ITEMS.register(event);
    }
}