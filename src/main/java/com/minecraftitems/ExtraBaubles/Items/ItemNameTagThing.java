package com.minecraftitems.ExtraBaubles.Items;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemNameTagThing extends ItemEB {

    public ItemNameTagThing() {

    }

    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase entity)
    {
        if (!stack.hasDisplayName())
        {
            return false;
        }
        else if (entity instanceof EntityLiving)
        {
            EntityLiving entityliving = (EntityLiving)entity;
            entityliving.setCustomNameTag(stack.getDisplayName());
            entityliving.func_110163_bv();
            --stack.stackSize;
            return true;
        }
        else
        {
            return super.itemInteractionForEntity(stack, player, entity);
        }
    }

}
