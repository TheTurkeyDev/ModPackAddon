package mpaddon.blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.Random;

import mpaddon.MPACore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ForeverFire extends Block
{
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ForeverFire()
	{
		super(Material.fire);
		super.setBlockName("Forever_Fire");
		super.setCreativeTab(MPACore.modTab);
		super.setLightLevel(1f);
		super.disableStats();
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	public boolean isCollidable()
	{
		return false;
	}

	public int quantityDropped(Random p_149745_1_)
	{
		return 0;
	}

	public int getRenderType()
	{
		return MPABlocks.FOREVER_FIRE_ID;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
		this.icons = new IIcon[] {p_149651_1_.registerIcon("minecraft:fire_layer_0"), p_149651_1_.registerIcon("minecraft:fire_layer_1")};
	}

	@SideOnly(Side.CLIENT)
	public IIcon getFireIcon(int index)
	{
		return this.icons[index];
	}
	/**
	 * Gets the block's texture. Args: side, meta
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_)
	{
		return this.icons[0];
	}

	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if (!World.doesBlockHaveSolidTopSurface(world, x, y - 1, z))
		{
			world.setBlockToAir(x, y, z);
		}
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
	{
		if (p_149734_5_.nextInt(24) == 0)
		{
			p_149734_1_.playSound((double)((float)p_149734_2_ + 0.5F), (double)((float)p_149734_3_ + 0.5F), (double)((float)p_149734_4_ + 0.5F), "fire.fire", 1.0F + p_149734_5_.nextFloat(), p_149734_5_.nextFloat() * 0.7F + 0.3F, false);
		}

		int l;
		float f;
		float f1;
		float f2;

		if (!World.doesBlockHaveSolidTopSurface(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && !Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_, UP))
		{
			if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_ - 1, p_149734_3_, p_149734_4_, EAST))
			{
				for (l = 0; l < 2; ++l)
				{
					f = (float)p_149734_2_ + p_149734_5_.nextFloat() * 0.1F;
					f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
					f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
					p_149734_1_.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_ + 1, p_149734_3_, p_149734_4_, WEST))
			{
				for (l = 0; l < 2; ++l)
				{
					f = (float)(p_149734_2_ + 1) - p_149734_5_.nextFloat() * 0.1F;
					f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
					f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
					p_149734_1_.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_ - 1, SOUTH))
			{
				for (l = 0; l < 2; ++l)
				{
					f = (float)p_149734_2_ + p_149734_5_.nextFloat();
					f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
					f2 = (float)p_149734_4_ + p_149734_5_.nextFloat() * 0.1F;
					p_149734_1_.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_ + 1, NORTH))
			{
				for (l = 0; l < 2; ++l)
				{
					f = (float)p_149734_2_ + p_149734_5_.nextFloat();
					f1 = (float)p_149734_3_ + p_149734_5_.nextFloat();
					f2 = (float)(p_149734_4_ + 1) - p_149734_5_.nextFloat() * 0.1F;
					p_149734_1_.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
				}
			}

			if (Blocks.fire.canCatchFire(p_149734_1_, p_149734_2_, p_149734_3_ + 1, p_149734_4_, DOWN))
			{
				for (l = 0; l < 2; ++l)
				{
					f = (float)p_149734_2_ + p_149734_5_.nextFloat();
					f1 = (float)(p_149734_3_ + 1) - p_149734_5_.nextFloat() * 0.1F;
					f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
					p_149734_1_.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
				}
			}
		}
		else
		{
			for (l = 0; l < 3; ++l)
			{
				f = (float)p_149734_2_ + p_149734_5_.nextFloat();
				f1 = (float)p_149734_3_ + p_149734_5_.nextFloat() * 0.5F + 0.5F;
				f2 = (float)p_149734_4_ + p_149734_5_.nextFloat();
				p_149734_1_.spawnParticle("largesmoke", (double)f, (double)f1, (double)f2, 0.0D, 0.0D, 0.0D);
			}
		}
	}
	
	public boolean isBurning(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
}