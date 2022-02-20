package com.abdmoh.enderium.setup;

import com.abdmoh.enderium.Enderium;
import com.abdmoh.enderium.init.*;
import net.minecraft.block.Block;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegistryEvents {
    //registers blocks
    @SubscribeEvent
    public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
        //blocks registered
        event.getRegistry().registerAll(
                //building blocks
                ModBlocks.MYSTICAL_CRYSTAL,
                ModBlocks.ANCIENT_DEBRIS,
                ModBlocks.ENCHANTED_LOG,
                ModBlocks.ENCHANTED_WOOD,
                ModBlocks.STRIPPED_ENCHANTED_LOG,
                ModBlocks.STRIPPED_ENCHANTED_WOOD,
                ModBlocks.ENCHANTED_PLANKS,
                ModBlocks.END_DIAMOND_ORE,
                ModBlocks.NETHER_GOLD_ORE,
                ModBlocks.ENDERIUM_BLOCK,
                ModBlocks.NETHERITE_BLOCK,
                ModBlocks.ENCHANTED_CONJIUM,
                ModBlocks.COMPLITE,
                ModBlocks.POLISHED_COMPLITE,
                ModBlocks.BASALT,
                ModBlocks.POLISHED_BASALT,

                //decorations
                ModBlocks.MYSTIC_GRASS,
                ModBlocks.ENCHANTED_SAPLING
        );
    }

    //registers items
    @SubscribeEvent
    public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
        //items registered
        event.getRegistry().registerAll(
                //building blocks
                ModItems.MYSTICAL_CRYSTAL,
                ModItems.ANCIENT_DEBRIS,
                ModItems.ENCHANTED_LOG,
                ModItems.ENCHANTED_WOOD,
                ModItems.STRIPPED_ENCHANTED_LOG,
                ModItems.STRIPPED_ENCHANTED_WOOD,
                ModItems.ENCHANTED_PLANKS,
                ModItems.END_DIAMOND_ORE,
                ModItems.NETHER_GOLD_ORE,
                ModItems.ENDERIUM_BLOCK,
                ModItems.NETHERITE_BLOCK,
                ModItems.ENCHANTED_CONJIUM,
                ModItems.COMPLITE,
                ModItems.POLISHED_COMPLITE,
                ModItems.BASALT,
                ModItems.POLISHED_BASALT,

                //decorations
                ModItems.ENCHANTED_SAPLING,
                ModItems.MYSTIC_GRASS,

                //miscellaneous
                ModItems.ENDERIUM_CRYSTAL,
                ModItems.INFUSED_DIAMOND,
                ModItems.MYSTICAL_DUST,
                ModItems.NETHERITE_SCRAP,
                ModItems.NETHERITE_INGOT,

                //spawn eggs
                ModItems.ENDER_SENTRY_EGG,

                //tools registered
                //enderium tools
                ModItems.ENDERIUM_AXE = (AxeItem) new AxeItem(
                        ModToolMaterials.enderium,
                        5.0F,
                        -2.8F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_axe"),

                ModItems.ENDERIUM_HOE = (HoeItem) new HoeItem(
                        ModToolMaterials.enderium,
                        1.0F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_hoe"),

                ModItems.ENDERIUM_PICKAXE = (PickaxeItem) new PickaxeItem(
                        ModToolMaterials.enderium,
                        1,
                        -2.5F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_pickaxe"),

                ModItems.ENDERIUM_SHOVEL = (ShovelItem) new ShovelItem(
                        ModToolMaterials.enderium,
                        1.5F,
                        -2.8F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_shovel"),

                ModItems.ENDERIUM_SWORD = (SwordItem) new SwordItem(
                        ModToolMaterials.enderium,
                        3,
                        -2.0F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_sword"),

                //netherite tools
                ModItems.NETHERITE_AXE = (AxeItem) new AxeItem(
                        ModToolMaterials.netherite,
                        5.0F,
                        -3.0F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_axe"),

                ModItems.NETHERITE_HOE = (HoeItem) new HoeItem(
                        ModToolMaterials.netherite,
                        1.0F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_hoe"),

                ModItems.NETHERITE_PICKAXE = (PickaxeItem) new PickaxeItem(
                        ModToolMaterials.netherite,
                        1,
                        -2.8F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_pickaxe"),

                ModItems.NETHERITE_SHOVEL = (ShovelItem) new ShovelItem(
                        ModToolMaterials.netherite,
                        1.5F,
                        -3.0F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_shovel"),

                ModItems.NETHERITE_SWORD = (SwordItem) new SwordItem(
                        ModToolMaterials.netherite,
                        3,
                        -2.4F,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_sword"),


                //armour registered
                //enderium armour
                ModItems.ENDERIUM_HELMET = (ArmorItem) new ArmorItem(
                        ModArmorMaterials.enderium,
                        EquipmentSlotType.HEAD,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_helmet"),

                ModItems.ENDERIUM_CHESTPLATE = (ArmorItem) new ArmorItem(
                        ModArmorMaterials.enderium,
                        EquipmentSlotType.CHEST,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_chestplate"),

                ModItems.ENDERIUM_LEGGINGS = (ArmorItem) new ArmorItem(
                        ModArmorMaterials.enderium,
                        EquipmentSlotType.LEGS,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_leggings"),

                ModItems.ENDERIUM_BOOTS = (ArmorItem) new ArmorItem(
                        ModArmorMaterials.enderium,
                        EquipmentSlotType.FEET,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("enderium_boots"),

                //netherite armour
                ModItems.NETHERITE_HELMET = (ArmorItem) new ArmorItem(
                        ModArmorMaterials.netherite,
                        EquipmentSlotType.HEAD,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_helmet"),

                ModItems.NETHERITE_CHESTPLATE = (ArmorItem) new ArmorItem(
                        ModArmorMaterials.netherite,
                        EquipmentSlotType.CHEST,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_chestplate"),

                ModItems.NETHERITE_LEGGINGS = (ArmorItem) new ArmorItem(
                        ModArmorMaterials.netherite,
                        EquipmentSlotType.LEGS,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_leggings"),

                ModItems.NETHERITE_BOOTS = (ArmorItem) new ArmorItem(
                        ModArmorMaterials.netherite,
                        EquipmentSlotType.FEET,
                        new Item.Properties()
                                .group(Enderium.setup.itemGroup))
                        .setRegistryName("netherite_boots")
        );
    }


    //registers entities
    @SubscribeEvent
    public static void onEntitiesRegistry(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll(
                ModEntities.ENDER_SENTRY.setRegistryName("ender_sentry")
        );
        //code below ensures that the mob doesn't spawn over void
        EntitySpawnPlacementRegistry.register(ModEntities.ENDER_SENTRY, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING, ModEntities::endIslandCondition);
        //code below allows all entities to spawn
        ModEntities.registerWorldSpawns();
    }
}
