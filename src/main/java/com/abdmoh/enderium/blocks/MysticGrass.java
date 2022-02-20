package com.abdmoh.enderium.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.block.material.Material;

public class MysticGrass extends TallGrassBlock {
    public MysticGrass() {
        super(Properties.create(Material.TALL_PLANTS)
                .sound(SoundType.PLANT)
                .hardnessAndResistance(0.0F)
                .doesNotBlockMovement()
        );
        setRegistryName("mystic_grass");
    }
}
