package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import com.minecraftitems.ExtraBaubles.reference.Messages;
import com.minecraftitems.ExtraBaubles.utility.IOwnable;
import com.minecraftitems.ExtraBaubles.utility.ItemHelper;
import com.minecraftitems.ExtraBaubles.utility.NBTHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.UsernameCache;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.UUID;

public class ItemAmuletNightVision extends ItemBaubles
{
    public ItemAmuletNightVision() {
        this.setUnlocalizedName("AmuletNightVision");
    }

    @Override
    public BaubleType getBaubleType(ItemStack stack)
    {
        return BaubleType.AMULET;
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase entity)
    {
        PotionEffect effect = entity.getActivePotionEffect(Potion.nightVision);
        if (effect == null || effect.getDuration() < 900) entity.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1000, 1, true));
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
    {
        player.removePotionEffect(Potion.nightVision.id);
    }


}
