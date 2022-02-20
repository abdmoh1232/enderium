package com.abdmoh.enderium.blocks;

import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class MysticalCrystal extends GlassBlock {
    public MysticalCrystal() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.GLASS)
                .hardnessAndResistance(30.0F, 1200.0F)
                .lightValue(8)
                .harvestLevel(3)
        );
        setRegistryName("mystical_crystal");
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }
}
