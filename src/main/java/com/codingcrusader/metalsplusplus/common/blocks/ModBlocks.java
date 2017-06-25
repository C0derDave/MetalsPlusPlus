package com.codingcrusader.metalsplusplus.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
	public static Block tinOre, tinBlock;
	public static Block copperOre, copperBlock;
	public static Block bronzeBlock;
	public static Block leadBlock, leadOre;
	public static Block titaniumOre, titaniumBlock;
	public static Block uraniumOre, uraniumBlock, uraniumBlockOn, uraniumFurnace, uraniumFurnaceLit;
	public static Block aluminiumOre, aluminiumBlock;

	/**
	 * Add the blocks.
	 */
	public static final Block[] BLOCKS = new Block[] {
			tinOre = new BlockModOre("tin_ore", 3.0F, 5.0F, 2),
			copperOre = new BlockModOre("copper_ore", 3.0F, 5.0F, 2),
			tinBlock = new BlockModMetal("tin_block", 5.0F, 10.0F, 2),
			copperBlock = new BlockModMetal("copper_block", 5.0F, 10.0F, 2),
			bronzeBlock = new BlockModMetal("bronze_block", 5.0F, 10.0F, 2),
			titaniumOre = new BlockModOre("titanium_ore", 4.0F, 2.0F, 3),
			titaniumBlock = new BlockModMetal("titanium_block", 5.5F, 2000.0F, 3),
			uraniumBlock = new BlockUranium("uranium_block", true).setCreativeTab(CreativeTabs.REDSTONE),
			uraniumBlockOn = new BlockUranium("uranium_block_on", true),
			uraniumOre = new BlockModOre("uranium_ore", 2.0F, 2.5F, 3),
			uraniumFurnace = new BlockUraniumFurnace("uranium_furnace", false).setCreativeTab(CreativeTabs.DECORATIONS),
			uraniumFurnaceLit = new BlockUraniumFurnace("uranium_furnace_lit", true).setLightLevel(0.875F),
			leadBlock = new BlockModMetal("lead_block", 5.0F, 10.0F, 2),
			leadOre = new BlockModOre("lead_ore", 3.0F, 5.0F, 2),
			aluminiumOre = new BlockModOre("aluminium_ore", 1.5F, 2.0F, 1),
			aluminiumBlock = new BlockModMetal("aluminium_block", 2.0F, 2.0F, 1)
	};
}
