package com.codingcrusader.metalsplusplus.common.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ItemModArmor extends ItemArmor {
	public ItemModArmor(String name, ArmorMaterial armorMaterial, int renderIndex, EntityEquipmentSlot armorType) {
		super(armorMaterial, renderIndex, armorType);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}
