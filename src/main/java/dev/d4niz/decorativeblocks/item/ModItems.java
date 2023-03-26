package dev.d4niz.decorativeblocks.item;

import dev.d4niz.decorativeblocks.DecorativeBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static  final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DecorativeBlocks.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
