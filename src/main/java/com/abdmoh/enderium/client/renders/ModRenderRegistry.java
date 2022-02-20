package com.abdmoh.enderium.client.renders;

import com.abdmoh.enderium.entities.EnderSentry;
import com.abdmoh.enderium.init.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class ModRenderRegistry {
    public static void registryEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ENDER_SENTRY, new EnderSentryRender.RenderFactory());
    }
}
