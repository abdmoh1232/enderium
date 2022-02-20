package com.abdmoh.enderium.init;

import com.abdmoh.enderium.blocks.*;
import com.abdmoh.enderium.blocks.trees.EnchantedTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder("enderium")
public class ModBlocks {
    //building blocks tab
    public static Block MYSTICAL_CRYSTAL = new GlassBlock(Block.Properties.create(Material.ROCK, MaterialColor.MAGENTA).sound(SoundType.GLASS).hardnessAndResistance(30.0F, 1200.0F).notSolid().lightValue(8).harvestLevel(4).harvestTool(ToolType.PICKAXE)).setRegistryName("mystical_crystal");
    public static Block ANCIENT_DEBRIS = new Block(Block.Properties.create(Material.ROCK, MaterialColor.BROWN).sound(SoundType.STONE).hardnessAndResistance(30.0F, 1200.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE)).setRegistryName("ancient_debris");
    public static Block ENCHANTED_LOG = new LogBlock(MaterialColor.PURPLE, Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)).setRegistryName("enchanted_log");
    public static Block ENCHANTED_WOOD = new LogBlock(MaterialColor.PURPLE, Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)).setRegistryName("enchanted_wood");
    public static Block STRIPPED_ENCHANTED_LOG = new LogBlock(MaterialColor.PURPLE, Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)).setRegistryName("stripped_enchanted_log");
    public static Block STRIPPED_ENCHANTED_WOOD = new LogBlock(MaterialColor.PURPLE, Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2.0F)).setRegistryName("stripped_enchanted_wood");
    public static Block ENCHANTED_PLANKS = new Block(Block.Properties.create(Material.WOOD, MaterialColor.PURPLE).sound(SoundType.WOOD).hardnessAndResistance(2.0F, 3.0F)).setRegistryName("enchanted_planks");
    public static Block END_DIAMOND_ORE = new ModOreBlock(Block.Properties.create(Material.ROCK, MaterialColor.CYAN).sound(SoundType.STONE).hardnessAndResistance(3.0F, 4.5F).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("end_diamond_ore");
    public static Block NETHER_GOLD_ORE = new ModOreBlock(Block.Properties.create(Material.ROCK, MaterialColor.GOLD).sound(SoundType.STONE).hardnessAndResistance(3.0F, 4.5F).harvestLevel(2).harvestTool(ToolType.PICKAXE)).setRegistryName("nether_gold_ore");
    public static Block ENDERIUM_BLOCK = new ModMetalBlock(Block.Properties.create(Material.IRON, MaterialColor.MAGENTA).sound(SoundType.METAL).hardnessAndResistance(50.0F, 1200.0F).harvestLevel(4).harvestTool(ToolType.PICKAXE)).setRegistryName("enderium_block");
    public static Block NETHERITE_BLOCK = new ModMetalBlock(Block.Properties.create(Material.IRON, MaterialColor.BLACK).sound(SoundType.METAL).hardnessAndResistance(50.0F, 1200.0F).harvestLevel(3).harvestTool(ToolType.PICKAXE)).setRegistryName("netherite_block");
    public static Block ENCHANTED_CONJIUM = new ModGrassBlock(Block.Properties.create(Material.ROCK, MaterialColor.PINK).sound(SoundType.STONE).hardnessAndResistance(2.5F, 8.0F)).setRegistryName("enchanted_conjium");
    public static Block COMPLITE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.OBSIDIAN).sound(SoundType.STONE).hardnessAndResistance(2.5F, 8.0F).harvestTool(ToolType.PICKAXE)).setRegistryName("complite");
    public static Block POLISHED_COMPLITE = new Block(Block.Properties.create(Material.ROCK, MaterialColor.OBSIDIAN).sound(SoundType.STONE).hardnessAndResistance(2.5F, 8.0F).harvestTool(ToolType.PICKAXE)).setRegistryName("polished_complite");
    public static Block BASALT = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(1.25F, 4.2F).harvestTool(ToolType.PICKAXE)).setRegistryName("basalt");
    public static Block POLISHED_BASALT = new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.GRAY).sound(SoundType.STONE).hardnessAndResistance(1.25F, 4.2F).harvestTool(ToolType.PICKAXE)).setRegistryName("polished_basalt");


    //decorations tab
    public static Block ENCHANTED_SAPLING = new ModSaplingBlock(new EnchantedTree(), Block.Properties.create(Material.PLANTS, MaterialColor.OBSIDIAN).sound(SoundType.PLANT).hardnessAndResistance(0.0F).doesNotBlockMovement()).setRegistryName("enchanted_sapling");
    public static Block MYSTIC_GRASS = new ModTallGrassBlock(Block.Properties.create(Material.TALL_PLANTS).sound(SoundType.PLANT).hardnessAndResistance(0.0F).doesNotBlockMovement()).setRegistryName("mystic_grass");
}
