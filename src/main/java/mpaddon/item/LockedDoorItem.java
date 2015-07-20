package mpaddon.item;

import mpaddon.MPACore;
import mpaddon.blocks.MPABlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class LockedDoorItem extends Item
{
	private int doorNum;
	
    public LockedDoorItem(int num)
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setCreativeTab(MPACore.modTab);
        this.maxStackSize = 1;
        super.setTextureName(MPACore.MODID + ":doorItem" + num);
        super.setUnlocalizedName("doorItem" + num);
        doorNum = num;
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

            if (doorNum == 1)
                block = MPABlocks.lockedDoor1;
            else if(doorNum == 2)
                block = MPABlocks.lockedDoor2;
            else if(doorNum == 3)
                block = MPABlocks.lockedDoor3;
            else if(doorNum == 4)
                block = MPABlocks.lockedDoor4;
            else
            	block = MPABlocks.lockedDoor5;

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
