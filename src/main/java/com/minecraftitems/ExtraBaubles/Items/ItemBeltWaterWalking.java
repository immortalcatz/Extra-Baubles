package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import com.minecraftitems.ExtraBaubles.reference.Messages;
import com.minecraftitems.ExtraBaubles.utility.IOwnable;
import com.minecraftitems.ExtraBaubles.utility.ItemHelper;
import com.minecraftitems.ExtraBaubles.utility.NBTHelper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.common.UsernameCache;
import org.lwjgl.input.Keyboard;

import java.util.List;
import java.util.UUID;

public class ItemBeltWaterWalking extends ItemBaubles
{

    public ItemBeltWaterWalking()
    {
        super();
        setUnlocalizedName("ItemBeltWaterWalking");

    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.BELT;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        World world = player.worldObj;
        int x = MathHelper.floor_double(player.posX);
        int y = MathHelper.floor_double(player.boundingBox.minY - 0.11f);
        int yPaddle = MathHelper.floor_double(player.boundingBox.minY);
        int z = MathHelper.floor_double(player.posZ);
        Material mWater = world.getBlock(x, y, z).getMaterial();
        Material mPaddle = world.getBlock(x, yPaddle, z).getMaterial();
        boolean waterBelow = (mWater == Material.water);
        boolean paddlingInWater = (mPaddle == Material.water);

        if (waterBelow && player.motionY < 0.0D && !player.isSneaking()) {
            if (player instanceof EntityPlayerMP) {
                player.posY -= player.yOffset;
            } else {
                player.posY -= player.motionY;
            }
            player.motionY = 0.0D;
            player.fallDistance = 0.0F;
        }

        if ((player.isInWater() || paddlingInWater) && !player.isSneaking()) {
            player.motionY = 0.1f;
        }
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
        if (!player.worldObj.isRemote) {
            player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 1.3f);
        }
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
    }


}
