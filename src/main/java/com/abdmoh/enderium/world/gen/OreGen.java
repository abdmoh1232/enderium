package com.abdmoh.enderium.world.gen;

import com.abdmoh.enderium.config.OreGenConfig;
import com.abdmoh.enderium.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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

import javax.swing.*;

public class OreGen {
    //initialises end stone as a filler block type (to allow ore gen in the end)
    private static final FillerBlockType END_STONE = FillerBlockType.create("END_STONE", "end_stone", new BlockMatcher(Blocks.END_STONE));

    public static void setupOreGen() {
        //generates mystical crystals
        if (OreGenConfig.generate_enderium.get()) {
            generateOre(END_STONE, ModBlocks.MYSTICAL_CRYSTAL.getDefaultState(), OreGenConfig.enderium_count.get(),
                    OreGenConfig.enderium_chance.get(), OreGenConfig.enderium_bottom.get(), 0, OreGenConfig.enderium_top.get()
            );
        }
        //generates ancient debris
        if (OreGenConfig.generate_netherite.get()) {
            //high concentration vein
            generateOre(FillerBlockType.NETHERRACK, ModBlocks.ANCIENT_DEBRIS.getDefaultState(), OreGenConfig.netherite_count.get(),
                    1, OreGenConfig.netherite_bottom.get(), 0, OreGenConfig.netherite_top.get()
            );

            //low concentration vein
            generateOre(FillerBlockType.NETHERRACK, ModBlocks.ANCIENT_DEBRIS.getDefaultState(), OreGenConfig.low_netherite_count.get(),
                    1, OreGenConfig.low_netherite_bottom.get(), 0, OreGenConfig.low_netherite_top.get()
            );
        }
        //generates end diamond ore
        if (OreGenConfig.generate_end_diamond.get()) {
            generateOre(END_STONE, ModBlocks.END_DIAMOND_ORE.getDefaultState(), OreGenConfig.end_diamond_count.get(),
                    OreGenConfig.end_diamond_chance.get(), OreGenConfig.end_diamond_bottom.get(), 0, OreGenConfig.end_diamond_top.get()
            );
        }
        //generates nether gold ore
        if (OreGenConfig.generate_nether_gold.get()) {
            generateOre(FillerBlockType.NETHERRACK, ModBlocks.NETHER_GOLD_ORE.getDefaultState(), OreGenConfig.nether_gold_count.get(),
                    OreGenConfig.nether_gold_chance.get(), OreGenConfig.nether_gold_bottom.get(), 0, OreGenConfig.nether_gold_top.get()
            );
        }
        //generates basalt
        if (OreGenConfig.generate_basalt.get()) {
            generateOre(FillerBlockType.NETHERRACK, ModBlocks.BASALT.getDefaultState(), OreGenConfig.basalt_count.get(),
                    OreGenConfig.basalt_chance.get(), OreGenConfig.basalt_bottom.get(), 0, OreGenConfig.basalt_top.get()
            );
        }

        //generates complite
        if (OreGenConfig.generate_complite.get()) {
            generateOre(END_STONE, ModBlocks.COMPLITE.getDefaultState(), OreGenConfig.complite_count.get(),
                    OreGenConfig.complite_chance.get(), OreGenConfig.complite_bottom.get(), 0, OreGenConfig.complite_top.get()
            );
        }
    }

    private static void generateOre(FillerBlockType filler_block_type, BlockState block_state, int ore_count, int ore_chance, int ore_bottom, int ore_offset, int ore_top) {
        for (Biome biome: ForgeRegistries.BIOMES) {
            biome.addFeature(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(filler_block_type, block_state, ore_count))
                    .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(ore_chance, ore_bottom, ore_offset, ore_top)))
            );
        }
    }
}
