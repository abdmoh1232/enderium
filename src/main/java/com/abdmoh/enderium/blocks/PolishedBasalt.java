package com.abdmoh.enderium.blocks;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class PolishedBasalt extends RotatedPillarBlock {
    public PolishedBasalt() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(1.25F, 4.2F)
        );
        setRegistryName("polished_basalt");
    }
}
