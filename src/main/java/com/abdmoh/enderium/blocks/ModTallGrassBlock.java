package com.abdmoh.enderium.blocks;

import com.abdmoh.enderium.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IShearable;

import java.util.Random;

public class ModTallGrassBlock extends TallGrassBlock implements IGrowable {
    public ModTallGrassBlock(Block.Properties properties) {
        super(properties);
    }

    //ensures that custom tall grass cannot grow
    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        if (state == ModBlocks.MYSTIC_GRASS.getDefaultState()) {
            return false;
        }
        else {
            return true;
        }
    }

    //allows custom tall grass to be replaced by logs
    @Override
    public boolean canBeReplacedByLogs(BlockState state, IWorldReader world, BlockPos pos) {
        return true;
    }

    //allows custom tall grass to be replaced by leaves
    @Override
    public boolean canBeReplacedByLeaves(BlockState state, IWorldReader world, BlockPos pos) {
        return true;
    }
}
