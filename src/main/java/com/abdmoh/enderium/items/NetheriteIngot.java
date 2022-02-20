package com.abdmoh.enderium.items;

import com.abdmoh.enderium.Enderium;
import net.minecraft.item.Item;

public class NetheriteIngot extends Item {
    public NetheriteIngot() {
        super(new Item.Properties()
                .group(Enderium.setup.itemGroup));
        setRegistryName("netherite_ingot");
    }
}
