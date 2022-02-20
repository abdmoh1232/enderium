package com.abdmoh.enderium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MobSpawnConfig {
    public static ForgeConfigSpec.BooleanValue ender_sentry_spawn;
    public static ForgeConfigSpec.IntValue ender_sentry_weight;
    public static ForgeConfigSpec.IntValue ender_sentry_min;
    public static ForgeConfigSpec.IntValue ender_sentry_max;

    public static void init(ForgeConfigSpec.Builder server) {
        server.comment("MobSpawning Config");

        ender_sentry_spawn = server
                .comment("Choose whether the ender sentry spawns in the game or not [default = true]")
                .define("mobspawn.ender_sentry_spawn", true);

        ender_sentry_weight = server
                .comment("Chance for the ender sentry to spawn per chunk [default = 5]")
                .defineInRange("mobspawn.ender_sentry_weight", 5, 0, 100);

        ender_sentry_min = server
                .comment("Minimum number of Ender Sentries that spawn in a group [default = 1]")
                .defineInRange("mobspawn.ender_sentry_min", 1, 0, 10);

        ender_sentry_max = server
                .comment("Maximum number of Ender Sentries that spawn in a group [default = 3]")
                .defineInRange("mobspawn.ender_sentry_max", 3, 0, 10);
    }
}
