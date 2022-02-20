package com.abdmoh.enderium.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnchantedPlanks extends Block {
    public EnchantedPlanks() {
        super(Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.0F, 3.0F)
        );
        setRegistryName("enchanted_planks");
    }
}
