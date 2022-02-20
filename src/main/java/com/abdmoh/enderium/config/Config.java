package com.abdmoh.enderium.config;

import com.abdmoh.enderium.Enderium;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config {
    //initialises the server config
    public static final ForgeConfigSpec SERVER_CONFIG;
    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();

    static {
        //initialises the oregen config
        OreGenConfig.init(SERVER_BUILDER);
        //initialises the mob spawning config
        MobSpawnConfig.init(SERVER_BUILDER);

        //creates the config files
        SERVER_CONFIG = SERVER_BUILDER.build();
    }

    public static void loadConfig(ForgeConfigSpec CONFIG, String path) {
        Enderium.LOGGER.info("Loading config: " + path);
        final CommentedFileConfig FILE = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        Enderium.LOGGER.info("Built config: " + path);
        FILE.load();
        Enderium.LOGGER.info("Loaded config: " + path);
        CONFIG.setConfig(FILE);
    }
}
