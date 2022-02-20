package com.abdmoh.enderium.client.renders;

import com.abdmoh.enderium.entities.EnderSentry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ModRenderRegistry {
    public static void registryEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EnderSentry.class, new EnderSentryRender.RenderFactory());
    }
}
