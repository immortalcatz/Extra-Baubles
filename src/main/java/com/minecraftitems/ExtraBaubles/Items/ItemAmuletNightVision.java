package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

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
