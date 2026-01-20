package net.astrocyte.tutorialmod.item;

import net.astrocyte.tutorialmod.TutorialMod;
import net.astrocyte.tutorialmod.item.custom.ChiselItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {

    // Creating a new instance of Deferred Register.
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    // Lambda function to create custom item.
    // '.register' is akin to 'list.add()' for an ArrayList.
    // Here, we are adding the recipe for topaz to the 'ITEMS' DeferredRegister.
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",
            () -> new Item(new Item.Properties()));
        // Right now, topaz does not actually have an in game name or textures.
        // This stuff is done via: resources > assets

    //Adding a second item from my own memory.
    public static final RegistryObject<Item> UNREFINED_TOPAZ = ITEMS.register("unrefined_topaz",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<SwordItem> TOPAZ_SWORD = ITEMS.register("topaz_sword",
            () -> new SwordItem(
                    ModTiers.TOPAZ,
                    new Item.Properties().attributes(SwordItem.createAttributes(ModTiers.TOPAZ, 3, -2.4f))));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(40)));

    public static final RegistryObject<Item> GLIZZY = ITEMS.register("glizzy",
            () -> new Item(new Item.Properties().food(ModFoodProperties.GLIZZY)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.glizzy")
                            .withStyle(ChatFormatting.DARK_RED)
                            .withStyle(ChatFormatting.ITALIC));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
