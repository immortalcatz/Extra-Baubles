package com.minecraftitems.ExtraBaubles.Items;

import com.minecraftitems.ExtraBaubles.money.MoneyManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTest2 extends ItemEB {

    public ItemTest2(){

    }

    @Override
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
        MoneyManager.getBankUser();
        return p_77659_1_;
    }
}
