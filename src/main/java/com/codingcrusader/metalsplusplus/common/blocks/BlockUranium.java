package com.codingcrusader.metalsplusplus.common.blocks;

import com.codingcrusader.metalsplusplus.common.tileentity.TileEntityUranium;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class BlockUranium extends Block implements ITileEntityProvider{
	private boolean isRadioactive;

	public BlockUranium(String name, boolean isRadioactive) {
		super(Material.IRON);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(3f);
		this.setResistance(2f);
		this.setSoundType(SoundType.METAL);
		this.setHarvestLevel("pickaxe", 3);
		this.isRadioactive = isRadioactive;
	}

	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			if (!worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, ModBlocks.uraniumBlock.getDefaultState(), 2);
			}
			else {
				if(this.isRadioactive) {
					worldIn.setBlockState(pos, ModBlocks.uraniumBlockOn.getDefaultState(), 2);
				}
			}
		}
	}

	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote) {
			if (worldIn.isBlockPowered(pos)) {
				worldIn.scheduleUpdate(pos, this, 4);
			}
			else {
				worldIn.setBlockState(pos, ModBlocks.uraniumBlock.getDefaultState(), 2);
			}
		}
	}

	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (!worldIn.isBlockPowered(pos)) {
				worldIn.setBlockState(pos, ModBlocks.uraniumBlock.getDefaultState(), 2);
			} else {
				worldIn.setBlockState(pos, ModBlocks.uraniumBlockOn.getDefaultState(), 2);
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityUranium();
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		super.breakBlock(world, pos, state);
		world.removeTileEntity(pos);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.uraniumBlock);
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ModBlocks.uraniumBlock);
	}
}
