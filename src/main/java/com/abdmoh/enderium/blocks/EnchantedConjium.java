package com.abdmoh.enderium.blocks;

import com.abdmoh.enderium.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

import java.util.Random;

public class EnchantedConjium extends GrassBlock implements IForgeBlock {
    public EnchantedConjium() {
        super(Properties.create(Material.ORGANIC)
                .sound(SoundType.STONE)
                .hardnessAndResistance(2.5F, 8.0F)
                .harvestTool(ToolType.PICKAXE)
        );
        setRegistryName("enchanted_conjium");
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }

    @Override
    public void onPlantGrow(BlockState state, IWorld world, BlockPos pos, BlockPos source)
    {
        world.setBlockState(pos, ModBlocks.COMPLITE.getDefaultState(), 2);
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = ModBlocks.MYSTIC_GRASS.getDefaultState();

        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while(true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = worldIn.getBlockState(blockpos1);

                    if (blockstate2 != Blocks.AIR.getDefaultState()) {
                        break;
                    }

                    BlockState blockstate1;
                    if (rand.nextInt(8) == 0) {
                        blockstate1 = ModBlocks.ENCHANTED_SAPLING.getDefaultState();
                    }
                    else if (rand.nextInt(8) == 1) {
                        blockstate1 = Blocks.AIR.getDefaultState();
                    }
                    else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.isValidPosition(worldIn, blockpos1)) {
                        worldIn.setBlockState(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (worldIn.getBlockState(blockpos1.down()).getBlock() != this || worldIn.getBlockState(blockpos1).func_224756_o(worldIn, blockpos1)) {
                    break;
                }

                ++j;
            }
        }
    }
}
