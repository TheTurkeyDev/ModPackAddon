package mpaddon.item;

import mpaddon.MPACore;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PlasticBottle extends Item
{
	//private IIcon filledBottle;

	public PlasticBottle()
	{
		super.setCreativeTab(MPACore.modTab);
		super.setHasSubtypes(true);
		super.setUnlocalizedName("Plastic_Bottle");
	}

	/**
	 * Gets an icon index based on an item's damage value
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int p_77617_1_)
	{
		return Items.potionitem.getIconFromDamage(0);
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	{
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(p_77659_2_, p_77659_3_, true);

		if (movingobjectposition == null)
		{
			return p_77659_1_;
		}
		else
		{
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			{
				int i = movingobjectposition.blockX;
				int j = movingobjectposition.blockY;
				int k = movingobjectposition.blockZ;

				if (!p_77659_2_.canMineBlock(p_77659_3_, i, j, k))
				{
					return p_77659_1_;
				}

				if (!p_77659_3_.canPlayerEdit(i, j, k, movingobjectposition.sideHit, p_77659_1_))
				{
					return p_77659_1_;
				}

				if (p_77659_2_.getBlock(i, j, k).getMaterial() == Material.water)
				{
					--p_77659_1_.stackSize;

					if (p_77659_1_.stackSize <= 0)
					{
						return new ItemStack(Items.potionitem);
					}

					if (!p_77659_3_.inventory.addItemStackToInventory(new ItemStack(Items.potionitem)))
					{
						p_77659_3_.dropPlayerItemWithRandomChoice(new ItemStack(Items.potionitem, 1, 0), false);
					}
				}
			}

			return p_77659_1_;
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister registry) 
	{
		registry.registerIcon(MPACore.MODID + ":");
	}
}