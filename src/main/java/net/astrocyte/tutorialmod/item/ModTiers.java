package net.astrocyte.tutorialmod.item;

import net.astrocyte.tutorialmod.item.ModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class ModTiers {
    // We create the Tier manually by implementing the interface
    public static final Tier TOPAZ = new Tier() {
        @Override
        public int getUses() {
            return 1500; // Durability (Iron is ~250, Diamond is 1561)
        }

        @Override
        public float getSpeed() {
            return 11.0F; // Mining speed (Diamond is 8.0f)
        }

        @Override
        public float getAttackDamageBonus() {
            return 3.5F; // Damage bonus
        }

        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            // This replaces "Mining Level".
            // INCORRECT_FOR_IRON_TOOL means it can mine everything Iron can.
            // If you want it to mine Obsidian, change this to INCORRECT_FOR_DIAMOND_TOOL
            return BlockTags.INCORRECT_FOR_DIAMOND_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 22; // Higher number = better enchantments
        }

        @Override
        public Ingredient getRepairIngredient() {
            // This defines what item repairs it in an anvil
            return Ingredient.of(ModItems.TOPAZ.get());
        }
    };
}