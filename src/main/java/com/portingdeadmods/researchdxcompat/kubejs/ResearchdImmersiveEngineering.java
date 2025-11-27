package com.portingdeadmods.researchdxcompat.kubejs;

import com.portingdeadmods.researchd.api.research.effects.ResearchEffect;
import com.portingdeadmods.researchdxcompat.compat.immersiveengineering.UnlockIEMultiblockEffect;
import net.minecraft.resources.ResourceLocation;

public class ResearchdImmersiveEngineering {
    public static ResearchEffect unlockMultiblock(String multiblock) {
        return new UnlockIEMultiblockEffect(ResourceLocation.parse(multiblock));
    }
}
