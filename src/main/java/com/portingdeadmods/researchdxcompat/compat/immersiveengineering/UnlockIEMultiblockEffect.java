package com.portingdeadmods.researchdxcompat.compat.immersiveengineering;

import blusunrize.immersiveengineering.common.register.IEBlocks;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.portingdeadmods.researchd.api.research.Research;
import com.portingdeadmods.researchd.api.research.effects.ResearchEffect;
import com.portingdeadmods.researchd.api.research.serializers.ResearchEffectSerializer;
import com.portingdeadmods.researchdxcompat.ResearchdXCompat;
import com.portingdeadmods.researchdxcompat.data.ResearchdXCompatAttachments;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Optional;

public record UnlockIEMultiblockEffect(Optional<ItemStack> icon, Optional<String> name, ResourceLocation multiblock) implements ResearchEffect {
    private static final MapCodec<UnlockIEMultiblockEffect> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            ItemStack.CODEC.optionalFieldOf("icon").forGetter(UnlockIEMultiblockEffect::icon),
            Codec.STRING.optionalFieldOf("name").forGetter(UnlockIEMultiblockEffect::name),
            ResourceLocation.CODEC.fieldOf("multiblock").forGetter(UnlockIEMultiblockEffect::multiblock)
    ).apply(instance, UnlockIEMultiblockEffect::new));

    private static final StreamCodec<RegistryFriendlyByteBuf, UnlockIEMultiblockEffect> STREAM_CODEC = StreamCodec.composite(
            ByteBufCodecs.optional(ItemStack.STREAM_CODEC),
            UnlockIEMultiblockEffect::icon,
            ByteBufCodecs.optional(ByteBufCodecs.STRING_UTF8),
            UnlockIEMultiblockEffect::name,
            ResourceLocation.STREAM_CODEC,
            UnlockIEMultiblockEffect::multiblock,
            UnlockIEMultiblockEffect::new
    );

    public static final ResearchEffectSerializer<UnlockIEMultiblockEffect> SERIALIZER = ResearchEffectSerializer.simple(CODEC, STREAM_CODEC);
    public static final ResourceLocation ID = ResearchdXCompat.rl("unlock_ie_multiblock");

    public UnlockIEMultiblockEffect(ItemStack icon, String name, ResourceLocation multiblock) {
        this(Optional.ofNullable(icon), Optional.ofNullable(name), multiblock);
    }

    public UnlockIEMultiblockEffect(ResourceLocation multiblock) {
        this(Optional.empty(), Optional.empty(), multiblock);
    }

    @Override
    public void onUnlock(Level level, Player player, ResourceKey<Research> research) {
        UnlockIEMultiblockEffectData data = player.getData(ResearchdXCompatAttachments.IE_MULTIBLOCK_PREDICATE.get());
        player.setData(ResearchdXCompatAttachments.IE_MULTIBLOCK_PREDICATE.get(), data.remove(this, level));
    }

    @Override
    public ResourceLocation id() {
        return ID;
    }

    public ItemStack getDisplayStack() {
        return this.icon().map(ItemStack::copy)
                .orElseGet(() -> new ItemStack(IEBlocks.MetalDecoration.ENGINEERING_LIGHT.asItem()));
    }

    @Override
    public ResearchEffectSerializer<UnlockIEMultiblockEffect> getSerializer() {
        return SERIALIZER;
    }
}
