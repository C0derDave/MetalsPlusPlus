package com.codingcrusader.metalsplusplus.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {
	public ItemModSword(String name, ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setUnlocalizedName(name);
		this.setCreativeTab(CreativeTabs.COMBAT);
		this.setRegistryName(name);
	}
}
