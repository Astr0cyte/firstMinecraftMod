package net.astrocyte.tutorialmod.item;

import net.astrocyte.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
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
    public static final RegistryObject<Item> UNREFINED_TOPAZ = ITEMS.register("unrefinedtopaz",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
