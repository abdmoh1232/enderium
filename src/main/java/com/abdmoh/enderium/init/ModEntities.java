package com.abdmoh.enderium.init;

import com.abdmoh.enderium.Enderium;
import com.abdmoh.enderium.config.MobSpawnConfig;
import com.abdmoh.enderium.entities.EnderSentry;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;

import java.util.Random;

public class ModEntities {
    //declares entity type
    public static EntityType<EnderSentry> ENDER_SENTRY = EntityType.Builder.create(EnderSentry::new, EntityClassification.MONSTER).size(0.6F, 1.8F).build("enderium:ender_sentry");

    //registers all entity world spawns
    public static void registerWorldSpawns() {
        if (MobSpawnConfig.ender_sentry_spawn.get()) {
            registerWorldSpawn(ENDER_SENTRY, MobSpawnConfig.ender_sentry_weight.get(), MobSpawnConfig.ender_sentry_min.get(), MobSpawnConfig.ender_sentry_max.get(),
                    Biomes.SMALL_END_ISLANDS, Biomes.END_BARRENS, Biomes.END_MIDLANDS, Biomes.END_HIGHLANDS);
        }
    }

    //code for registering each entity world spawn
    public static void registerWorldSpawn(EntityType<?> entity, int weight, int minGroupCount, int maxGroupCount, Biome...biomes) {
        for (Biome biome: biomes) {
            if (biome != null) {
                biome.getSpawns(entity.getClassification()).add(
                        new Biome.SpawnListEntry(entity, weight, minGroupCount, maxGroupCount)
                );
            }
        }
    }

    public static boolean endIslandCondition(EntityType<? extends CreatureEntity> entityType, IWorld world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return pos.getY() >= 40;
    }
}
