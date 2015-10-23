package com.minecraftitems.ExtraBaubles.Blocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockVault extends BlockContainerEB
{
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileVault();
    }
}
