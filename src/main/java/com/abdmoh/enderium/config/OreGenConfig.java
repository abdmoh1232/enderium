package com.abdmoh.enderium.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
    //mystical crystal configs
    public static ForgeConfigSpec.IntValue enderium_chance;
    public static ForgeConfigSpec.IntValue enderium_count;
    public static ForgeConfigSpec.IntValue enderium_bottom;
    public static ForgeConfigSpec.IntValue enderium_top;
    public static ForgeConfigSpec.BooleanValue generate_enderium;

    //ancient debris configs
    //2 veins of netherite will be generated per chunk: 1 high concentration and 1 low concentration
    public static ForgeConfigSpec.IntValue netherite_count;
    public static ForgeConfigSpec.IntValue netherite_bottom;
    public static ForgeConfigSpec.IntValue netherite_top;
    //the variables below are for low concentration veins
    public static ForgeConfigSpec.IntValue low_netherite_count;
    public static ForgeConfigSpec.IntValue low_netherite_bottom;
    public static ForgeConfigSpec.IntValue low_netherite_top;
    public static ForgeConfigSpec.BooleanValue generate_netherite;

    //end diamond ore configs
    public static ForgeConfigSpec.IntValue end_diamond_chance;
    public static ForgeConfigSpec.IntValue end_diamond_count;
    public static ForgeConfigSpec.IntValue end_diamond_bottom;
    public static ForgeConfigSpec.IntValue end_diamond_top;
    public static ForgeConfigSpec.BooleanValue generate_end_diamond;

    //nether gold ore configs
    public static ForgeConfigSpec.IntValue nether_gold_chance;
    public static ForgeConfigSpec.IntValue nether_gold_count;
    public static ForgeConfigSpec.IntValue nether_gold_bottom;
    public static ForgeConfigSpec.IntValue nether_gold_top;
    public static ForgeConfigSpec.BooleanValue generate_nether_gold;

    //basalt configs
    public static ForgeConfigSpec.IntValue basalt_chance;
    public static ForgeConfigSpec.IntValue basalt_count;
    public static ForgeConfigSpec.IntValue basalt_bottom;
    public static ForgeConfigSpec.IntValue basalt_top;
    public static ForgeConfigSpec.BooleanValue generate_basalt;

    //complite configs
    public static ForgeConfigSpec.IntValue complite_chance;
    public static ForgeConfigSpec.IntValue complite_count;
    public static ForgeConfigSpec.IntValue complite_bottom;
    public static ForgeConfigSpec.IntValue complite_top;
    public static ForgeConfigSpec.BooleanValue generate_complite;

    public static void init(ForgeConfigSpec.Builder server) {
        server.comment("OreGen Config");

        //enderium generation config
        enderium_count = server
                .comment("Maximum number of mystical crystals in a vein [default = 4]")
                .defineInRange("oregen.enderium_count", 4, 1, 100);

        enderium_chance = server
                .comment("Maximum number of mystical crystal veins that can spawn in one chunk [default = 2]")
                .defineInRange("oregen.enderium_chance", 2, 1, 100);

        enderium_bottom = server
                .comment("Lowest y-value mystical crystals can spawn at [default = 4]")
                .defineInRange("oregen.enderium_bottom", 4, 0, 255);

        enderium_top = server
                .comment("Highest y-value mystical crystals can spawn at [default = 25]")
                .defineInRange("oregen.enderium_top", 25, 0, 255);

        generate_enderium = server
                .comment("Decide if you want mystical crystals to generate [default = true]")
                .define("oregen.generate_enderium", true);

        //netherite generation config
        netherite_count = server
                .comment("Maximum number of ancient debris per high concentration vein (low y-values) [default = 3]")
                .defineInRange("oregen.netherite_count", 3, 1, 100);

        netherite_bottom = server
                .comment("Lowest y-value high concentration ancient debris can spawn at [default = 8]")
                .defineInRange("oregen.netherite_bottom", 8, 0, 255);

        netherite_top = server
                .comment("Highest y-value high concentration ancient debris can spawn at [default = 22]")
                .defineInRange("oregen.netherite_top", 22, 0, 255);

        low_netherite_count = server
                .comment("Maximum number of ancient debris per low concentration vein (high y-values) [default = 2]")
                .defineInRange("oregen.low_netherite_count", 2, 1, 100);

        low_netherite_bottom = server
                .comment("Lowest y-value low concentration ancient debris can spawn at [default = 8]")
                .defineInRange("oregen.low_netherite_bottom", 8, 0, 255);

        low_netherite_top = server
                .comment("Highest y-value low concentration ancient debris can spawn at [default = 119]")
                .defineInRange("oregen.low_netherite_top", 119, 0, 255);

        generate_netherite = server
                .comment("Decide if you want ancient debris to generate [default = true]")
                .define("oregen.generate_netherite", true);

        //ender diamond gen config
        end_diamond_count = server
                .comment("Maximum number of end diamond ore in a vein [default = 9]")
                .defineInRange("oregen.end_diamond_count", 9, 1, 100);

        end_diamond_chance = server
                .comment("Maximum number of end diamond ore veins that can spawn in one chunk [default = 5]")
                .defineInRange("oregen.end_diamond_chance", 5, 1, 100);

        end_diamond_bottom = server
                .comment("Lowest y-value end diamond ore can spawn at [default = 10]")
                .defineInRange("oregen.end_diamond_bottom", 10, 0, 255);

        end_diamond_top = server
                .comment("Highest y-value end diamond ore can spawn at [default = 117]")
                .defineInRange("oregen.end_diamond_top", 117, 0, 255);

        generate_end_diamond = server
                .comment("Decide if you want end diamond ore to generate [default = true]")
                .define("oregen.generate_end_diamond", true);

        //nether gold gen config
        nether_gold_count = server
                .comment("Maximum number of nether gold ore in a vein [default = 10]")
                .defineInRange("oregen.nether_gold_count", 10, 1, 100);

        nether_gold_chance = server
                .comment("Maximum number of nether gold ore veins that can spawn in one chunk [default = 10]")
                .defineInRange("oregen.nether_gold_chance", 10, 1, 100);

        nether_gold_bottom = server
                .comment("Lowest y-value nether gold ore can spawn at [default = 10]")
                .defineInRange("oregen.nether_gold_bottom", 10, 0, 255);

        nether_gold_top = server
                .comment("Highest y-value nether gold ore can spawn at [default = 117]")
                .defineInRange("oregen.nether_gold_top", 117, 0, 255);

        generate_nether_gold = server
                .comment("Decide if you want nether gold ore to generate [default = true]")
                .define("oregen.generate_nether_gold", true);

        //basalt gen config
        basalt_count = server
                .comment("Maximum number of basalt in a vein [default = 32]")
                .defineInRange("oregen.basalt_count", 32, 1, 100);

        basalt_chance = server
                .comment("Maximum number of basalt veins that can spawn in one chunk [default = 8]")
                .defineInRange("oregen.basalt_chance", 8, 1, 100);

        basalt_bottom = server
                .comment("Lowest y-value basalt can spawn at [default = 4]")
                .defineInRange("oregen.basalt_bottom", 4, 0, 255);

        basalt_top = server
                .comment("Highest y-value basalt can spawn at [default = 50]")
                .defineInRange("oregen.basalt_top", 50, 0, 255);

        generate_basalt = server
                .comment("Decide if you want basalt to generate [default = true]")
                .define("oregen.generate_basalt", true);

        //complite gen config
        complite_count = server
                .comment("Maximum number of complite in a vein [default = 24]")
                .defineInRange("oregen.complite_count", 24, 1, 100);

        complite_chance = server
                .comment("Maximum number of complite veins that can spawn in one chunk [default = 8]")
                .defineInRange("oregen.complite_chance", 8, 1, 100);

        complite_bottom = server
                .comment("Lowest y-value complite can spawn at [default = 0]")
                .defineInRange("oregen.complite_bottom", 0, 0, 255);

        complite_top = server
                .comment("Highest y-value complite can spawn at [default = 32]")
                .defineInRange("oregen.complite_top", 32, 0, 255);

        generate_complite = server
                .comment("Decide if you want complite to generate [default = true]")
                .define("oregen.generate_complite", true);
    }
}
