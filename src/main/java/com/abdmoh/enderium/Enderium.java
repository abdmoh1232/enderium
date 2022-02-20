package com.abdmoh.enderium;

import com.abdmoh.enderium.client.renders.ModRenderRegistry;
import com.abdmoh.enderium.config.Config;
import com.abdmoh.enderium.init.ModBlocks;
import com.abdmoh.enderium.init.ModVanillaCompat;
import com.abdmoh.enderium.setup.ModSetup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
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
        Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("enderium-common.toml").toString());

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        //initialises the setup class
        setup.init();
        //Allows modded blocks to be composted, burn and stripped
        ModVanillaCompat.init();

        LOGGER.info("setup method registered");
    }

    private void clientRegistries(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModBlocks.MYSTICAL_CRYSTAL, RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(ModBlocks.MYSTIC_GRASS, RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ENCHANTED_SAPLING, RenderType.getCutout());

        //registers entities
        ModRenderRegistry.registryEntityRenders();
        LOGGER.info("clientRegistries method registered");
    }
}
