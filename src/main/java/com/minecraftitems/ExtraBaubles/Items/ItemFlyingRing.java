package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemFlyingRing extends ItemBaubles
{
    public ItemFlyingRing()
    {
        super();
        setUnlocalizedName("FlyingRing");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack)
    {
        return BaubleType.RING;
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase entity)
    {
        stopFlying((EntityPlayer) entity);
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase entity)
    {
        startFlying((EntityPlayer) entity);
    }

    @Override
    public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase entity)
    {
        startFlying((EntityPlayer) entity);
    }

    private void startFlying(EntityPlayer player)
    {
        player.capabilities.allowFlying = true;
        if (!player.getEntityWorld().isRemote)
        {
            player.sendPlayerAbilities();
        }
        //if  (player.capabilities.isFlying == true)
        //{
            player.getEntityWorld().playSoundAtEntity(player, "mob.enderdragon.wings", 1F, 1f);
        //}
    }

    private void stopFlying(EntityPlayer player)
    {
        player.capabilities.isFlying = false;
        player.capabilities.allowFlying = false;

        if (!player.getEntityWorld().isRemote)
        {
            player.sendPlayerAbilities();
        }
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity)
    {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = ((EntityPlayer) entity);
            if (!player.capabilities.allowFlying)
            {
                startFlying(player);
            }
        }
    }

}
