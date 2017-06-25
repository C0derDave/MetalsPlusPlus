package com.codingcrusader.metalsplusplus.common;

import java.util.Random;

import com.codingcrusader.metalsplusplus.common.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneration implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
			case -1:
				generateNether(world, random, chunkX * 16, chunkZ * 16); break;
			case 0:
				generateSurface(world, random, chunkX * 16, chunkZ *16); break;
			case 1:
				generateEnd(world, random, chunkX*16, chunkZ*16); break;
		}
	}

	/**
	 * Generation in the nether.
	 */
	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		generateOre(ModBlocks.uraniumOre, random, world, chunkX, chunkZ, random.nextInt(80), 255, Blocks.NETHERRACK);
	}

	/**
	 * Generation in the overworld.
	 */
	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		generateOre(ModBlocks.copperOre, random, world, chunkX, chunkZ, random.nextInt(8), 54, Blocks.STONE);
		generateOre(ModBlocks.tinOre, random, world, chunkX, chunkZ, random.nextInt(10), 54, Blocks.STONE);
		generateOre(ModBlocks.leadOre, random, world, chunkX, chunkZ, random.nextInt(8), 32, Blocks.STONE);
		generateOre(ModBlocks.aluminiumOre, random, world, chunkX, chunkZ, random.nextInt(16), 64, Blocks.STONE);
	}

	/**
	 * Generation in the end.
	 */
	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		generateOre(ModBlocks.titaniumOre, random, world, chunkX, chunkZ, random.nextInt(56), 256, Blocks.END_STONE);
	}

	/**
	 * Generate an ore.
	 * @param block The block to generate.
	 * @param rand Random.
	 * @param world The world to generate in.
	 * @param blockX The position on the x axis.
	 * @param blockZ The position on the z axis.
	 * @param chances The amount of chances that the block can possibly generate.
	 * @param maxY The maximum height the ore can generate at.
	 * @param generateIn The block to generate the ore inside.
	 */
	public void generateOre(Block block, Random rand, World world, int blockX, int blockZ, int chances, int maxY, Block generateIn) {
		for (int k = 0; k < chances; k++)
		{
			int firstBlockXCoord = blockX + rand.nextInt(16);
			int firstBlockZCoord = blockZ + rand.nextInt(16);
			int y = rand.nextInt(maxY);
			BlockPos pos = new BlockPos(firstBlockXCoord, y, firstBlockZCoord);
			(new WorldGenMinable(block.getDefaultState(), 10, BlockMatcher.forBlock(generateIn))).generate(world, rand, pos);
		}
	}
}
