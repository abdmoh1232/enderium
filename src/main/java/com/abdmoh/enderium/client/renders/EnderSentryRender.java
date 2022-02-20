package com.abdmoh.enderium.client.renders;

import com.abdmoh.enderium.client.models.EnderSentryModel;
import com.abdmoh.enderium.entities.EnderSentry;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class EnderSentryRender extends MobRenderer<EnderSentry, EnderSentryModel> {
    public EnderSentryRender(EntityRendererManager manager) {
        super(manager, new EnderSentryModel(), 0.5F);
    }

    @Override
    protected boolean canRenderName(EnderSentry entity) {
        return false;
    }

    @Override
    public ResourceLocation getEntityTexture(EnderSentry entity) {
        return new ResourceLocation("enderium", "textures/entity/x_mob.png");
    }

    public static class RenderFactory implements IRenderFactory<EnderSentry> {

        @Override
        public EntityRenderer<? super EnderSentry> createRenderFor(EntityRendererManager manager) {
            return new EnderSentryRender(manager);
        }
    }
}
