package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.extensions.IForgeBlock;

public class ModMetalBlock extends Block implements IForgeBlock {
    public ModMetalBlock(Properties properties) {
        super(properties);
    }

    //makes block into beacon base
    @Override
    public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon) {
        return true;
    }
}
