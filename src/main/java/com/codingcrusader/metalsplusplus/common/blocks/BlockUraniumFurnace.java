package com.codingcrusader.metalsplusplus.common.blocks;

import com.codingcrusader.metalsplusplus.common.tileentity.TileEntityUraniumFurnace;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockUraniumFurnace extends BlockFurnace implements ITileEntityProvider {
	private static boolean keepInventory;

	public BlockUraniumFurnace(String name, boolean isBurning) {
		super(isBurning);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.uraniumFurnace);
	}

	public static void setState(boolean active, World worldIn, BlockPos pos) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		keepInventory = true;

		if (active) {
			worldIn.setBlockState(pos, ModBlocks.uraniumFurnaceLit.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
			worldIn.setBlockState(pos, ModBlocks.uraniumFurnaceLit.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
		}
		else {
			worldIn.setBlockState(pos, ModBlocks.uraniumFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
			worldIn.setBlockState(pos, ModBlocks.uraniumFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
		}

		keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		}
		else {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityUraniumFurnace) {
				playerIn.displayGUIChest((TileEntityUraniumFurnace)tileentity);
				playerIn.addStat(StatList.FURNACE_INTERACTION);
			}

			return true;
		}
	}

	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityUraniumFurnace) {
				((TileEntityUraniumFurnace)tileentity).setCustomInventoryName(stack.getDisplayName());
			}
		}
	}

	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityUraniumFurnace();
	}

	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (!keepInventory) {
			TileEntity tileentity = worldIn.getTileEntity(pos);

			if (tileentity instanceof TileEntityUraniumFurnace) {
				InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityUraniumFurnace)tileentity);
				worldIn.updateComparatorOutputLevel(pos, this);
			}
		}

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ModBlocks.uraniumFurnace);
	}

}
