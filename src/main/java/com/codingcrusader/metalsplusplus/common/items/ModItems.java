package com.codingcrusader.metalsplusplus.common.items;

import com.codingcrusader.metalsplusplus.MetalMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.List;

public abstract class ModItems {
	/*
	 * Ingots
	 */
	public static Item copperIngot;
	public static Item tinIngot;
	public static Item uraniumIngot;
	public static Item aluminiumIngot;

	/*
	 * Bronze
	 */
	public static Item bronzeIngot;
	public static Item bronzeSpade, bronzePickaxe, bronzeAxe, bronzeSword;
	public static Item bronzeHelmet, bronzeChestplate, bronzeLeggings, bronzeBoots;

	/*
	 * Titanium
	 */
	public static Item titaniumIngot, titaniumSword, titaniumPickaxe, titaniumSpade, titaniumAxe;
	public static Item titaniumHelmet, titaniumChestplate, titaniumLeggings, titaniumBoots;

	/*
	 * Lead
	 */
	public static Item leadSword, leadSpade, leadPickaxe, leadAxe;
	public static Item leadIngot, leadHelmet, leadChestplate, leadLeggings, leadBoots;

	/*
	 * Bronze tool and armor materials
	 */
	private static final Item.ToolMaterial BRONZE_TOOLMATERIAL = EnumHelper.addToolMaterial("BRONZE_TOOLMATERIAL", 2, 1201, 7.0F, 2.5F, 12);
	private static final ItemArmor.ArmorMaterial BRONZE_ARMORMATERIAL = EnumHelper.addArmorMaterial("BRONZE_ARMORMATERIAL", MetalMod.MODID + ":bronzearmor", 29, new int[]{2, 7, 6, 2}, 12, null, 1.0F);

	/*
	 * Titanium tool and armor materials
	 */
	private static final Item.ToolMaterial TITANIUM_TOOLMATERIAL = EnumHelper.addToolMaterial("TITANIUM_TOOLMATERIAL", 3, 3122, 10.0F, 6F, 16);
	private static final ItemArmor.ArmorMaterial TITANIUM_ARMORMATERIAL = EnumHelper.addArmorMaterial("TITANIUM_ARMORMATERIAL", MetalMod.MODID + ":titanium", 66, new int[]{3, 8, 6, 3}, 15, null, 3.0F);

	/**
	 * Lead tool and armor materials
	 */
	private static final Item.ToolMaterial LEAD_TOOLMATERIAL = EnumHelper.addToolMaterial("LEAD_TOOLMATERIAL", 1, 141, 4.0F, 0.8F, 8);
	private static final ItemArmor.ArmorMaterial LEAD_ARMORMATERIAL = EnumHelper.addArmorMaterial("LEAD_ARMORMATERIAL", MetalMod.MODID + ":lead", 16, new int[]{2, 3, 3, 2}, 9, null, 0.0F);

	/**
	 * Array to hold the items for registration.
	 */
	public static final Item[] ITEMS = new Item[] {
			copperIngot = new ItemModIngot("copper_ingot"),
			tinIngot = new ItemModIngot("tin_ingot"),
			bronzeIngot = new ItemModIngot("bronze_ingot"),
			titaniumIngot = new ItemModIngot("titanium_ingot"),
			uraniumIngot = new ItemModIngot("uranium_ingot"),
			leadIngot = new ItemModIngot("lead_ingot"),
			aluminiumIngot = new ItemModIngot("aluminium_ingot"),

			bronzeSpade = new ItemModSpade("bronze_spade", BRONZE_TOOLMATERIAL),
			bronzePickaxe = new ItemModPickaxe("bronze_pickaxe", BRONZE_TOOLMATERIAL),
			bronzeAxe = new ItemModAxe("bronze_axe", ToolMaterial.IRON),
			bronzeSword = new ItemModSword("bronze_sword", BRONZE_TOOLMATERIAL),
			bronzeHelmet = new ItemModArmor("bronze_helmet", BRONZE_ARMORMATERIAL, 1, EntityEquipmentSlot.HEAD),
			bronzeChestplate = new ItemModArmor("bronze_chestplate", BRONZE_ARMORMATERIAL, 1, EntityEquipmentSlot.CHEST),
			bronzeLeggings = new ItemModArmor("bronze_leggings", BRONZE_ARMORMATERIAL, 1, EntityEquipmentSlot.LEGS),
			bronzeBoots = new ItemModArmor("bronze_boots", BRONZE_ARMORMATERIAL, 1, EntityEquipmentSlot.FEET),

			titaniumSword = new ItemModSword("titanium_sword", TITANIUM_TOOLMATERIAL),
			titaniumPickaxe = new ItemModPickaxe("titanium_pickaxe", TITANIUM_TOOLMATERIAL),
			titaniumSpade = new ItemModSpade("titanium_spade", TITANIUM_TOOLMATERIAL),
			titaniumAxe = new ItemModAxe("titanium_axe", ToolMaterial.DIAMOND),
			titaniumHelmet = new ItemModArmor("titanium_helmet", TITANIUM_ARMORMATERIAL, 1, EntityEquipmentSlot.HEAD),
			titaniumChestplate = new ItemModArmor("titanium_chestplate", TITANIUM_ARMORMATERIAL, 1, EntityEquipmentSlot.CHEST),
			titaniumLeggings = new ItemModArmor("titanium_leggings", TITANIUM_ARMORMATERIAL, 1, EntityEquipmentSlot.LEGS),
			titaniumBoots = new ItemModArmor("titanium_boots", TITANIUM_ARMORMATERIAL, 1, EntityEquipmentSlot.FEET),

			leadHelmet = new ItemModArmor("lead_helmet", LEAD_ARMORMATERIAL, 1, EntityEquipmentSlot.HEAD),
			leadChestplate = new ItemModArmor("lead_chestplate", LEAD_ARMORMATERIAL, 1, EntityEquipmentSlot.CHEST),
			leadLeggings = new ItemModArmor("lead_leggings", LEAD_ARMORMATERIAL, 1, EntityEquipmentSlot.LEGS),
			leadBoots = new ItemModArmor("lead_boots", LEAD_ARMORMATERIAL, 1, EntityEquipmentSlot.FEET),
			leadSword = new ItemModSword("lead_sword", LEAD_TOOLMATERIAL),
			leadPickaxe = new ItemModPickaxe("lead_pickaxe", LEAD_TOOLMATERIAL),
			leadSpade = new ItemModSpade("lead_spade", LEAD_TOOLMATERIAL),
			//The lead axe has the stone ToolMaterial instead of the lead one because, when I use the lead ToolMaterial, it crashes with an ArrayIndexOutOfBoundsException. Not sure why yet.
			leadAxe = new ItemModAxe("lead_axe", ToolMaterial.STONE)
	};
}
