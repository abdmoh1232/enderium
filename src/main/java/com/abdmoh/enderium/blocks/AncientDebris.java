package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class AncientDebris extends Block {
    public AncientDebris() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.STONE)
                .hardnessAndResistance(30.0F, 1200F)
                .harvestLevel(3)
        );
        setRegistryName("ancient_debris");
    }
}
