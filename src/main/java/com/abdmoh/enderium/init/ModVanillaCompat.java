package com.abdmoh.enderium.init;

import com.abdmoh.enderium.Enderium;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.item.AxeItem;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class ModVanillaCompat {
    public static void init() {
        //makes blocks strippable
        registerStrippableBlocks(ModBlocks.ENCHANTED_LOG, ModBlocks.STRIPPED_ENCHANTED_LOG);
        registerStrippableBlocks(ModBlocks.ENCHANTED_WOOD, ModBlocks.STRIPPED_ENCHANTED_WOOD);

        //makes blocks flammable
        registerFlammableBlocks(ModBlocks.MYSTIC_GRASS, 60, 100);
        registerFlammableBlocks(ModBlocks.ENCHANTED_PLANKS, 5, 20);
        registerFlammableBlocks(ModBlocks.ENCHANTED_LOG, 5, 5);
        registerFlammableBlocks(ModBlocks.ENCHANTED_WOOD, 5, 5);
        registerFlammableBlocks(ModBlocks.STRIPPED_ENCHANTED_LOG, 5, 5);
        registerFlammableBlocks(ModBlocks.STRIPPED_ENCHANTED_WOOD, 5, 5);

        //makes blocks compostable
        registerCompostableBlocks(0.3F, ModBlocks.ENCHANTED_SAPLING);
        registerCompostableBlocks(0.3F, ModBlocks.MYSTIC_GRASS);

        Enderium.LOGGER.info("VanillaCompat init method registered");
    }
    //registers custom logs as strippable
    public static void registerStrippableBlocks(Block log, Block strippedLog) {
        try {
            //gets the BLOCK_STRIPPING_MAP to use in reflection
            Field field = ObfuscationReflectionHelper.findField(AxeItem.class, "field_203176_a");

            //removes the immutable map's final modifier
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            //copies contents of the immutable map to a temporary mutable one
            Map<Block, Block> tempMap = new HashMap<>((Map<Block, Block>) field.get(null));

            //adds my custom logs to the map
            tempMap.put(log, strippedLog);
            field.set(null, tempMap);
        }
        catch (IllegalAccessException e) {
            Enderium.LOGGER.info("Illegal access");
        }
        catch (NoSuchFieldException e) {
            Enderium.LOGGER.info("No such field");
        }
        catch (Exception e) {
            Enderium.LOGGER.info("Other exception");
        }
    }

    //registers custom blocks as flammable
    public static void registerFlammableBlocks(Block block, int encouragement, int flammability) {
        FireBlock fireBlock = (FireBlock) Blocks.FIRE;
        fireBlock.setFireInfo(block, encouragement, flammability);
    }

    //registers custom items as compostable
    public static void registerCompostableBlocks(float chance, IItemProvider item) {
        ComposterBlock.CHANCES.put(item.asItem(), chance);
    }
}
