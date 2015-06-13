package com.turkey.mpaddon.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.turkey.mpaddon.MPACore;
import com.turkey.mpaddon.blocks.MPABlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LockedDoorItem extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon icon2;
    @SideOnly(Side.CLIENT)
    private IIcon icon3;

    public LockedDoorItem()
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(MPACore.modTab);
        this.maxStackSize = 1;
        super.setTextureName(MPACore.MODID + "doorItem1");
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        return stack.getItemDamage() == 1 ? "item.doorItem1" : stack.getItemDamage() == 2 ? "item.doorItem2" :  "item.doorItem3";
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tabs, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 1));
    	list.add(new ItemStack(item, 1, 2));
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int damage)
    {
        return damage == 1 ? this.icon2 : damage == 2 ? this.icon2 : super.getIconFromDamage(damage);
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        super.registerIcons(register);
        this.icon2 = register.registerIcon(MPACore.MODID + "doorItem1");
        this.icon2 = register.registerIcon(MPACore.MODID + "doorItem2");
        this.icon3 = register.registerIcon(MPACore.MODID + "doorItem3");
    }
    
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (side != 1)
        {
            return false;
        }
        else
        {
            ++y;
            Block block;

            if (this.getDamage(stack) == 1)
                block = MPABlocks.lockedDoor1;
            else if(this.getDamage(stack) == 2)
                block = MPABlocks.lockedDoor2;
            else
            	block = MPABlocks.lockedDoor3;

            if (player.canPlayerEdit(z, y, z, side, stack) && player.canPlayerEdit(x, y + 1, z, side, stack))
            {
                if (!block.canPlaceBlockAt(world, x, y, z))
                {
                    return false;
                }
                else
                {
                    int i1 = MathHelper.floor_double((double)((player.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                    placeDoorBlock(world, x, y, z, i1, block);
                    --stack.stackSize;
                    return true;
                }
            }
            else
            {
                return false;
            }
        }
    }

    public static void placeDoorBlock(World world, int x, int y, int z, int side, Block block)
    {
        byte b0 = 0;
        byte b1 = 0;

        if (side == 0)
        {
            b1 = 1;
        }

        if (side == 1)
        {
            b0 = -1;
        }

        if (side == 2)
        {
            b1 = -1;
        }

        if (side == 3)
        {
            b0 = 1;
        }

        int i1 = (world.getBlock(x - b0, y, z - b1).isNormalCube() ? 1 : 0) + (world.getBlock(x - b0, y + 1, z - b1).isNormalCube() ? 1 : 0);
        int j1 = (world.getBlock(x + b0, y, z + b1).isNormalCube() ? 1 : 0) + (world.getBlock(x + b0, y + 1, z + b1).isNormalCube() ? 1 : 0);
        boolean flag = world.getBlock(x - b0, y, z - b1) == block || world.getBlock(x - b0, y + 1, z - b1) == block;
        boolean flag1 = world.getBlock(x + b0, y, z + b1) == block || world.getBlock(x + b0, y + 1, z + b1) == block;
        boolean flag2 = false;

        if (flag && !flag1)
        {
            flag2 = true;
        }
        else if (j1 > i1)
        {
            flag2 = true;
        }

        world.setBlock(x, y, z, block, side, 2);
        world.setBlock(x, y + 1, z, block, 8 | (flag2 ? 1 : 0), 2);
        world.notifyBlocksOfNeighborChange(x, y, z, block);
        world.notifyBlocksOfNeighborChange(x, y + 1, z, block);
    }
  
}
