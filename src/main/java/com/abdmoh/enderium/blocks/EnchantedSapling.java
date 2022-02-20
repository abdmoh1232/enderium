package com.abdmoh.enderium.blocks;

import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.trees.Tree;

public class EnchantedSapling extends SaplingBlock {
    public EnchantedSapling(Tree treeIn) {
        super(treeIn, Properties.create(Material.PLANTS)
                .sound(SoundType.PLANT)
                .hardnessAndResistance(0.0F)
                .doesNotBlockMovement()
        );
        setRegistryName("enchanted_sapling");
    }
}
