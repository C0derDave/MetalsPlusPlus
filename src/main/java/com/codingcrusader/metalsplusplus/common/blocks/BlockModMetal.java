package com.codingcrusader.metalsplusplus.common.blocks;

import com.codingcrusader.metalsplusplus.MetalMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockModMetal extends Block {
	/**
	 * Basis for the metal blocks in this mod.
	 * @param name The block name.
	 * @param hardness The block hardness.
	 * @param resistance The block resistance.
	 * @param harvestLevel The block harvest level.
	 */
	public BlockModMetal(String name, float hardness, float resistance, int harvestLevel) {
		super(Material.IRON);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(SoundType.METAL);
		this.setHarvestLevel("pickaxe", harvestLevel);
	}

}
