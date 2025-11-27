package com.portingdeadmods.researchdxcompat.data;

import com.portingdeadmods.researchd.Researchd;
import com.portingdeadmods.researchdxcompat.compat.immersiveengineering.UnlockIEMultiblockEffectData;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.UUID;
import java.util.function.Supplier;

public final class ResearchdXCompatAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Researchd.MODID);

    public static final Supplier<AttachmentType<UnlockIEMultiblockEffectData>> IE_MULTIBLOCK_PREDICATE = ATTACHMENTS.register("ie_multiblock_predicate",
            () -> AttachmentType.builder(() -> UnlockIEMultiblockEffectData.EMPTY)
                    .serialize(UnlockIEMultiblockEffectData.CODEC)
                    .sync(UnlockIEMultiblockEffectData.STREAM_CODEC)
                    .build());
}
