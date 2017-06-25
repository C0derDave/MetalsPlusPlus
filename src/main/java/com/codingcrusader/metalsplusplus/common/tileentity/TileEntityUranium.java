package com.codingcrusader.metalsplusplus.common.tileentity;

import com.codingcrusader.metalsplusplus.common.blocks.ModBlocks;
import com.codingcrusader.metalsplusplus.common.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.Random;

public class TileEntityUranium extends TileEntity implements ITickable {

	private Random rand = new Random();

	/**
	 * Runs every update tick of the block.
	 */
	@Override
	public void update() {

		//Check if the block is powered by redstone.
		if(this.getWorld().isBlockPowered(pos)) {

			//The bounding box for the radiation, taking into account lead blocks.
			AxisAlignedBB bb = getRadiationBoundingBox();

			//Loop through the box and spawn particles.
			for(int x = (int)bb.minX; x < (int)bb.maxX; x++) {
				for(int y = (int)bb.minY; y < (int)bb.maxY; y++) {
					for(int z = (int)bb.minZ; z < (int)bb.maxZ; z++) {
						if(rand.nextInt(20) == 0) {
							double i = rand.nextDouble();
							this.getWorld().spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, x+i, y+i, z+i, 0.0D, 0.0D, 0.0D, new int[0]);
						}
					}
				}
			}

			//Loop through the entities in the box.
			addEntityEffects(bb);
		}
	}

	/**
	 * Get the bounding box for the radiation.
	 * @return The radiation bounding box.
	 */
	private AxisAlignedBB getRadiationBoundingBox() {
		//The farthest from the origin that radioactivity can go.
		int xA = pos.getX() - 5, yA = pos.getY() - 5, zA = pos.getZ() - 5;
		int xB = pos.getX() + 5, yB = pos.getY() + 5, zB = pos.getZ() + 5;

		//The list of positions of lead blocks blocking radioactivity.
		ArrayList<BlockPos> leadBlocks = new ArrayList<BlockPos>();

		//Loop through the area and check for lead blocks.
		for(int x = xA; x < xB; x++) {
			for(int y = yA; y < yB; y++) {
				for(int z = zA; z < zB; z++) {

					//If any block is a lead block, then add its position to leadBlocks.
					if(this.getWorld().getBlockState(new BlockPos(x, y, z)).getBlock().equals(ModBlocks.leadBlock)) {
						leadBlocks.add(new BlockPos(x, y, z));
						//System.out.println("1: " + (pos.getX() - x) + ":" + (pos.getY() - y) + ":" + (pos.getZ() - z));
					}
				}
			}
		}

		//Loop through the positions of the lead blocks.
		for(BlockPos p : leadBlocks) {
			int x = p.getX();
			int y = p.getY();
			int z = p.getZ();

			boolean xEqual = (x == pos.getX());
			boolean yEqual = (y == pos.getY());
			boolean zEqual = (z == pos.getZ());

			//Adjust the xA, xB, etc. variables to the lead blocks.

			if (xEqual && yEqual) {
				if (z >= pos.getZ()) {
					zB = z;
				} else if (z <= pos.getZ()) {
					zA = z + 1;
				}
			}
			if (xEqual && zEqual) {
				if (y >= pos.getY()) {
					yB = y;
				} else if (y <= pos.getY()) {
					yA = y + 1;
				}
			}
			if (zEqual && yEqual) {
				if (x >= pos.getX()) {
					xB = x;
				} else if (x <= pos.getX()) {
					xA = x + 1;
				}
			}
		}

		//The corners.
		BlockPos cornerA = new BlockPos(xA, yA, zA);
		BlockPos cornerB = new BlockPos(xB, yB, zB);

		return new AxisAlignedBB(cornerA, cornerB);
	}

	/**
	 * Add effects to the entities from cornerA to cornerB.
	 * @param boundingBox The bounding box in which to look for entities.
	 */
	private void addEntityEffects(AxisAlignedBB boundingBox) {
		//Loop through the entities in the box.
		for(Entity entity : this.getWorld().getEntitiesWithinAABB(Entity.class, boundingBox)) {
			if(entity instanceof EntityLivingBase && !this.getWorld().isRemote) {
				if(rand.nextInt(20) == 0) {
					//The potion effects.
					PotionEffect wither = new PotionEffect(Potion.getPotionById(20), rand.nextInt(50), rand.nextInt(2) + 1);
					PotionEffect nausea = new PotionEffect(Potion.getPotionById(9), 250, rand.nextInt(2) + 2);

					//The entity.
					EntityLivingBase entityLivingBase = (EntityLivingBase) entity;

					//Decides whether the player will be given potion effects.
					boolean flag = true;

					//Check if the entity is a player.
					if(entityLivingBase instanceof EntityPlayer) {
						//The amount of lead armor that is being worn.
						int leadArmor = 0;

						//The player.
						EntityPlayer player = (EntityPlayer)entityLivingBase;

						//Loop through the player's armor.
						for(ItemStack stack : player.getArmorInventoryList()) {
							//If a piece of armor is lead, add 1 to leadArmor.
							if(stack != null && (stack.getItem().equals(ModItems.leadBoots) ||
									stack.getItem().equals(ModItems.leadLeggings) ||
									stack.getItem().equals(ModItems.leadChestplate) ||
									stack.getItem().equals(ModItems.leadHelmet))) {
								leadArmor++;
							}
						}

						//True if the player is in survival mode and they are wearing less than 2 pieces of lead armor.
						flag = leadArmor < 2 && !player.isCreative() && !player.isSpectator();
						System.out.println(flag);
					}

					//If the entity has neither of the potion effects and flag is true, give potion effects.
					if(!entityLivingBase.isPotionActive(wither.getPotion()) && flag) {
						entityLivingBase.addPotionEffect(wither);
					}
					if(!entityLivingBase.isPotionActive(nausea.getPotion()) && flag) {
						entityLivingBase.addPotionEffect(nausea);
					}
				}
			}
		}
	}
}
