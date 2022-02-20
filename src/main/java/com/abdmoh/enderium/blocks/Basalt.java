package com.abdmoh.enderium.blocks;

import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Basalt extends RotatedPillarBlock {
    public Basalt() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(1.25F, 4.2F)
        );
        setRegistryName("basalt");
    }
}
