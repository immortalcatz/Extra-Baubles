package com.minecraftitems.ExtraBaubles.Items;

import com.minecraftitems.ExtraBaubles.CreativeTab.CreativeTabEB;
import com.minecraftitems.ExtraBaubles.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemTest extends Item {

    private String name = "ItemTest";
    
    private String[] colors = {"red", "green", "blue"};

    @SideOnly(Side.CLIENT)
    private IIcon[] icons;

    public ItemTest() {
        super();
        this.hasSubtypes(true);
        this.setUnlocalizedName(Reference.MOD_ID + ":" + name);
        this.setTextureName(Reference.MOD_ID + ":" + name);
        this.setCreativeTab(CreativeTabEB.EB_TAB);
    }

    private void hasSubtypes(boolean b) {

    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List list) {

        for (int x = 0; x < colors.length; x++)
        {
            list.add(new ItemStack(this, 1, x));
        }

    }

    @Override
    public IIcon getIconFromDamage(int par1)
    {
        return icons[par1];
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister par1IconRegister)
    {
        icons = new IIcon[colors.length];

        for (int i = 0; i < icons.length; i++)
        {
            icons[i] = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + name + "_" + colors[i]);
        }
    }
    
    




}
