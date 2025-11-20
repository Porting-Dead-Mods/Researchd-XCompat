package com.portingdeadmods.researchdxcompat;

import com.portingdeadmods.portingdeadlibs.api.blockentities.ContainerBlockEntity;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;

@Mod(ResearchdXCompat.MODID)
public final class ResearchdXCompat {
    public static final String MODID = "examplemod";
    public static final String MODNAME = "Example Mod";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ResearchdXCompat(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::registerPayloads);

        modContainer.registerConfig(ModConfig.Type.COMMON, ResearchdXCompatConfig.SPEC);
    }

    private void registerPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(MODID);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
}
