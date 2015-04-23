package com.turkey.mpaddon.events;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import pneumaticCraft.common.block.Blockss;

import com.turkey.mpaddon.blocks.MPABlocks;
import com.turkey.mpaddon.tools.MPATools;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import crazypants.enderio.fluid.BlockFluidEio;

public class BlockListener
{
	@SubscribeEvent
	public void onBlockBreak(BreakEvent e) 
	{
		if (!e.world.isRemote)
		{
			Block b = e.block;

			if (b == Blocks.stained_hardened_clay || b == Blocks.hardened_clay) 
			{
				if(e.getPlayer().inventory.getCurrentItem() == null || e.getPlayer().inventory.getCurrentItem().getItem().equals(MPATools.claySmash) || e.getPlayer().inventory.getCurrentItem().getItem() instanceof ItemPickaxe || !(e.getPlayer().inventory.getCurrentItem().getItem() instanceof ItemTool))
				{
					e.world.spawnEntityInWorld(new EntityItem(e.world,e.x,e.y,e.z,new ItemStack(b,1,e.blockMetadata)));
				}
			}
			else if (b == Blocks.ice || b == Blocks.packed_ice) 
			{
				if(e.getPlayer().inventory.getCurrentItem() != null && e.getPlayer().inventory.getCurrentItem().getItem().equals(MPATools.iceSmash))
				{
					e.world.spawnEntityInWorld(new EntityItem(e.world,e.x,e.y,e.z,new ItemStack(b,1,e.blockMetadata)));
					e.world.setBlockToAir(e.x, e.y, e.z);
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent e) 
	{
		if (!e.world.isRemote && e.harvester != null)
		{
			Block b = e.block;

			if(e.harvester.inventory.getCurrentItem() == null || e.harvester.inventory.getCurrentItem().getItem().equals(MPATools.claySmash) || e.harvester.inventory.getCurrentItem().getItem() instanceof ItemPickaxe|| !(e.harvester.inventory.getCurrentItem().getItem() instanceof ItemTool))
			{
				if (b == Blocks.stained_hardened_clay || b == Blocks.hardened_clay) 
				{
					e.drops.clear();
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent e) 
	{
		if(e.world.getBlock(e.x, e.y+1, e.z).equals(MPABlocks.foreverFire))
		{
			e.world.setBlockToAir(e.x, e.y+1, e.z);
			e.setCanceled(true);
		}
		else if(e.entityPlayer.inventory.getCurrentItem() != null && e.entityPlayer.inventory.getCurrentItem().getItem().equals(Items.glass_bottle))
		{
			MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(e.world, e.entityPlayer, true);
			if (movingobjectposition == null)
	            return;
	        else
	        {
	        	ItemStack stack = e.entityPlayer.inventory.getCurrentItem();
	        	World world = e.world;
	        	EntityPlayer player = e.entityPlayer;
	            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
	            {
	                int i = movingobjectposition.blockX;
	                int j = movingobjectposition.blockY;
	                int k = movingobjectposition.blockZ;

	                if (!world.canMineBlock(player, i, j, k))
	                    return;
	                if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack))
	                    return;

	                if ((world.getBlock(i, j, k) == Blockss.etchingAcid) || (world.getBlock(i, j, k) instanceof BlockFluidEio))
	                   e.setCanceled(true);
	            }
	        }
		}
	}

	private MovingObjectPosition getMovingObjectPositionFromPlayer(World p_77621_1_, EntityPlayer p_77621_2_, boolean p_77621_3_)
	{
		float f = 1.0F;
		float f1 = p_77621_2_.prevRotationPitch + (p_77621_2_.rotationPitch - p_77621_2_.prevRotationPitch) * f;
		float f2 = p_77621_2_.prevRotationYaw + (p_77621_2_.rotationYaw - p_77621_2_.prevRotationYaw) * f;
		double d0 = p_77621_2_.prevPosX + (p_77621_2_.posX - p_77621_2_.prevPosX) * (double)f;
		double d1 = p_77621_2_.prevPosY + (p_77621_2_.posY - p_77621_2_.prevPosY) * (double)f + (double)(p_77621_1_.isRemote ? p_77621_2_.getEyeHeight() - p_77621_2_.getDefaultEyeHeight() : p_77621_2_.getEyeHeight()); // isRemote check to revert changes to ray trace position due to adding the eye height clientside and player yOffset differences
		double d2 = p_77621_2_.prevPosZ + (p_77621_2_.posZ - p_77621_2_.prevPosZ) * (double)f;
		Vec3 vec3 = Vec3.createVectorHelper(d0, d1, d2);
		float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
		float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
		float f5 = -MathHelper.cos(-f1 * 0.017453292F);
		float f6 = MathHelper.sin(-f1 * 0.017453292F);
		float f7 = f4 * f5;
		float f8 = f3 * f5;
		double d3 = 5.0D;
		if (p_77621_2_ instanceof EntityPlayerMP)
		{
			d3 = ((EntityPlayerMP)p_77621_2_).theItemInWorldManager.getBlockReachDistance();
		}
		Vec3 vec31 = vec3.addVector((double)f7 * d3, (double)f6 * d3, (double)f8 * d3);
		return p_77621_1_.func_147447_a(vec3, vec31, p_77621_3_, !p_77621_3_, false);
	}
}