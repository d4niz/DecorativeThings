package dev.d4niz.decorativeblocks;

import com.mojang.logging.LogUtils;
import dev.d4niz.decorativeblocks.block.ModBlocks;
import dev.d4niz.decorativeblocks.core.BlocksTab;
import dev.d4niz.decorativeblocks.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DecorativeBlocks.MODID)
public class DecorativeBlocks {
    public static final String MODID = "decorativeblocks";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DecorativeBlocks() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(BlocksTab::addCreative);
    }
}
