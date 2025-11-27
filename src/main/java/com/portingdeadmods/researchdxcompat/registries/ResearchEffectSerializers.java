package com.portingdeadmods.researchdxcompat.registries;

import com.portingdeadmods.researchd.ResearchdRegistries;
import com.portingdeadmods.researchd.api.research.serializers.ResearchEffectSerializer;
import com.portingdeadmods.researchdxcompat.ResearchdXCompat;
import com.portingdeadmods.researchdxcompat.compat.immersiveengineering.UnlockIEMultiblockEffect;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ResearchEffectSerializers {
	public static final DeferredRegister<ResearchEffectSerializer<?>> SERIALIZERS = DeferredRegister.create(ResearchdRegistries.RESEARCH_EFFECT_SERIALIZER_KEY, ResearchdXCompat.MODID);

	static {
		if (ResearchdXCompat.isIELoaded())
			SERIALIZERS.register("unlock_ie_multiblock", () -> UnlockIEMultiblockEffect.SERIALIZER);
	}
}
