package com.portingdeadmods.researchdxcompat;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = ResearchdXCompat.MODID, dist = Dist.CLIENT)
public final class ResearchdXCompatClient {
    public ResearchdXCompatClient(IEventBus modEventBus, ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, ResearchdXCompatClientConfig.SPEC);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
