package dev.d4niz.decorativeblocks.block;

import dev.d4niz.decorativeblocks.DecorativeBlocks;
import dev.d4niz.decorativeblocks.block.custom.ConeBlock;
import dev.d4niz.decorativeblocks.block.custom.PaperBlock;
import dev.d4niz.decorativeblocks.block.custom.WoodPlates;
import dev.d4niz.decorativeblocks.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static  final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DecorativeBlocks.MODID);

    public static final RegistryObject<Block> PAPER_BLOCK = registerBlock("paper_block",
            () -> new PaperBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .instabreak().noCollission()));

    public static final RegistryObject<Block> WOOD_PLATES = registerBlock("wood_plates",
            () -> new WoodPlates(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CONE_BLOCK = registerBlock("cone_block",
            () -> new ConeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}