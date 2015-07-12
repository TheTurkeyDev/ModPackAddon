package mpaddon.blocks;

import java.util.List;
import java.util.Random;

import mpaddon.item.AccessCard;
import mpaddon.item.MPAItems;
import net.malisis.doors.door.DoorRegistry;
import net.malisis.doors.door.DoorState;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
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
		if(canItemOpen(player.inventory.getCurrentItem(), this) || player.capabilities.isCreativeMode)
		{
			int i1 = this.func_150012_g(world, x, y, z);
			int j1 = i1 & 7;
			j1 ^= 4;
			
			boolean open = false;

			if ((i1 & 8) == 0)
			{
				world.setBlockMetadataWithNotify(x, y, z, j1, 2);
				world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
				open = true;
			}
			else
			{
				world.setBlockMetadataWithNotify(x, y - 1, z, j1, 2);
				world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
			}
			String path = DoorRegistry.getSound("pneumatic_door").getSoundPath(open?DoorState.OPENING:DoorState.CLOSING);
			world.playSoundEffect(x, y, z, path, 1F, 1F);
			return true;
		}
		return false;	
	}

	private boolean canItemOpen(ItemStack currentItem, LockedDoor lockedDoor)
	{
		if(currentItem == null)
			return false;
		
		if(!(currentItem.getItem() instanceof AccessCard))
			return false;
		
		if(this.getUnlocalizedName().equalsIgnoreCase("tile.Locked_Door_Tier1") && currentItem.getItemDamage() == 0)
			return true;
		if(this.getUnlocalizedName().equalsIgnoreCase("tile.Locked_Door_Tier2") && currentItem.getItemDamage() == 1)
			return true;
		if(this.getUnlocalizedName().equalsIgnoreCase("tile.Locked_Door_Tier3") && currentItem.getItemDamage() == 2)
			return true;
		
		return false;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		return this.getUnlocalizedName().equalsIgnoreCase("tile.Locked_Door_Tier1")? MPAItems.lockedDoor1: this.getUnlocalizedName().equalsIgnoreCase("tile.Locked_Door_Tier2")? MPAItems.lockedDoor2: MPAItems.lockedDoor3;
	}

	@SideOnly(Side.CLIENT)
	public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	{
		return this.getUnlocalizedName().equalsIgnoreCase("tile.Locked_Door_Tier1")? MPAItems.lockedDoor1: this.getUnlocalizedName().equalsIgnoreCase("tile.Locked_Door_Tier2")? MPAItems.lockedDoor2: MPAItems.lockedDoor3;
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
		return 0;
	}
}
