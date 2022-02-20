package com.abdmoh.enderium.blocks;

import net.minecraft.block.LogBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class StrippedEnchantedWood extends LogBlock {
    public StrippedEnchantedWood() {
        super(MaterialColor.PURPLE, Properties.create(Material.WOOD)
                .sound(SoundType.WOOD)
                .hardnessAndResistance(2.0F)
        );
        setRegistryName("stripped_enchanted_wood");
    }
}
