package com.abdmoh.enderium.blocks;

import net.minecraft.block.IGrowable;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;

public class ModSaplingBlock extends SaplingBlock implements IGrowable {
    public ModSaplingBlock(Tree treeIn, Properties properties) {
        super(treeIn, properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(STAGE, Integer.valueOf(0)));
    }
}
