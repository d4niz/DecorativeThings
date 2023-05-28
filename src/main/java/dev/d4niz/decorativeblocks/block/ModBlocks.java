package dev.d4niz.decorativeblocks.block;

import dev.d4niz.decorativeblocks.DecorativeBlocks;
import dev.d4niz.decorativeblocks.block.custom.*;
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
            () -> new PaperBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)
                    .instabreak().noCollission()));

    public static final RegistryObject<Block> WOOD_PLATES = registerBlock("wood_plates",
            () -> new WoodPlates(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> CONE_BLOCK = registerBlock("cone_block",
            () -> new ConeBlock(BlockBehaviour.Properties.copy(Blocks.GRAY_CONCRETE)));

    public static final RegistryObject<Block> METAL_TUBES = registerBlock("metal_tubes",
            () -> new MetalTubes(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).dynamicShape()));

    public static final RegistryObject<Block> SHOVEL_BLOCK = registerBlock("shovel_block",
            () -> new ShovelBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).dynamicShape()));

    public static final RegistryObject<Block> RAKE_BLOCK = registerBlock("rake_block",
            () -> new RakeBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).dynamicShape()));

    public static final RegistryObject<Block> STRAW_WHEAT = registerBlock("straw_wheat",
            () -> new StrawWheat(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK).dynamicShape()));

    public static final RegistryObject<Block> DECOBENCH = registerBlock("decobench",
            () -> new DecoBench(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).dynamicShape()));



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
