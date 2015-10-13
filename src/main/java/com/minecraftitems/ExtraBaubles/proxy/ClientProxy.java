package com.minecraftitems.ExtraBaubles.proxy;

import com.minecraftitems.ExtraBaubles.utility.ItemTooltipHandler;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerEventHandlers() {
        super.registerEventHandlers();
        MinecraftForge.EVENT_BUS.register(new ItemTooltipHandler());
    }
}
