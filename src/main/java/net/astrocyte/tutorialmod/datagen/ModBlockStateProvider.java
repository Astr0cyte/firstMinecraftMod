package net.astrocyte.tutorialmod.datagen;

import net.astrocyte.tutorialmod.TutorialMod;
import net.astrocyte.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TOPAZ_BLOCK);
        blockWithItem(ModBlocks.RAW_TOPAZ_BLOCK);
        blockWithItem(ModBlocks.RADIANT_TOPAZ_BLOCK);

        blockWithItem(ModBlocks.TOPAZ_ORE_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_TOPAZ_ORE_BLOCK);

        blockWithItem(ModBlocks.TRANSMOGRIFIER_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
