package com.portingdeadmods.researchdxcompat.registries;

import com.portingdeadmods.researchd.ResearchdRegistries;
import com.portingdeadmods.researchd.api.research.serializers.ResearchMethodSerializer;
import com.portingdeadmods.researchdxcompat.ResearchdXCompat;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ResearchMethodSerializers {
    public static final DeferredRegister<ResearchMethodSerializer<?>> SERIALIZERS = DeferredRegister.create(ResearchdRegistries.RESEARCH_METHOD_SERIALIZER, ResearchdXCompat.MODID);

    static {

    }
}
