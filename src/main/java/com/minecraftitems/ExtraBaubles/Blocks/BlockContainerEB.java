package com.minecraftitems.ExtraBaubles.Blocks;

import com.minecraftitems.ExtraBaubles.CreativeTab.CreativeTabEB;
import com.minecraftitems.ExtraBaubles.reference.Reference;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockContainerEB extends BlockContainer
{
    public BlockContainerEB(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabEB.EB_TAB);
    }

    public BlockContainerEB()
    {
        this(Material.rock);

    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return null;
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(cpw.mods.fml.relauncher.Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
