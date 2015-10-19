package com.minecraftitems.ExtraBaubles.init;

import com.minecraftitems.ExtraBaubles.Blocks.TestBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockInit
{

    public static final TestBlock TEST_BLOCK = new TestBlock();

    public static void init()
    {
       // GameRegistry.registerBlock(TEST_BLOCK, "TestBlock");
    }
}
