package net.astrocyte.tutorialmod.datagen;

import net.astrocyte.tutorialmod.TutorialMod;
import net.astrocyte.tutorialmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TOPAZ_BLOCK.get())
                .add(ModBlocks.RAW_TOPAZ_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE_BLOCK.get())
                .add(ModBlocks.TOPAZ_ORE_BLOCK.get())
                .add(ModBlocks.TRANSMOGRIFIER_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.TRANSMOGRIFIER_BLOCK.get())
                .add(ModBlocks.RADIANT_TOPAZ_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TOPAZ_ORE_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE_BLOCK.get())
                .add(ModBlocks.RAW_TOPAZ_BLOCK.get());
    }
}
