package com.minecraftitems.ExtraBaubles.providers;

import net.minecraft.entity.player.EntityPlayer;

public interface IFlightProvider
{
    public void StartFlying(EntityPlayer player);
    /*     Method
    {
    player.capabilities.allowFlying = true;
        if (!player.getEntityWorld().isRemote)
        {
            player.sendPlayerAbilities();
        }
     }
     */

    public void StopFlying(EntityPlayer player);
    /*     Method
    {
     player.capabilities.isFlying = false;
     player.capabilities.allowFlying = false;

        if (!player.getEntityWorld().isRemote)
        {
            player.sendPlayerAbilities();
        }
     }
     */
}
