package com.abdmoh.enderium;

import com.abdmoh.enderium.blocks.*;
import com.abdmoh.enderium.client.renders.ModRenderRegistry;
import com.abdmoh.enderium.config.Config;
import com.abdmoh.enderium.init.*;
import com.abdmoh.enderium.items.*;
import com.abdmoh.enderium.setup.ClientProxy;
import com.abdmoh.enderium.setup.IProxy;
import com.abdmoh.enderium.setup.ModSetup;
import com.abdmoh.enderium.setup.ServerProxy;
import com.abdmoh.enderium.world.features.EnchantedTree;
import net.minecraft.block.Block;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("enderium")
public class Enderium {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    public static ModSetup setup = new ModSetup();
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "enderium";

    public Enderium() {
        //registers config files
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

        // Register the setup method for mod loading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

        //loads config files
        Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("enderium-server.toml").toString());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        //initialises the setup and proxy
        setup.init();
        proxy.init();
        //Allows modded blocks to be composted, burn and stripped
        ModVanillaCompat.init();

        LOGGER.info("setup method registered");
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        //registers entities
        ModRenderRegistry.registryEntityRenders();
        LOGGER.info("clientRegistries method registered");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        //registers blocks
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            //blocks registered
            event.getRegistry().registerAll(
                    new EnchantedLog(),
                    new EnchantedWood(),
                    new StrippedEnchantedLog(),
                    new StrippedEnchantedWood(),
                    new EnchantedPlanks(),
                    new EnchantedConjium(),
                    new PolishedComplite(),
                    new PolishedBasalt(),
                    new EndDiamondOre(),
                    new NetherGoldOre(),
                    new Basalt(),
                    new Complite(),
                    new MysticalCrystal(),
                    new AncientDebris(),
                    new EnderiumBlock(),
                    new NetheriteBlock(),
                    new MysticGrass(),
                    new EnchantedSapling(new EnchantedTree())
            );
        }

        //registers items
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            Item.Properties properties = new Item.Properties()
                    .group(setup.itemGroup);

            //block items registered
            event.getRegistry().registerAll(
                    new BlockItem(ModBlocks.ENCHANTED_LOG, properties).setRegistryName("enchanted_log"),
                    new BlockItem(ModBlocks.ENCHANTED_WOOD, properties).setRegistryName("enchanted_wood"),
                    new BlockItem(ModBlocks.STRIPPED_ENCHANTED_LOG, properties).setRegistryName("stripped_enchanted_log"),
                    new BlockItem(ModBlocks.STRIPPED_ENCHANTED_WOOD, properties).setRegistryName("stripped_enchanted_wood"),
                    new BlockItem(ModBlocks.ENCHANTED_PLANKS, properties).setRegistryName("enchanted_planks"),
                    new BlockItem(ModBlocks.ENCHANTED_CONJIUM, properties).setRegistryName("enchanted_conjium"),
                    new BlockItem(ModBlocks.POLISHED_COMPLITE, properties).setRegistryName("polished_complite"),
                    new BlockItem(ModBlocks.POLISHED_BASALT, properties).setRegistryName("polished_basalt"),
                    new BlockItem(ModBlocks.END_DIAMOND_ORE, properties).setRegistryName("end_diamond_ore"),
                    new BlockItem(ModBlocks.NETHER_GOLD_ORE, properties).setRegistryName("nether_gold_ore"),
                    new BlockItem(ModBlocks.BASALT, properties).setRegistryName("basalt"),
                    new BlockItem(ModBlocks.COMPLITE, properties).setRegistryName("complite"),
                    new BlockItem(ModBlocks.MYSTICAL_CRYSTAL, properties).setRegistryName("mystical_crystal"),
                    new BlockItem(ModBlocks.ANCIENT_DEBRIS, properties).setRegistryName("ancient_debris"),
                    new BlockItem(ModBlocks.ENDERIUM_BLOCK, properties).setRegistryName("enderium_block"),
                    new BlockItem(ModBlocks.NETHERITE_BLOCK, properties).setRegistryName("netherite_block"),
                    new BlockItem(ModBlocks.MYSTIC_GRASS, properties).setRegistryName("mystic_grass"),
                    new BlockItem(ModBlocks.ENCHANTED_SAPLING, properties).setRegistryName("enchanted_sapling")
            );

            //items registered
            event.getRegistry().registerAll(
                    //other items registered
                    ModItems.ENDERIUM_CRYSTAL = new EnderiumCrystal(),
                    ModItems.INFUSED_DIAMOND = new InfusedDiamond(),
                    ModItems.MYSTICAL_DUST = new MysticalDust(),
                    ModItems.NETHERITE_SCRAP = new NetheriteScrap(),
                    ModItems.NETHERITE_INGOT = new NetheriteIngot(),

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

            //registers entity spawn eggs
            ModEntities.registerSpawnEggs(event);
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
}
