package com.portingdeadmods.researchdxcompat;

import com.portingdeadmods.researchdxcompat.data.ResearchdXCompatAttachments;
import com.portingdeadmods.researchdxcompat.registries.ResearchEffectSerializers;
import com.portingdeadmods.researchdxcompat.registries.ResearchMethodSerializers;
import com.portingdeadmods.researchdxcompat.registries.ResearchSerializers;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.ModList;
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
    public static final String MODID = "researchdxcompat";
    public static final String MODNAME = "Researchd XCompat";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ResearchdXCompat(IEventBus modEventBus, ModContainer modContainer) {
        ResearchEffectSerializers.SERIALIZERS.register(modEventBus);
        ResearchMethodSerializers.SERIALIZERS.register(modEventBus);
        ResearchSerializers.SERIALIZERS.register(modEventBus);
        ResearchdXCompatAttachments.ATTACHMENTS.register(modEventBus);

        modEventBus.addListener(this::registerPayloads);

        modContainer.registerConfig(ModConfig.Type.COMMON, ResearchdXCompatConfig.SPEC);
    }

    private void registerPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(MODID);
    }

    public static ResourceLocation rl(String path) {
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }

    public static boolean isIELoaded() {
        return ModList.get().isLoaded("immersiveengineering");
    }
}
