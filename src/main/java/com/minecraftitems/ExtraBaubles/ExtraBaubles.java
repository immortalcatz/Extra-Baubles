package com.minecraftitems.ExtraBaubles;

import com.minecraftitems.ExtraBaubles.Crafting.ItemCrafting;
import com.minecraftitems.ExtraBaubles.init.BlockInit;
import com.minecraftitems.ExtraBaubles.init.ItemInit;
import com.minecraftitems.ExtraBaubles.proxy.CommonProxy;
import com.minecraftitems.ExtraBaubles.proxy.IProxy;
import com.minecraftitems.ExtraBaubles.reference.Reference;
import com.minecraftitems.ExtraBaubles.utility.Log;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class ExtraBaubles
{

    @Mod.Instance(Reference.MOD_ID)
    public static ExtraBaubles instance;

    @SidedProxy(clientSide = "com.minecraftitems.ExtraBaubles.proxy.ClientProxy", serverSide = "com.minecraftitems.ExtraBaubles.proxy.ServerProxy")
    public static IProxy Proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        Log.info("Started pre Initialization event");
        ItemInit.init();
        BlockInit.init();
        Log.info("Finished pre Initialization event");

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event)
    {
        Log.info("Started Initialization event");
        ItemCrafting.init();
        Log.info("Finished Initialization event");
        Proxy.registerEventHandlers();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        Log.info("Started post Initialization event");
        Log.info("Finished post Initialization event");
    }


}
