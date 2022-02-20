//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.abdmoh.enderium.blocks.trees;

import com.abdmoh.enderium.init.ModBlocks;
import com.abdmoh.enderium.world.features.EnchantedTreeFeature;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class EnchantedTree extends Tree {
    //config for the enchanted tree (includes log type, leaves and tree properties e.g. height)
    private final TreeFeatureConfig ENCHANTED_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(ModBlocks.ENCHANTED_LOG.getDefaultState()),
            new SimpleBlockStateProvider(ModBlocks.COMPLITE.getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(8).foliageHeight(3).ignoreVines().setSapling((IPlantable) ModBlocks.ENCHANTED_SAPLING).build();

    //method that assigns the tree feature class to the tree class
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return new EnchantedTreeFeature(TreeFeatureConfig::deserializeFoliage).withConfiguration(ENCHANTED_TREE_CONFIG);
    }
}
