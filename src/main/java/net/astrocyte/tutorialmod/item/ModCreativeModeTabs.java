package net.astrocyte.tutorialmod.item;

import net.astrocyte.tutorialmod.TutorialMod;
import net.astrocyte.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TOPAZ_ITEMS_TAB = CREATIVE_MODE_TABS.register("topaz_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TOPAZ.get()))
                    .title(Component.translatable("creativetab.tutorialmod.topaz_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TOPAZ.get());
                        output.accept(ModItems.UNREFINED_TOPAZ.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> TOPAZ_BLOCKS_TAB = CREATIVE_MODE_TABS.register("topaz_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TOPAZ_BLOCK.get()))
                    .withTabsBefore(TOPAZ_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.tutorialmod.topaz_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TOPAZ_BLOCK.get());
                        output.accept(ModBlocks.RAW_TOPAZ_BLOCK.get());

                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
