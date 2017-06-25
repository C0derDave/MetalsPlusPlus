package com.codingcrusader.metalsplusplus.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe {
	public ItemModPickaxe(String name, ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
