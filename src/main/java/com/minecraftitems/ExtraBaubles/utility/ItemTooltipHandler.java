package com.minecraftitems.ExtraBaubles.utility;

import com.minecraftitems.ExtraBaubles.reference.Messages;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.UsernameCache;
import net.minecraftforge.event.entity.player.*;
import org.lwjgl.input.Keyboard;

import java.util.UUID;

@SideOnly(Side.CLIENT)
public class ItemTooltipHandler
{
    public void handleItemTooltip(net.minecraftforge.event.entity.player.ItemTooltipEvent event)
    {
        if (event.itemStack.getItem() instanceof IOwnable)
        {
            UUID playerUUID = ItemHelper.getOwnerUUID(event.itemStack);
            if (playerUUID != null && UsernameCache.containsUUID(playerUUID))
            {
                event.toolTip.add(StatCollector.translateToLocalFormatted(Messages.ITEM_BELONGS_TO, UsernameCache.getLastKnownUsername(playerUUID)));
            }
            else if (ItemHelper.hasOwnerName(event.itemStack))
            {
                event.toolTip.add(StatCollector.translateToLocalFormatted(Messages.ITEM_BELONGS_TO, ItemHelper.getOwnerName(event.itemStack)));
            }
            else
            {
                if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
                {
                    event.toolTip.add(StatCollector.translateToLocal(Messages.ITEM_BELONGS_TO_NO_ONE));
                }
            }
        }
    }
}
