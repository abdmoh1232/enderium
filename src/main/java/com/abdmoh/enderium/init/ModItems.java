package com.abdmoh.enderium.init;

import com.abdmoh.enderium.Enderium;
import net.minecraft.item.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Enderium.MOD_ID)
public class ModItems {
    private static final ItemGroup item_group = Enderium.setup.itemGroup;
    private static final Item.Properties properties = new Item.Properties().group(Enderium.setup.itemGroup);

    //building blocks
    public static final Item MYSTICAL_CRYSTAL = new BlockItem(ModBlocks.MYSTICAL_CRYSTAL, properties).setRegistryName("mystical_crystal");
    public static final Item ANCIENT_DEBRIS = new BlockItem(ModBlocks.ANCIENT_DEBRIS, properties).setRegistryName("ancient_debris");
    public static final Item ENCHANTED_LOG = new BlockItem(ModBlocks.ENCHANTED_LOG, properties).setRegistryName("enchanted_log");
    public static final Item ENCHANTED_WOOD = new BlockItem(ModBlocks.ENCHANTED_WOOD, properties).setRegistryName("enchanted_wood");
    public static final Item STRIPPED_ENCHANTED_LOG = new BlockItem(ModBlocks.STRIPPED_ENCHANTED_LOG, properties).setRegistryName("stripped_enchanted_log");
    public static final Item STRIPPED_ENCHANTED_WOOD = new BlockItem(ModBlocks.STRIPPED_ENCHANTED_WOOD, properties).setRegistryName("stripped_enchanted_wood");
    public static final Item ENCHANTED_PLANKS = new BlockItem(ModBlocks.ENCHANTED_PLANKS, properties).setRegistryName("enchanted_planks");
    public static final Item END_DIAMOND_ORE = new BlockItem(ModBlocks.END_DIAMOND_ORE, properties).setRegistryName("end_diamond_ore");
    public static final Item NETHER_GOLD_ORE = new BlockItem(ModBlocks.NETHER_GOLD_ORE, properties).setRegistryName("nether_gold_ore");
    public static final Item ENDERIUM_BLOCK = new BlockItem(ModBlocks.ENDERIUM_BLOCK, properties).setRegistryName("enderium_block");
    public static final Item NETHERITE_BLOCK = new BlockItem(ModBlocks.NETHERITE_BLOCK, properties).setRegistryName("netherite_block");
    public static final Item ENCHANTED_CONJIUM = new BlockItem(ModBlocks.ENCHANTED_CONJIUM, properties).setRegistryName("enchanted_conjium");
    public static final Item COMPLITE = new BlockItem(ModBlocks.COMPLITE, properties).setRegistryName("complite");
    public static final Item POLISHED_COMPLITE = new BlockItem(ModBlocks.POLISHED_COMPLITE, properties).setRegistryName("polished_complite");
    public static final Item BASALT = new BlockItem(ModBlocks.BASALT, properties).setRegistryName("basalt");
    public static final Item POLISHED_BASALT = new BlockItem(ModBlocks.POLISHED_BASALT, properties).setRegistryName("polished_basalt");

    //decorations
    public static final Item ENCHANTED_SAPLING = new BlockItem(ModBlocks.ENCHANTED_SAPLING, properties).setRegistryName("enchanted_sapling");
    public static final Item MYSTIC_GRASS = new BlockItem(ModBlocks.MYSTIC_GRASS, properties).setRegistryName("mystic_grass");

    //miscellaneous
    public static final Item ENDERIUM_CRYSTAL = new Item(new Item.Properties().group(item_group)).setRegistryName("enderium_crystal");
    public static final Item INFUSED_DIAMOND = new Item(new Item.Properties().group(item_group)).setRegistryName("infused_diamond");
    public static final Item MYSTICAL_DUST = new Item(new Item.Properties().group(item_group)).setRegistryName("mystical_dust");
    public static final Item NETHERITE_SCRAP = new Item(new Item.Properties().group(item_group)).setRegistryName("netherite_scrap");
    public static final Item NETHERITE_INGOT = new Item(new Item.Properties().group(item_group)).setRegistryName("netherite_ingot");

    //spawn eggs
    public static Item ENDER_SENTRY_EGG = new SpawnEggItem(ModEntities.ENDER_SENTRY, 0xec11f7, 0x8513d1, properties).setRegistryName("ender_sentry_egg");

    //tools
    public static AxeItem ENDERIUM_AXE;
    public static SwordItem ENDERIUM_SWORD;
    public static PickaxeItem ENDERIUM_PICKAXE;
    public static HoeItem ENDERIUM_HOE;
    public static ShovelItem ENDERIUM_SHOVEL;
    public static AxeItem NETHERITE_AXE;
    public static SwordItem NETHERITE_SWORD;
    public static PickaxeItem NETHERITE_PICKAXE;
    public static HoeItem NETHERITE_HOE;
    public static ShovelItem NETHERITE_SHOVEL;

    //armour
    public static ArmorItem ENDERIUM_HELMET;
    public static ArmorItem ENDERIUM_CHESTPLATE;
    public static ArmorItem ENDERIUM_LEGGINGS;
    public static ArmorItem ENDERIUM_BOOTS;
    public static ArmorItem NETHERITE_HELMET;
    public static ArmorItem NETHERITE_CHESTPLATE;
    public static ArmorItem NETHERITE_LEGGINGS;
    public static ArmorItem NETHERITE_BOOTS;
}
