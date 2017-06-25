package com.codingcrusader.metalsplusplus.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemModIngot extends Item {
	/**
	 * The base of the ingot items in this mod.
	 * @param name The name of the ingot.
	 */
	public ItemModIngot(String name) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}
}
