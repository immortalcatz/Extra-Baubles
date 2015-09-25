package com.minecraftitems.ExtraBaubles;

import com.minecraftitems.ExtraBaubles.Crafting.ItemCrafting;
import com.minecraftitems.ExtraBaubles.init.BlockInit;
import com.minecraftitems.ExtraBaubles.init.ItemInit;
import com.minecraftitems.ExtraBaubles.proxy.CommonProxy;
import com.minecraftitems.ExtraBaubles.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class ExtraBaubles
{

    @SidedProxy(clientSide = "com.minecraftitems.ExtraBaubles.proxy.ClientProxy", serverSide = "com.minecraftitems.ExtraBaubles.proxy.CommonProxy")
    public static CommonProxy Proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        ItemInit.init();
        //BlockInit.init();

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {
        ItemCrafting.init();
       // Proxy.RegisterRenders();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {

    }
}
