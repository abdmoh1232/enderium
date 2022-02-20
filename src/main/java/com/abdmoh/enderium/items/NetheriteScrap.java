package com.abdmoh.enderium.items;

import com.abdmoh.enderium.Enderium;
import net.minecraft.item.Item;

public class NetheriteScrap extends Item {
    public NetheriteScrap() {
        super(new Item.Properties()
                .group(Enderium.setup.itemGroup));
        setRegistryName("netherite_scrap");
    }
}
