package com.minecraftitems.ExtraBaubles.Items;

import com.minecraftitems.ExtraBaubles.money.MoneyManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemAccount extends ItemEB
{
    public ItemAccount()
    {
        super();
        this.setUnlocalizedName("AccountChecker");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!MoneyManager.hasAccount(player.getDisplayName()))
        {
            ChatComponentText component = new ChatComponentText("Sorry but you don't have an account");
            player.addChatComponentMessage(component);
        }
        return stack;
    }
}
