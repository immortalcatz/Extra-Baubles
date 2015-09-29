package com.minecraftitems.ExtraBaubles.Items;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import com.minecraftitems.ExtraBaubles.helpers.Config;
import com.minecraftitems.ExtraBaubles.helpers.NBTHelper;
import com.minecraftitems.ExtraBaubles.helpers.Vector3d;
import com.minecraftitems.ExtraBaubles.providers.IFlightProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

public class ItemMixedRing extends ItemBaubles implements IFlightProvider
{

    public static final float RANGE = 10f;


    public ItemMixedRing()
    {
        super();
        this.setUnlocalizedName("MixedRing");
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack)
    {
        return BaubleType.RING;
    }

    @Override
    public void onUnequipped(ItemStack itemstack, EntityLivingBase entity)
    {
        StopFlying((EntityPlayer) entity);
    }

    @Override
    public void onEquipped(ItemStack itemstack, EntityLivingBase entity)
    {
        StartFlying((EntityPlayer) entity);
        Magnet((ItemStack) itemstack, (EntityLivingBase) entity);
        WalkWater((ItemStack) itemstack, (EntityLivingBase) entity);

    }

    @Override
    public void onEquippedOrLoadedIntoWorld(ItemStack stack, EntityLivingBase entity)
    {
        StartFlying((EntityPlayer) entity);
        Magnet((ItemStack) stack, (EntityLivingBase) entity);
        WalkWater((ItemStack) stack, (EntityLivingBase) entity);

    }

    @Override
    public void StartFlying(EntityPlayer player)
    {
        player.capabilities.allowFlying = true;
        if (!player.getEntityWorld().isRemote)
        {
            player.sendPlayerAbilities();
        }
        //if  (player.capabilities.isFlying == true)
        //{
        player.getEntityWorld().playSoundAtEntity(player, "mob.enderdragon.wings", 1F, 1f);
        //}
    }

    @Override
    public void StopFlying(EntityPlayer player)
    {
        player.capabilities.isFlying = false;
        player.capabilities.allowFlying = false;

        if (!player.getEntityWorld().isRemote)
        {
            player.sendPlayerAbilities();
        }
    }

    public void WalkWater(ItemStack itemStack, EntityLivingBase player)
    {
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

    @SuppressWarnings("unchecked")
    public void Magnet(ItemStack bauble, EntityLivingBase entity)
    {
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
