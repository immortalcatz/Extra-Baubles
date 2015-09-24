package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import com.minecraftitems.ExtraBaubles.helpers.Config;
import com.minecraftitems.ExtraBaubles.helpers.NBTHelper;
import com.minecraftitems.ExtraBaubles.helpers.Vector3d;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class ItemMagnetRing extends ItemBaubles
{
    public static final float RANGE = 10f;

    public ItemMagnetRing()
    {
        super();
        this.setUnlocalizedName("MagnetRing");
    }

    @Override
    public BaubleType getBaubleType(ItemStack arg0) {
        return BaubleType.RING;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onWornTick(ItemStack bauble, EntityLivingBase entity) {
        EntityPlayer player = (EntityPlayer) entity;

        AxisAlignedBB bounds = player.boundingBox.expand(RANGE, RANGE, RANGE);

        List<EntityItem> itemEntities = player.worldObj.getEntitiesWithinAABB(EntityItem.class, bounds);
        List<EntityXPOrb> xpEntities = player.worldObj.getEntitiesWithinAABB(EntityXPOrb.class, bounds);

        for (EntityItem entityItem : itemEntities) {
            boolean ignore = false;
            ItemStack stack = entityItem.getEntityItem();
            List<ItemStack> blacklist = getBlacklist(bauble);
            List<Byte> compareTypes = getBlacklistCompareTypes(bauble);
            for (int i = 0; i < blacklist.size(); i++) {
                int compareType = compareTypes.get(i);
                ItemStack compareStack = blacklist.get(i);
                if (compareType == 0) {
                    if (stack.getItem() == compareStack.getItem()) {
                        ignore = true;
                    }
                } else if (compareType == 1) {
                    if (stack.isItemEqual(compareStack)) {
                        ignore = true;
                    }
                } else if (compareType == 2) {
                    if (stack.getItem() == compareStack.getItem() && ItemStack.areItemStackTagsEqual(stack, compareStack)) {
                        ignore = true;
                    }
                } else if (compareType == 3) {
                    if (stack.isItemEqual(compareStack) && ItemStack.areItemStackTagsEqual(stack, compareStack)) {
                        ignore = true;
                    }
                }
            }
            if (!ignore && entityItem.age >= 30) {
                suckEntityToPlayer(entityItem, player);
            }
        }

        for (EntityXPOrb entityXP : xpEntities) {
            suckEntityToPlayer(entityXP, player);
        }
    }

    public void suckEntityToPlayer(Entity entity, EntityPlayer player) {
        moveEntityTo(entity, new Vector3d((float) player.posX, (float) (player.posY - (player.worldObj.isRemote ? 1.62D : 0.0D) + 0.75D), (float) player.posZ), 0.45f);

        if (player.worldObj.isRemote && Config.soundEffectChance > 0 && player.worldObj.rand.nextInt(Config.soundEffectChance) == 0) {
            float pitch = 0.85f - player.worldObj.rand.nextFloat() * 3f / 10f;
            player.worldObj.playSoundEffect(entity.posX, entity.posY, entity.posZ, "mob.endermen.portal", 0.6f, pitch);
        }
    }

    public void moveEntityTo(Entity entity, Vector3d position, double speed) {
        Vector3d entityPos = new Vector3d(entity.posX, entity.posY - entity.yOffset + entity.height / 2f, entity.posZ);
        Vector3d motionVector = position.sub(entityPos);
        if (motionVector.magnitude() > 1.0D) {
            motionVector.normalise();
        }

        entity.motionX = motionVector.x * speed;
        entity.motionY = motionVector.y * speed;
        entity.motionZ = motionVector.z * speed;
    }

    public static List<ItemStack> getBlacklist(ItemStack stack) {
        List<ItemStack> blacklist = new ArrayList();
        NBTTagCompound compound = NBTHelper.getItemStackCompound(stack);
        if (compound.hasKey("MagnetBlacklist")) {
            NBTTagList blacklistList = compound.getTagList("MagnetBlacklist", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < blacklistList.tagCount(); i++) {
                NBTTagCompound itemTag = blacklistList.getCompoundTagAt(i);
                blacklist.add(ItemStack.loadItemStackFromNBT(itemTag));
            }
        }
        return blacklist;
    }

    public static List<Byte> getBlacklistCompareTypes(ItemStack stack) {
        List<Byte> blacklist = new ArrayList();
        NBTTagCompound compound = NBTHelper.getItemStackCompound(stack);
        if (compound.hasKey("MagnetBlacklist")) {
            NBTTagList blacklistList = compound.getTagList("MagnetBlacklist", Constants.NBT.TAG_COMPOUND);
            for (int i = 0; i < blacklistList.tagCount(); i++) {
                NBTTagCompound itemTag = blacklistList.getCompoundTagAt(i);
                blacklist.add(itemTag.getByte("CompareType"));
            }
        }
        return blacklist;
    }
}
