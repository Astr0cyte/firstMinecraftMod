package net.astrocyte.tutorialmod.datagen;

import net.astrocyte.tutorialmod.TutorialMod;
import net.astrocyte.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        blockWithItem(ModBlocks.PULSAR_QUARTZ_BLOCK);

        stairsBlock(ModBlocks.TOPAZ_STAIRS.get(), blockTexture(ModBlocks.TOPAZ_BLOCK.get()));
        slabBlock(ModBlocks.TOPAZ_SLAB.get(), blockTexture(ModBlocks.TOPAZ_BLOCK.get()), blockTexture(ModBlocks.TOPAZ_BLOCK.get()));

        buttonBlock(ModBlocks.TOPAZ_BUTTON.get(), blockTexture(ModBlocks.TOPAZ_BLOCK.get()));
        pressurePlateBlock(ModBlocks.TOPAZ_PRESSURE_PLATE.get(), blockTexture(ModBlocks.TOPAZ_BLOCK.get()));

        fenceBlock(ModBlocks.TOPAZ_FENCE.get(), blockTexture(ModBlocks.TOPAZ_BLOCK.get()));
        fenceGateBlock(ModBlocks.TOPAZ_FENCE_GATE.get(), blockTexture(ModBlocks.TOPAZ_BLOCK.get()));
        wallBlock(ModBlocks.TOPAZ_WALL.get(), blockTexture(ModBlocks.TOPAZ_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.TOPAZ_DOOR.get(), modLoc("block/topaz_door_bottom"), modLoc("block/topaz_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.TOPAZ_TRAPDOOR.get(), modLoc("block/topaz_trapdoor"), true, "cutout");

        blockItem(ModBlocks.TOPAZ_STAIRS);
        blockItem(ModBlocks.TOPAZ_SLAB);
        blockItem(ModBlocks.TOPAZ_PRESSURE_PLATE);
        blockItem(ModBlocks.TOPAZ_FENCE_GATE);
        blockItem(ModBlocks.TOPAZ_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("tutorialmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}
