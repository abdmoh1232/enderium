//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.abdmoh.enderium.world.features;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class EnchantedTree extends Tree {
    @Nullable
    public AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return new EnchantedTreeFeature(NoFeatureConfig::deserialize, true, false);
    }
}
