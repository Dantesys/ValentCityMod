package com.dantesys.valentcitymod.item;

import com.dantesys.valentcitymod.ValentCityMod;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.Item.BASE_ATTACK_DAMAGE_ID;

public class ModItens {
    public static final DeferredRegister<Item> ITENS = DeferredRegister.create(ForgeRegistries.ITEMS, ValentCityMod.MODID);

    public static final RegistryObject<Item> ASCENSION = ITENS.register("ascension",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<SwordItem> CEIFADOR = ITENS.register("ceifador",
            () -> new SwordItem(Tiers.NETHERITE,new SwordItem.Properties()
                    .durability(8192)
                    .fireResistant()
                    .attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 7.5f, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build())));

    public static void register(IEventBus event){
        ITENS.register(event);
    }
}
