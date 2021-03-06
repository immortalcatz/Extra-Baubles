package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import com.minecraftitems.ExtraBaubles.providers.IFlightProvider;
import com.minecraftitems.ExtraBaubles.reference.Messages;
import com.minecraftitems.ExtraBaubles.utility.IOwnable;
import com.minecraftitems.ExtraBaubles.utility.ItemHelper;
import com.minecraftitems.ExtraBaubles.utility.NBTHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.UsernameCache;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.UUID;

public class ItemFlyingRing extends ItemBaubles implements IFlightProvider
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
        StopFlying((EntityPlayer) entity);
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase entity)
    {
        StartFlying((EntityPlayer) entity);
    }

    @Override
    public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase entity)
    {
        StartFlying((EntityPlayer) entity);
    }

    public void StartFlying(EntityPlayer player)
    {
        player.capabilities.allowFlying = true;
        if (!player.getEntityWorld().isRemote)
        {
            player.sendPlayerAbilities();
        }

            player.getEntityWorld().playSoundAtEntity(player, "mob.enderdragon.wings", 1F, 1f);

    }

    public void StopFlying(EntityPlayer player)
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
                StartFlying(player);
            }
        }
    }


}
