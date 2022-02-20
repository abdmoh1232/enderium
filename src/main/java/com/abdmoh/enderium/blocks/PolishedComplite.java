package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class PolishedComplite extends Block {
    public PolishedComplite() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(2.5F, 8.0F)
        );
        setRegistryName("polished_complite");
    }
}
