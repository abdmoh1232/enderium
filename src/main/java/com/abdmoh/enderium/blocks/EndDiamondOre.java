package com.abdmoh.enderium.blocks;

import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class EndDiamondOre extends OreBlock {
    public EndDiamondOre() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(3.0F, 4.5F)
                .harvestLevel(2)
        );
        setRegistryName("end_diamond_ore");
    }

    //gives xp when mining (without silk touch)
    @Override
    public int getExperience(Random p_220281_1_) {
        return MathHelper.nextInt(p_220281_1_, 3, 7);
    }
}
