package net.astrocyte.tutorialmod.datagen;

import net.astrocyte.tutorialmod.TutorialMod;
import net.astrocyte.tutorialmod.block.ModBlocks;
import net.astrocyte.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput){
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TOPAZ_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.TOPAZ.get())
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get())).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TOPAZ_SWORD.get())
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .define('X', ModItems.TOPAZ.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get()))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RADIANT_TOPAZ_BLOCK.get())
                .pattern("###")
                .pattern("#X#")
                .pattern("###")
                .define('X', ModItems.TOPAZ.get())
                .define('#', Items.GLOWSTONE_DUST)
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get()))
                .unlockedBy(getHasName(Items.GLOWSTONE_DUST), has(Items.GLOWSTONE_DUST)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHISEL.get())
                .pattern(" ")
                .pattern("X")
                .pattern("#")
                .define('X', ModItems.TOPAZ.get())
                .define('#', Items.STICK)
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get()))
                .unlockedBy(getHasName(Items.STICK), has(Items.STICK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRANSMOGRIFIER_BLOCK.get())
                .pattern("#@#")
                .pattern("@X@")
                .pattern("#@#")
                .define('X', ModItems.TOPAZ.get())
                .define('@', Items.REDSTONE)
                .define('#', Blocks.OBSIDIAN)
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get()))
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .unlockedBy(getHasName(Blocks.OBSIDIAN), has(Blocks.OBSIDIAN))
                .save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PULSAR_QUARTZ_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.PULSAR_QUARTZ.get())
                .unlockedBy(getHasName(ModItems.PULSAR_QUARTZ.get()), has(ModItems.PULSAR_QUARTZ.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TOPAZ.get(), 9)
                .requires(ModBlocks.TOPAZ_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TOPAZ_BLOCK.get()), has(ModBlocks.TOPAZ_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PULSAR_QUARTZ.get(), 9)
                .requires(ModBlocks.PULSAR_QUARTZ_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.PULSAR_QUARTZ_BLOCK.get()), has(ModBlocks.PULSAR_QUARTZ_BLOCK.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TOPAZ.get(), 6)
                .requires(ModBlocks.RAW_TOPAZ_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_TOPAZ_BLOCK.get()), has(ModBlocks.RAW_TOPAZ_BLOCK.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":topaz_from_raw_topaz_block");

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModItems.UNREFINED_TOPAZ.get()), RecipeCategory.MISC, ModItems.TOPAZ.get(), 1)
                .unlockedBy(getHasName(ModItems.UNREFINED_TOPAZ.get()), has(ModItems.UNREFINED_TOPAZ.get()))
                .save(pRecipeOutput, TutorialMod.MOD_ID + ":topaz_from_stonecutting_unrefined_topaz");

        stairBuilder(ModBlocks.TOPAZ_STAIRS.get(), Ingredient.of(ModItems.TOPAZ.get())).group("topaz")
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOPAZ_SLAB.get(), ModItems.TOPAZ.get());

        buttonBuilder(ModBlocks.TOPAZ_BUTTON.get(), Ingredient.of(ModItems.TOPAZ.get())).group("topaz")
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.TOPAZ_PRESSURE_PLATE.get(), ModItems.TOPAZ.get());

        fenceBuilder(ModBlocks.TOPAZ_FENCE.get(), Ingredient.of(ModItems.TOPAZ.get())).group("topaz")
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.TOPAZ_FENCE_GATE.get(), Ingredient.of(ModItems.TOPAZ.get())).group("topaz")
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get())).save(pRecipeOutput);
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOPAZ_WALL.get(), ModItems.TOPAZ.get());

        doorBuilder(ModBlocks.TOPAZ_DOOR.get(), Ingredient.of(ModItems.TOPAZ.get())).group("topaz")
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.TOPAZ_TRAPDOOR.get(), Ingredient.of(ModItems.TOPAZ.get())).group("topaz")
                .unlockedBy(getHasName(ModItems.TOPAZ.get()), has(ModItems.TOPAZ.get())).save(pRecipeOutput);
    }
}
