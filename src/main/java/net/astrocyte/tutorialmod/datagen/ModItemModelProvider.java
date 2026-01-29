package net.astrocyte.tutorialmod.datagen;

import net.astrocyte.tutorialmod.TutorialMod;
import net.astrocyte.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TOPAZ.get());
        basicItem(ModItems.UNREFINED_TOPAZ.get());
        basicItem(ModItems.PULSAR_QUARTZ.get());

        basicItem(ModItems.CHISEL.get());
        basicItem(ModItems.GLIZZY.get());
        basicItem(ModItems.TOPAZ_SWORD.get());
    }
}