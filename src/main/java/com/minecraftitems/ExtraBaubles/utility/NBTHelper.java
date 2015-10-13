package com.minecraftitems.ExtraBaubles.utility;

import com.minecraftitems.ExtraBaubles.reference.Name;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.UUID;

public class NBTHelper
{
    public static boolean hasTag(ItemStack itemStack, String keyName)
    {
        return itemStack != null && itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey(keyName);
    }

    public static void removeTag(ItemStack itemStack, String keyName)
    {
        if (itemStack.stackTagCompound != null)
        {
            itemStack.stackTagCompound.removeTag(keyName);
        }
    }

    public static boolean hasUUID(ItemStack itemStack)
    {
        return hasTag(itemStack, Name.NBT.UUID_MOST_SIG) && hasTag(itemStack, Name.NBT.UUID_LEAST_SIG);
    }

    public static void setUUID(ItemStack itemStack)
    {
        initNBTTagCompound(itemStack);

        // Set a UUID on the Alchemical Bag, if one doesn't exist already
        if (!hasTag(itemStack, Name.NBT.UUID_MOST_SIG) && !hasTag(itemStack, Name.NBT.UUID_LEAST_SIG))
        {
            UUID itemUUID = UUID.randomUUID();
            setLong(itemStack, Name.NBT.UUID_MOST_SIG, itemUUID.getMostSignificantBits());
            setLong(itemStack, Name.NBT.UUID_LEAST_SIG, itemUUID.getLeastSignificantBits());
        }
    }

    private static void initNBTTagCompound(ItemStack itemStack)
    {
        if (itemStack.stackTagCompound == null)
        {
            itemStack.setTagCompound(new NBTTagCompound());
        }
    }

    public static void setLong(ItemStack itemStack, String keyName, long keyValue)
    {
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setLong(keyName, keyValue);
    }

    public static String getString(ItemStack itemStack, String keyName)
    {
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setString(itemStack, keyName, "");
        }

        return itemStack.stackTagCompound.getString(keyName);
    }

    public static void setString(ItemStack itemStack, String keyName, String keyValue)
    {
        initNBTTagCompound(itemStack);

        itemStack.stackTagCompound.setString(keyName, keyValue);
    }

    public static long getLong(ItemStack itemStack, String keyName)
    {
        initNBTTagCompound(itemStack);

        if (!itemStack.stackTagCompound.hasKey(keyName))
        {
            setLong(itemStack, keyName, 0);
        }

        return itemStack.stackTagCompound.getLong(keyName);
    }
}
