package dev.d4niz.decorativeblocks.core;

import dev.d4niz.decorativeblocks.DecorativeBlocks;
import dev.d4niz.decorativeblocks.block.ModBlocks;
import dev.d4niz.decorativeblocks.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = DecorativeBlocks.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlocksTab {
    public static CreativeModeTab DECORATIVEBLOCKS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        DECORATIVEBLOCKS = event.registerCreativeModeTab(new ResourceLocation(DecorativeBlocks.MODID, "decorativeblocks_tab"), builder -> builder.icon(() -> new ItemStack(ModBlocks.PAPER_BLOCK.get())).title(Component.translatable("itemGroup.decorativeblocks_tab")));
    }

    public static void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == DECORATIVEBLOCKS) {
            for (RegistryObject<Item> itemRegistryObject : ModItems.ITEMS.getEntries()) {
                event.accept(itemRegistryObject.get());
            }
            for (RegistryObject<Block> blockRegistryObject : ModBlocks.BLOCKS.getEntries()) {
                event.accept(blockRegistryObject.get());
            }
        }
    }
}
