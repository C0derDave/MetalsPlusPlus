package com.codingcrusader.metalsplusplus;

import com.codingcrusader.metalsplusplus.common.EventListener;
import com.codingcrusader.metalsplusplus.common.RegistryEventListener;
import com.codingcrusader.metalsplusplus.common.WorldGeneration;
import com.codingcrusader.metalsplusplus.common.blocks.ModBlocks;
import com.codingcrusader.metalsplusplus.common.CommonProxy;
import com.codingcrusader.metalsplusplus.common.crafting.ModCrafting;
import com.codingcrusader.metalsplusplus.common.entity.ModEntities;
import com.codingcrusader.metalsplusplus.common.items.ModItems;

import com.codingcrusader.metalsplusplus.common.tileentity.TileEntityUranium;
import com.codingcrusader.metalsplusplus.common.tileentity.TileEntityUraniumFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = MetalMod.MODID, version = MetalMod.VERSION, updateJSON = "https://github.com/C0derDave/MetalsPlusPlus/blob/master/update.json")
public class MetalMod {
	//Mod ID
	public static final String MODID = "metalsplusplus";
	//Version
	public static final String VERSION = "1.1";

	//Instance for the rest of the mod
	@Instance(MODID)
	public static MetalMod instance;

	//Proxy
	@SidedProxy(clientSide = "com.codingcrusader.metalsplusplus.client.ClientProxy", serverSide = "com.codingcrusader.metalsplusplus.common.CommonProxy")
	public static CommonProxy proxy;

	//Achievements
	public static Achievement bronzeAchievement;
	public static Achievement uraniumAchievement;

	//The entities
	private ModEntities modEntities;

	public MetalMod() {
		MinecraftForge.EVENT_BUS.register(new RegistryEventListener());
	}

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Add the crafting recipes
		ModCrafting.addCrafting();

		//Add the achievements
		bronzeAchievement = new Achievement("achievement.metalworker", "metalworker", 8, 2, ModItems.bronzeIngot, AchievementList.BUILD_PICKAXE);
		bronzeAchievement.registerStat();
		uraniumAchievement = new Achievement("achievement.uranium", "uranium", -1, -1, ModItems.uraniumIngot, AchievementList.DIAMONDS);
		uraniumAchievement.registerStat();

		//Add the tile entities.
		GameRegistry.registerTileEntity(TileEntityUranium.class, "tile_entity_uranium");
		GameRegistry.registerTileEntity(TileEntityUraniumFurnace.class, "tile_entity_uranium_furnace");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		//Event listener
		MinecraftForge.EVENT_BUS.register(new EventListener());

		//Register the world gen
		GameRegistry.registerWorldGenerator(new WorldGeneration(), 0);

		//Register the ores into the OreDictionary
		OreDictionary.registerOre("oreTin", ModBlocks.tinOre);
		OreDictionary.registerOre("oreCopper", ModBlocks.copperOre);
		OreDictionary.registerOre("oreTitanium", ModBlocks.titaniumOre);
		OreDictionary.registerOre("oreUranium", ModBlocks.uraniumOre);
		OreDictionary.registerOre("oreAluminium", ModBlocks.aluminiumOre);

		OreDictionary.registerOre("ingotTin", new ItemStack(ModItems.tinIngot));
		OreDictionary.registerOre("ingotCopper", new ItemStack(ModItems.copperIngot));
		OreDictionary.registerOre("ingotBronze", new ItemStack(ModItems.bronzeIngot));
		OreDictionary.registerOre("ingotTitanium", ModItems.titaniumIngot);
		OreDictionary.registerOre("ingotUranium", ModItems.uraniumIngot);
		OreDictionary.registerOre("ingotAluminium", ModItems.aluminiumIngot);

		OreDictionary.registerOre("blockTin", ModBlocks.tinBlock);
		OreDictionary.registerOre("blockCopper", ModBlocks.copperBlock);
		OreDictionary.registerOre("blockTitanium", ModBlocks.titaniumBlock);
		OreDictionary.registerOre("blockUranium", ModBlocks.uraniumBlock);
		OreDictionary.registerOre("blockAluminium", ModBlocks.aluminiumBlock);
	}
}
