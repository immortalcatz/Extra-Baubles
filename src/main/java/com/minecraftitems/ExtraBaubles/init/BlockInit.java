package com.minecraftitems.ExtraBaubles.init;

import com.minecraftitems.ExtraBaubles.Blocks.BlockVault;
import com.minecraftitems.ExtraBaubles.Blocks.TestBlock;
import com.minecraftitems.ExtraBaubles.Blocks.TileVault;
import com.minecraftitems.ExtraBaubles.reference.Name;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockInit
{

    public static final TestBlock TEST_BLOCK = new TestBlock();
    public static final BlockVault VAULT = new BlockVault();

    public static void init()
    {
       // GameRegistry.registerBlock(TEST_BLOCK, "TestBlock");
        GameRegistry.registerTileEntity(TileVault.class, Name.TileEntity.VAULT);
        GameRegistry.registerBlock(VAULT, "Vault");
    }
}
