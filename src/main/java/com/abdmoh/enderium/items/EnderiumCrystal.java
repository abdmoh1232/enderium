package com.abdmoh.enderium.items;

import com.abdmoh.enderium.Enderium;
import net.minecraft.item.Item;

public class EnderiumCrystal extends Item {
    public EnderiumCrystal() {
        super(new Item.Properties()
                .group(Enderium.setup.itemGroup));
        setRegistryName("enderium_crystal");
    }
}
