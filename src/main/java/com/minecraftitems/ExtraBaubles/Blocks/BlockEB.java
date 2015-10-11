package com.minecraftitems.ExtraBaubles.Blocks;

import com.minecraftitems.ExtraBaubles.CreativeTab.CreativeTabEB;
import com.minecraftitems.ExtraBaubles.reference.Reference;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEB extends Block
{
    public BlockEB(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabEB.EB_TAB);
    }

    public BlockEB()
    {
        this(Material.rock);

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
