package com.minecraftitems.ExtraBaubles.Crafting;

import com.minecraftitems.ExtraBaubles.init.ItemInit;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemCrafting
{
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ItemInit.BLANK_RING), " g ", "g g", " g ", 'g', Items.gold_ingot);
        GameRegistry.addRecipe(new ItemStack(ItemInit.FLYING_RING), "w w", " r ", "   ", 'r', ItemInit.BLANK_RING, 'w', ItemInit.WINGS);
        GameRegistry.addRecipe(new ItemStack(ItemInit.WINGS), "f f", "f f", "f f", 'f', Items.feather);
        GameRegistry.addRecipe(new ItemStack(ItemInit.GOLD_DUST), "  s", " g ", "b  ", 's', Items.stick, 'g', Items.gold_ingot, 'b', Items.bowl);
        GameRegistry.addRecipe(new ItemStack(ItemInit.IRON_DUST), "  s", " i ", "b  ", 's', Items.stick, 'i', Items.iron_ingot, 'b', Items.bowl);
        GameRegistry.addRecipe(new ItemStack(ItemInit.MAGNET_IRON), "gdg", "did", "gdg", 'd', ItemInit.IRON_DUST, 'g', ItemInit.GOLD_DUST, 'i', Items.iron_ingot);
        GameRegistry.addRecipe(new ItemStack(ItemInit.MAGNET_RING), "mmm", "mrm", "mmm", 'm', ItemInit.MAGNET_IRON, 'r', ItemInit.BLANK_RING);
        GameRegistry.addRecipe(new ItemStack(ItemInit.WATER_WALKING), "wlw", "lwl", "wlw", 'w', Items.water_bucket, 'l', Items.leather);
    }
}
