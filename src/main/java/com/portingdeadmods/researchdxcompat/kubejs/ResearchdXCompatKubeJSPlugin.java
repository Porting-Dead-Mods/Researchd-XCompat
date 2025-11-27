package com.portingdeadmods.researchdxcompat.kubejs;

import com.portingdeadmods.researchdxcompat.ResearchdXCompat;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.BindingRegistry;

public final class ResearchdXCompatKubeJSPlugin implements KubeJSPlugin {
    @Override
    public void registerBindings(BindingRegistry bindings) {
        if (ResearchdXCompat.isIELoaded())
            bindings.add("ResearchdImmersiveEngineering", ResearchdImmersiveEngineering.class);
    }
}