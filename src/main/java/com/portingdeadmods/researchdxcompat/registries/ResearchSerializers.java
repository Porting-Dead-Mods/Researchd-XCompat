package com.portingdeadmods.researchdxcompat.registries;

import com.portingdeadmods.researchd.ResearchdRegistries;
import com.portingdeadmods.researchd.api.research.serializers.ResearchSerializer;
import com.portingdeadmods.researchdxcompat.ResearchdXCompat;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ResearchSerializers {
	public static final DeferredRegister<ResearchSerializer<?>> SERIALIZERS = DeferredRegister.create(ResearchdRegistries.RESEARCH_SERIALIZER, ResearchdXCompat.MODID);

	static {
	}
}
