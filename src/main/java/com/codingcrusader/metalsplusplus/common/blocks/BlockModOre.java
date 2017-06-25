package com.codingcrusader.metalsplusplus.common.blocks;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;

public class BlockModOre extends BlockOre {
	/**
	 * Basis for the ores in this mod.
	 * @param name The name of the ore.
	 * @param hardness The ore hardness.
	 * @param resistance The ore resistance.
	 * @param harvestLevel The ore harvest level.
	 */
	public BlockModOre(String name, float hardness, float resistance, int harvestLevel) {
		super();
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(SoundType.STONE);
		this.setHarvestLevel("pickaxe", harvestLevel);
	}
}
