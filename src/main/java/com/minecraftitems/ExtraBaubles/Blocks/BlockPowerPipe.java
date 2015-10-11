package com.minecraftitems.ExtraBaubles.Blocks;

import com.minecraftitems.ExtraBaubles.tileentity.TileEntityPowerPipe;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPowerPipe extends BlockContainerEB
{

    public BlockPowerPipe()
    {
        super();
        this.setBlockName("PowerPipe");

        float pixel = 1f/16f;

        this.setBlockBounds(11*pixel/2, 11*pixel/2, 11*pixel/2, 1-11*pixel/2, 1-11*pixel/2, 1-11*pixel/2);
        this.useNeighborBrightness=true;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int var1)
    {
        return new TileEntityPowerPipe();
    }
}
