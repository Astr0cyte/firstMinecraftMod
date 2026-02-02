package net.astrocyte.tutorialmod.block;

import net.astrocyte.tutorialmod.TutorialMod;
import net.astrocyte.tutorialmod.block.custom.TransmogrifierBlock;
import net.astrocyte.tutorialmod.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {

    // Creating a new instance of Deferred Register.
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    // Actually registering blocks.
    public static final RegistryObject<Block> TOPAZ_BLOCK = registerBlock("topaz_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));

    public static final RegistryObject<Block> RAW_TOPAZ_BLOCK = registerBlock("raw_topaz_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));

    public static final RegistryObject<Block> TOPAZ_ORE_BLOCK = registerBlock("topaz_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> DEEPSLATE_TOPAZ_ORE_BLOCK = registerBlock("deepslate_topaz_ore_block",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> RADIANT_TOPAZ_BLOCK = registerBlock("radiant_topaz_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).sound(SoundType.SHROOMLIGHT)
                    .lightLevel(state -> 15)));

    public static final RegistryObject<Block> TRANSMOGRIFIER_BLOCK = registerBlock("transmogrifier_block",
            () -> new TransmogrifierBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()) {
                @Override
                public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.transmogrifier_block")
                            .withStyle(ChatFormatting.DARK_RED)
                            .withStyle(ChatFormatting.ITALIC));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Block> PULSAR_QUARTZ_BLOCK = registerBlock("pulsar_quartz_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    //STAIRS, SLABS
    public static final RegistryObject<StairBlock> TOPAZ_STAIRS = registerBlock("topaz_stairs",
            () -> new StairBlock(ModBlocks.TOPAZ_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> TOPAZ_SLAB = registerBlock("topaz_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    //PRESSURE PLATE, BUTTON
    public static final RegistryObject<PressurePlateBlock> TOPAZ_PRESSURE_PLATE = registerBlock("topaz_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> TOPAZ_BUTTON = registerBlock("topaz_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noCollission()));

    //FENCE, FENCE GATE, WALL
    public static final RegistryObject<FenceBlock> TOPAZ_FENCE = registerBlock("topaz_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> TOPAZ_FENCE_GATE = registerBlock("topaz_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> TOPAZ_WALL= registerBlock("topaz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    //DOOR, TRAPDOOR
    public static final RegistryObject<DoorBlock> TOPAZ_DOOR = registerBlock("topaz_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> TOPAZ_TRAPDOOR = registerBlock("topaz_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noOcclusion()));

    // Helper functions for registering blocks:

    /**
     *
     * @param name of the block
     * @param block the lambda function ("recipe") for creating the 'name' into a block object when accessed
     * @param <T> an extension of Block objects.
     * @return RegistryObject.
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    /**
     *
     * @param name of the block item
     * @param block the lambda function for creating the 'name' into a block item object when accessed.
     * @param <T> an extension of Block objects.
     */
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

}
