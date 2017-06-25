package com.codingcrusader.metalsplusplus.common.crafting;

import com.codingcrusader.metalsplusplus.common.blocks.ModBlocks;
import com.codingcrusader.metalsplusplus.common.items.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModCrafting {
	public static void addCrafting() {
		/**
		 * Smelting
		 */
		GameRegistry.addSmelting(ModBlocks.copperOre, new ItemStack(ModItems.copperIngot), 1.0F);
		GameRegistry.addSmelting(ModBlocks.tinOre, new ItemStack(ModItems.tinIngot), 1.0F);
		GameRegistry.addSmelting(ModBlocks.titaniumOre, new ItemStack(ModItems.titaniumIngot), 1.5F);
		GameRegistry.addSmelting(ModBlocks.uraniumOre, new ItemStack(ModItems.uraniumIngot), 1.5F);
		GameRegistry.addSmelting(ModBlocks.leadOre, new ItemStack(ModItems.leadIngot), 0.8F);
		GameRegistry.addSmelting(ModBlocks.aluminiumOre, new ItemStack(ModItems.aluminiumIngot), 0.4F);

		/**
		 * Shapeless
		 */
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.bronzeIngot), "ingotTin", "ingotCopper"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.bronzeIngot, 9), "blockBronze"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.copperIngot, 9), "blockCopper"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.titaniumIngot, 9), "blockTitanium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.tinIngot, 9), "blockTin"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.leadIngot, 9), "blockLead"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.uraniumIngot, 9), "blockUranium"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.aluminiumIngot, 9), "blockAluminium"));

		/**
		 * Shaped
		 */
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzeAxe),
				"BB",
				"BI",
				" I",
				'B', "ingotBronze", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzeAxe),
				"BB",
				"IB",
				"I ",
				'B', "ingotBronze", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzePickaxe),
				"BBB",
				" I ",
				" I ",
				'B', "ingotBronze", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzeSpade),
				"B",
				"I",
				"I",
				'B', "ingotBronze", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzeSword),
				"B",
				"B",
				"I",
				'B', "ingotBronze", 'I', Items.STICK));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzeHelmet),
				"BBB",
				"B B",
				'B', "ingotBronze"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzeChestplate),
				"B B",
				"BBB",
				"BBB",
				'B', "ingotBronze"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzeLeggings),
				"BBB",
				"B B",
				"B B",
				'B', "ingotBronze"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.bronzeBoots),
				"B B",
				"B B",
				'B', "ingotBronze"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumAxe),
				"BB",
				"BI",
				" I",
				'B', "ingotTitanium", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumAxe),
				"BB",
				"IB",
				"I ",
				'B', "ingotTitanium", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumSword),
				"T",
				"T",
				"I",
				'T', "ingotTitanium", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumSpade),
				"T",
				"I",
				"I",
				'T', "ingotTitanium", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumPickaxe),
				"TTT",
				" I ",
				" I ",
				'T', "ingotTitanium", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumHelmet),
				"TTT",
				"T T",
				'T', "ingotTitanium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumChestplate),
				"T T",
				"TTT",
				"TTT",
				'T', "ingotTitanium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumLeggings),
				"TTT",
				"T T",
				"T T",
				'T', "ingotTitanium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.titaniumBoots),
				"T T",
				"T T",
				'T', "ingotTitanium"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadAxe),
				"BB",
				"BI",
				" I",
				'B', "ingotLead", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadAxe),
				"BB",
				"IB",
				"I ",
				'B', "ingotLead", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadSword),
				"T",
				"T",
				"I",
				'T', "ingotLead", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadSpade),
				"T",
				"I",
				"I",
				'T', "ingotLead", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadPickaxe),
				"TTT",
				" I ",
				" I ",
				'T', "ingotLead", 'I', Items.STICK));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadHelmet),
				"TTT",
				"T T",
				'T', "ingotLead"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadChestplate),
				"T T",
				"TTT",
				"TTT",
				'T', "ingotLead"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadLeggings),
				"TTT",
				"T T",
				"T T",
				'T', "ingotLead"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.leadBoots),
				"T T",
				"T T",
				'T', "ingotLead"));

		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.tinBlock),
				"TTT",
				"TTT",
				"TTT",
				'T', "ingotTin"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.copperBlock),
				"TTT",
				"TTT",
				"TTT",
				'T', "ingotCopper"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.bronzeBlock),
				"TTT",
				"TTT",
				"TTT",
				'T', "ingotBronze"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.titaniumBlock),
				"TTT",
				"TTT",
				"TTT",
				'T', "ingotTitanium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.uraniumBlock),
				"TTT",
				"TTT",
				"TTT",
				'T', "ingotUranium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.leadBlock),
				"TTT",
				"TTT",
				"TTT",
				'T', "ingotLead"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.aluminiumBlock),
				"TTT",
				"TTT",
				"TTT",
				'T', "ingotAluminium"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.uraniumFurnace),
				"TTT",
				"TFT",
				"TTT",
				'T', "ingotUranium", 'F', Blocks.FURNACE));

	}
}
