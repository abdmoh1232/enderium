package com.abdmoh.enderium.blocks;

import com.abdmoh.enderium.init.ModBlocks;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class ModOreBlock extends OreBlock {
    public ModOreBlock(Properties properties) {
        super(properties);
    }

    //gives xp when mining (without silk touch)
    @Override
    public int getExperience(Random p_220281_1_) {
        if (this == ModBlocks.END_DIAMOND_ORE) {
            return MathHelper.nextInt(p_220281_1_, 3, 7);
        }
        else {
            return this == ModBlocks.NETHER_GOLD_ORE ? MathHelper.nextInt(p_220281_1_, 2, 6) : 0;
        }
    }
}
