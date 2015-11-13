package com.minecraftitems.ExtraBaubles.init;

import com.minecraftitems.ExtraBaubles.Items.*;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemInit
{
    public static final ItemFlyingRing FLYING_RING = new ItemFlyingRing();
    public static final ItemMagnetRing MAGNET_RING = new ItemMagnetRing();
    public static final ItemBlankRing BLANK_RING = new ItemBlankRing();
    public static final ItemWings WINGS = new ItemWings();
    public static final ItemMagnetIron MAGNET_IRON = new ItemMagnetIron();
    public static final ItemGoldDust GOLD_DUST = new ItemGoldDust();
    public static final ItemIronDust IRON_DUST = new ItemIronDust();
    public static final ItemBeltWaterWalking WATER_WALKING = new ItemBeltWaterWalking();
    public static final ItemBag BAG = new ItemBag();
    public static final ItemAmuletNightVision AMULET_NIGHT_VISION = new ItemAmuletNightVision();
    public static final ItemNameTagThing NAME_TAG_THING = new ItemNameTagThing();
    public static final ItemTest2 TEST_2 = new ItemTest2();

    public static void init()
    {
        GameRegistry.registerItem(FLYING_RING, "FlyingRing");
        GameRegistry.registerItem(MAGNET_RING, "MagnetRing");
        GameRegistry.registerItem(BLANK_RING, "BlankRing");
        GameRegistry.registerItem(WINGS, "Wings");
        GameRegistry.registerItem(MAGNET_IRON, "MagnetIron");
        GameRegistry.registerItem(GOLD_DUST, "GoldDust");
        GameRegistry.registerItem(IRON_DUST, "IronDust");
        GameRegistry.registerItem(WATER_WALKING, "WaterWalking");
        GameRegistry.registerItem(AMULET_NIGHT_VISION, "AmuletNightVision");
        GameRegistry.registerItem(BAG, "ItemBag");
        //GameRegistry.registerItem(NAME_TAG_THING, "NaMe TaG");
        GameRegistry.registerItem(TEST_2, "Test2");
    }
}
