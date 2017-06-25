package com.codingcrusader.metalsplusplus.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;

public class ItemModSpade extends ItemSpade {
	public ItemModSpade(String name, Item.ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.TOOLS);
	}
}
