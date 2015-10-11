package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.minecraftitems.ExtraBaubles.CreativeTab.CreativeTabEB;
import com.minecraftitems.ExtraBaubles.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBaubles extends Item implements IBauble
{

    public ItemBaubles()
    {
        super();
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabEB.EB_TAB);

    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return null;
    }

    @Override
    public void onWornTick(ItemStack stack, EntityLivingBase player) {
        if (player.ticksExisted == 1) onEquippedOrLoadedIntoWorld(stack, player);
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    @Override
    public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }

    public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase player) {

    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
