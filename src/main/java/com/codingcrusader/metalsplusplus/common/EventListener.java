package com.codingcrusader.metalsplusplus.common;

import com.codingcrusader.metalsplusplus.MetalMod;
import com.codingcrusader.metalsplusplus.common.items.ModItems;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class EventListener {
	@SubscribeEvent
	public void onCraft(PlayerEvent.ItemCraftedEvent event) {
		/**
		 * Reward the player for crafting bronze.
		 */
		if(event.crafting.getItem().equals(ModItems.bronzeIngot)) {
			event.player.addStat(MetalMod.bronzeAchievement, 1);
		}
	}

	@SubscribeEvent
	public void onSmelt(PlayerEvent.ItemSmeltedEvent event) {
		/**
		 * Reward the player for smelting uranium.
		 */
		if(event.smelting.getItem().equals(ModItems.uraniumIngot)) {
			event.player.addStat(MetalMod.uraniumAchievement, 1);
		}
	}
}
