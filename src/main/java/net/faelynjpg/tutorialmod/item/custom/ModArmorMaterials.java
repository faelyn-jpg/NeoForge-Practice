package net.faelynjpg.tutorialmod.item.custom;

import net.faelynjpg.tutorialmod.util.ModTags;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import java.util.EnumMap;

public class ModArmorMaterials implements ArmorMaterials {

    public static final ArmorMaterial BISMUTH_ARMOR_MATERIAL = new ArmorMaterial(37, Util.make(new EnumMap<>(ArmorType.class), p_371743_ -> {
        p_371743_.put(ArmorType.BOOTS, 5);
        p_371743_.put(ArmorType.LEGGINGS, 7);
        p_371743_.put(ArmorType.CHESTPLATE, 9);
        p_371743_.put(ArmorType.HELMET, 5);
        p_371743_.put(ArmorType.BODY, 11);
    }), 16, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.1F, ModTags.Items.REPAIRS_BISMUTH_ARMOR, ModEquipmentAssets.BISMUTH);

}
