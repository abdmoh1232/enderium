package com.abdmoh.enderium.world.gen;

import com.abdmoh.enderium.config.OreGenConfig;
import com.abdmoh.enderium.init.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void setupOreGen() {
        //generates mystical crystals
        if (OreGenConfig.generate_enderium.get()) {
            for (Biome biome: ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                        FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE)),
                        ModBlocks.MYSTICAL_CRYSTAL.getDefaultState(), OreGenConfig.enderium_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.enderium_chance.get(), OreGenConfig.enderium_bottom.get(), 0, OreGenConfig.enderium_top.get())));
            }
        }
        //generates ancient debris
        if (OreGenConfig.generate_netherite.get()) {
            for (Biome biome: ForgeRegistries.BIOMES) {
                //high concentration vein
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
                        ModBlocks.ANCIENT_DEBRIS.getDefaultState(), OreGenConfig.netherite_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(1, OreGenConfig.netherite_bottom.get(), 0, OreGenConfig.netherite_top.get())));

                //low concentration vein
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
                        ModBlocks.ANCIENT_DEBRIS.getDefaultState(), OreGenConfig.low_netherite_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(1, OreGenConfig.low_netherite_bottom.get(), 0, OreGenConfig.low_netherite_top.get())));
            }
        }
        //generates end diamond ore
        if (OreGenConfig.generate_end_diamond.get()) {
            for (Biome biome : ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                        FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE)),
                        ModBlocks.END_DIAMOND_ORE.getDefaultState(), OreGenConfig.end_diamond_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.end_diamond_chance.get(), OreGenConfig.end_diamond_bottom.get(), 0, OreGenConfig.end_diamond_top.get())));
            }
        }
        //generates nether gold ore
        if (OreGenConfig.generate_nether_gold.get()) {
            for (Biome biome : ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
                        ModBlocks.NETHER_GOLD_ORE.getDefaultState(), OreGenConfig.nether_gold_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.nether_gold_chance.get(), OreGenConfig.nether_gold_bottom.get(), 0, OreGenConfig.nether_gold_top.get())));
            }
        }
        //generates basalt
        if (OreGenConfig.generate_basalt.get()) {
            for (Biome biome : ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NETHERRACK,
                        ModBlocks.BASALT.getDefaultState(), OreGenConfig.basalt_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.basalt_chance.get(), OreGenConfig.basalt_bottom.get(), 0, OreGenConfig.basalt_top.get())));
            }
        }

        //generates complite
        if (OreGenConfig.generate_complite.get()) {
            for (Biome biome : ForgeRegistries.BIOMES) {
                biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(
                        FillerBlockType.create("END_STONE","end_stone", new BlockMatcher(Blocks.END_STONE)),
                        ModBlocks.COMPLITE.getDefaultState(), OreGenConfig.complite_count.get()), Placement.COUNT_RANGE,
                        new CountRangeConfig(OreGenConfig.complite_chance.get(), OreGenConfig.complite_bottom.get(), 0, OreGenConfig.complite_top.get())));
            }
        }
    }
}
