package com.minecraftitems.ExtraBaubles.CreativeTab;

import com.minecraftitems.ExtraBaubles.init.ItemInit;
import com.minecraftitems.ExtraBaubles.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabEB
{
    public static final CreativeTabs EB_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem()
        {
            return ItemInit.BLANK_RING;
        }
    };

}
