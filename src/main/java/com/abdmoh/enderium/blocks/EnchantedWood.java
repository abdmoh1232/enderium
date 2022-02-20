package com.abdmoh.enderium.blocks;

import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class EnchantedWood extends LogBlock {
    public EnchantedWood() {
        super(MaterialColor.PURPLE, Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.0F)
        );
        setRegistryName("enchanted_wood");
    }
}
