package com.portingdeadmods.researchdxcompat.compat.immersiveengineering;

import com.mojang.serialization.Codec;
import com.portingdeadmods.portingdeadlibs.utils.UniqueArray;
import com.portingdeadmods.researchd.api.research.effects.ResearchEffectData;
import com.portingdeadmods.researchd.utils.researches.ResearchHelperCommon;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.Collection;

public record UnlockIEMultiblockEffectData(UniqueArray<ResourceLocation> blockedMultiblocks) implements ResearchEffectData<UnlockIEMultiblockEffect> {
    public static final UnlockIEMultiblockEffectData EMPTY = new UnlockIEMultiblockEffectData(new UniqueArray<>());

    public static final Codec<UnlockIEMultiblockEffectData> CODEC = UniqueArray.CODEC(ResourceLocation.CODEC)
            .xmap(UnlockIEMultiblockEffectData::new, UnlockIEMultiblockEffectData::blockedMultiblocks);

    public static final StreamCodec<ByteBuf, UnlockIEMultiblockEffectData> STREAM_CODEC = StreamCodec.composite(
            UniqueArray.STREAM_CODEC(ResourceLocation.STREAM_CODEC),
            UnlockIEMultiblockEffectData::blockedMultiblocks,
            UnlockIEMultiblockEffectData::new
    );

    @Override
    public UnlockIEMultiblockEffectData add(UnlockIEMultiblockEffect effect, Level level) {
        UniqueArray<ResourceLocation> multiblocks = new UniqueArray<>(this.blockedMultiblocks());
        multiblocks.add(effect.multiblock());
        return new UnlockIEMultiblockEffectData(multiblocks);
    }

    @Override
    public UnlockIEMultiblockEffectData remove(UnlockIEMultiblockEffect effect, Level level) {
        UniqueArray<ResourceLocation> multiblocks = new UniqueArray<>(this.blockedMultiblocks());
        multiblocks.remove(effect.multiblock());
        return new UnlockIEMultiblockEffectData(multiblocks);
    }

    public boolean isBlocked(ResourceLocation multiblock) {
        return this.blockedMultiblocks.contains(multiblock);
    }

    @Override
    public UnlockIEMultiblockEffectData getDefault(Level level) {
        Collection<UnlockIEMultiblockEffect> unlockEffects = ResearchHelperCommon.getResearchEffects(UnlockIEMultiblockEffect.class, level);
        UniqueArray<ResourceLocation> blockedMultiblocks = new UniqueArray<>();

        for (UnlockIEMultiblockEffect effect : unlockEffects) {
            blockedMultiblocks.add(effect.multiblock());
        }

        return new UnlockIEMultiblockEffectData(blockedMultiblocks);
    }

    @Override
    public UniqueArray<ResourceLocation> getAll() {
        return this.blockedMultiblocks();
    }
}
