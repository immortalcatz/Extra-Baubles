package com.minecraftitems.ExtraBaubles.proxy;

import com.minecraftitems.ExtraBaubles.tileentity.TileEntityPowerPipe;
import com.minecraftitems.ExtraBaubles.tileentity.TileEntityRenderPowerPipe;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy
{
    @Override
    public void RegisterRenders()
    {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPowerPipe.class, new TileEntityRenderPowerPipe());
    }
}
