package net.faelynjpg.tutorialmod.datagen;

import net.faelynjpg.tutorialmod.TutorialMod;
import net.minecraft.client.renderer.texture.atlas.sources.PalettedPermutations;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.SpriteSourceProvider;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModAtlasesProvider extends SpriteSourceProvider {
    protected static final ResourceLocation ARMOR_TRIMS = ResourceLocation.withDefaultNamespace("armor_trims");
    public ModAtlasesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TutorialMod.MOD_ID);
    }

    public final Map<String, ResourceLocation> permutations = Map.of(
            "bismuth", ResourceLocation.fromNamespaceAndPath("tutorialmod", "trims/color_palettes/bismuth")
    );


    public final List<ResourceLocation> textures = List.of(
            ResourceLocation.withDefaultNamespace("trims/items/leggings_trim"),
            ResourceLocation.withDefaultNamespace("trims/items/chestplate_trim"),
            ResourceLocation.withDefaultNamespace("trims/items/helmet_trim"),
            ResourceLocation.withDefaultNamespace("trims/items/boots_trim")
    );

    public final List<ResourceLocation> trimTextures = List.of(
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/coast"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/coast"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/sentry"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/sentry"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/dune"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/dune"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/wild"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/wild"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/ward"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/ward"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/eye"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/eye"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/vex"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/vex"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/tide"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/tide"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/snout"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/snout"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/rib"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/rib"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/spire"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/spire"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/wayfinder"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/wayfinder"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/shaper"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/shaper"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/silence"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/silence"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/raiser"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/raiser"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/host"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/host"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/flow"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/flow"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/bolt"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/bolt"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid/kaupen"),
            ResourceLocation.withDefaultNamespace("trims/entity/humanoid_leggings/kaupen")
    );

    @Override
    protected void gather() {
        atlas(SpriteSourceProvider.BLOCKS_ATLAS).addSource(new PalettedPermutations(
                textures,
                ResourceLocation.withDefaultNamespace("trims/color_palettes/trim_palette"),
                permutations
        ));
        atlas(ARMOR_TRIMS).addSource(new PalettedPermutations(
                trimTextures,
                ResourceLocation.withDefaultNamespace("trims/color_palettes/trim_palette"),
                permutations
        ));
    }
}
