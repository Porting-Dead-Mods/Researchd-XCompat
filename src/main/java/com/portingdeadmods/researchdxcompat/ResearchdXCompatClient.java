package com.portingdeadmods.researchdxcompat;

import com.portingdeadmods.researchd.ResearchdClient;
import com.portingdeadmods.researchd.api.research.effects.ResearchEffect;
import com.portingdeadmods.researchd.api.research.methods.ResearchMethod;
import com.portingdeadmods.researchd.utils.WidgetConstructor;
import com.portingdeadmods.researchdxcompat.compat.immersiveengineering.UnlockIEMultiblockEffect;
import com.portingdeadmods.researchdxcompat.compat.immersiveengineering.client.UnlockIEMultiblockEffectWidget;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = ResearchdXCompat.MODID, dist = Dist.CLIENT)
public final class ResearchdXCompatClient {
    public ResearchdXCompatClient(IEventBus modEventBus, ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, ResearchdXCompatClientConfig.SPEC);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);

        modEventBus.addListener(this::clientSetup);
    }

    private void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            addEffectWidget(UnlockIEMultiblockEffect.ID, UnlockIEMultiblockEffectWidget::new);
        });
    }

    private static <T extends ResearchMethod> void addMethodWidget(ResourceLocation id, WidgetConstructor<T> constructor) {
        ResearchdClient.RESEARCH_METHOD_WIDGETS.put(id, constructor);
    }

    private static <T extends ResearchEffect> void addEffectWidget(ResourceLocation id, WidgetConstructor<T> constructor) {
        ResearchdClient.RESEARCH_EFFECT_WIDGETS.put(id, constructor);
    }

}
