package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.minecraftitems.ExtraBaubles.reference.Messages;
import com.minecraftitems.ExtraBaubles.utility.IOwnable;
import com.minecraftitems.ExtraBaubles.utility.ItemHelper;
import com.minecraftitems.ExtraBaubles.utility.NBTHelper;
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

public class ItemRingOfOwnership extends ItemBaubles
{

    public ItemRingOfOwnership()
    {
        super();
        this.setUnlocalizedName("RingOfOwnership");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        Owner((ItemStack) itemstack, (EntityPlayer) player);
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

    public static void Owner(ItemStack itemStack, EntityPlayer entityPlayer)
    {
        if (!entityPlayer.worldObj.isRemote) {
            if (!ItemHelper.hasOwnerUUID(itemStack))
            {
                ItemHelper.setOwner(itemStack, entityPlayer);
                entityPlayer.addChatComponentMessage(new ChatComponentTranslation(Messages.OWNER_SET_TO_SELF, new Object[]{itemStack.func_151000_E()}));
            }

            NBTHelper.setUUID(itemStack);
        }
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool)
    {
        if (stack.getItem() instanceof IOwnable)
        {
            UUID playerUUID = ItemHelper.getOwnerUUID(stack);
            if (playerUUID != null && UsernameCache.containsUUID(playerUUID))
            {
                list.add(StatCollector.translateToLocalFormatted(Messages.ITEM_BELONGS_TO, UsernameCache.getLastKnownUsername(playerUUID)));
            }
            else if (ItemHelper.hasOwnerName(stack))
            {
                list.add(StatCollector.translateToLocalFormatted(Messages.ITEM_BELONGS_TO, ItemHelper.getOwnerName(stack)));
            }
            else
            {
                if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
                {
                    list.add(StatCollector.translateToLocal(Messages.ITEM_BELONGS_TO_NO_ONE));
                }
            }
        }
    }
}
