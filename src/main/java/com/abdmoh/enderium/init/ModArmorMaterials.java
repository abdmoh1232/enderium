package com.abdmoh.enderium.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ModArmorMaterials implements IArmorMaterial {
    enderium (
            "enderium",
            400,
            new int[] {3, 6, 8, 3},
            19,
            ModItems.ENDERIUM_CRYSTAL,
            "item.armor.equip_diamond",
            4.0F
    ),
    netherite (
            "netherite",
            300,
            new int[] {3, 6, 8, 3},
            16,
            ModItems.NETHERITE_INGOT,
            "item.armor.equip_diamond",
            3.0F
    );

    private static final int[] maxDamageArray = new int[]{13, 15, 16, 11};
    private String name, equipSound;
    private int durability, enchantability;
    private int[] damageReductionAmount;
    private float toughness;
    private Item repairItem;

    private ModArmorMaterials(String name,
                                   int durability,
                                   int[] damageReductionAmount,
                                   int enchantability,
                                   Item repairItem,
                                   String equipSound,
                                   float toughness) {
    this.name = name;
    this.durability = durability;
    this.damageReductionAmount = damageReductionAmount;
    this.enchantability = enchantability;
    this.repairItem = repairItem;
    this.equipSound = equipSound;
    this.toughness = toughness;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return maxDamageArray[slotIn.getIndex()] * this.durability;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmount[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairItem);
    }

    @Override
    public String getName() {
        return "enderium:" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
