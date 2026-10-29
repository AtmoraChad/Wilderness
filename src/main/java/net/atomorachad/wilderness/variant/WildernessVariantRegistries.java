
package net.atomorachad.wilderness.variant;

import net.fabricmc.fabric.api.event.registry.DynamicRegistries;

public final class WildernessVariantRegistries {

    private WildernessVariantRegistries() {}

    public static void initialize() {
        DynamicRegistries.registerSynced(FoxVariant.REGISTRY_KEY, FoxVariant.DIRECT_CODEC
        );
    }
}
