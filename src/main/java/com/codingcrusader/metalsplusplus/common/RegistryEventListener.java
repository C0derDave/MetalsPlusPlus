package com.codingcrusader.metalsplusplus.common;

import com.codingcrusader.metalsplusplus.common.blocks.ModBlocks;
import com.codingcrusader.metalsplusplus.common.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class RegistryEventListener {
	/**
	 * Register the items.
	 * @param event
	 */
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS);

		for(Block block : ModBlocks.BLOCKS) {
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		}
	}

	/**
	 * Register the blocks.
	 * @param event
	 */
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS);
	}

	/**
	 * Register the block and item models.
	 * @param event
	 */
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		for(Item item : ModItems.ITEMS) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}

		for(Block block : ModBlocks.BLOCKS) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
	}
}
