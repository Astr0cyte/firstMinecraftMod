package net.astrocyte.tutorialmod.datagen;

import net.astrocyte.tutorialmod.block.ModBlocks;
import net.astrocyte.tutorialmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate(){
        dropSelf(ModBlocks.TOPAZ_BLOCK.get());
        dropSelf(ModBlocks.RAW_TOPAZ_BLOCK.get());

        dropSelf(ModBlocks.TRANSMOGRIFIER_BLOCK.get());
        dropSelf(ModBlocks.RADIANT_TOPAZ_BLOCK.get());
        dropSelf(ModBlocks.PULSAR_QUARTZ_BLOCK.get());

        dropSelf(ModBlocks.TOPAZ_STAIRS.get());
        this.add(ModBlocks.TOPAZ_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.TOPAZ_SLAB.get()));

        dropSelf(ModBlocks.TOPAZ_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.TOPAZ_BUTTON.get());

        dropSelf(ModBlocks.TOPAZ_FENCE.get());
        dropSelf(ModBlocks.TOPAZ_FENCE_GATE.get());
        dropSelf(ModBlocks.TOPAZ_WALL.get());

        dropSelf(ModBlocks.TOPAZ_TRAPDOOR.get());
        this.add(ModBlocks.TOPAZ_DOOR.get(),
                block -> createDoorTable(ModBlocks.TOPAZ_DOOR.get()));

        this.add(ModBlocks.TOPAZ_ORE_BLOCK.get(),
                block -> createOreDrop(ModBlocks.TOPAZ_ORE_BLOCK.get(), ModItems.UNREFINED_TOPAZ.get()));
        this.add(ModBlocks.DEEPSLATE_TOPAZ_ORE_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_TOPAZ_ORE_BLOCK.get(), ModItems.UNREFINED_TOPAZ.get(), 1, 3));

    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                                .apply(LimitCount.limitCount(IntRange.upperBound(4)))
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }


}
