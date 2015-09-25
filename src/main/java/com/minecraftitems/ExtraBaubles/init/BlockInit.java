package com.minecraftitems.ExtraBaubles.init;

import com.minecraftitems.ExtraBaubles.Blocks.BlockPowerPipe;
import com.minecraftitems.ExtraBaubles.tileentity.TileEntityPowerPipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockInit
{

    public static final BlockPowerPipe POWER_PIPE = new BlockPowerPipe();

    public static void init()
    {
        GameRegistry.registerBlock(POWER_PIPE, "PowerPipe");
        GameRegistry.registerTileEntity(TileEntityPowerPipe.class, "PowerPipe");
    }
}
