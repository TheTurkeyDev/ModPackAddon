package com.turkey.mpaddon.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.turkey.mpaddon.item.MPAItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LockedDoor extends BlockDoor
{

	public LockedDoor()
	{
		super(Material.circuits);
		super.setHardness(-1f);
		super.setStepSound(soundTypeMetal);
		super.disableStats();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		if(meta == 0)
		{
			if(player.inventory.getCurrentItem().equals(MPAItems.acessCard))
			{
				int i1 = this.func_150012_g(world, x, y, z);
				int j1 = i1 & 7;
				j1 ^= 4;

				if ((i1 & 8) == 0)
				{
					world.setBlockMetadataWithNotify(x, y, z, j1, 2);
					world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
				}
				else
				{
					world.setBlockMetadataWithNotify(x, y - 1, z, j1, 2);
					world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
				}

				world.playAuxSFXAtEntity(player, 1003, x, y, z, 0);
				return true;
			}
		}
		return false;	
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return Item.getItemFromBlock(this);	
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	{
		return this.getUnlocalizedName().equalsIgnoreCase("Locked_Door_Tier1")? MPAItems.doorItem1:MPAItems.doorItem1;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List p_149666_3_)
	{
		p_149666_3_.add(new ItemStack(item, 1, 0));
		p_149666_3_.add(new ItemStack(item, 1, 1));
	}

	public int damageDropped(int p_149692_1_)
	{
		return p_149692_1_;
	}
}
