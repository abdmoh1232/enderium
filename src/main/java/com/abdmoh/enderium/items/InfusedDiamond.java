package com.abdmoh.enderium.items;

import com.abdmoh.enderium.Enderium;
import net.minecraft.item.Item;

public class InfusedDiamond extends Item {
    public InfusedDiamond() {
        super(new Item.Properties()
                .group(Enderium.setup.itemGroup));
        setRegistryName("infused_diamond");
    }
}
