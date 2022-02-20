package com.abdmoh.enderium.items;

import com.abdmoh.enderium.Enderium;
import net.minecraft.item.Item;

public class MysticalDust extends Item {
    public MysticalDust() {
        super(new Item.Properties()
                .group(Enderium.setup.itemGroup));
        setRegistryName("mystical_dust");
    }
}
