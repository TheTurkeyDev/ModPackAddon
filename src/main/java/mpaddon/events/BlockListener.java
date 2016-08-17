package mpaddon.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import minechem.MinechemItemsRegistration;
import mpaddon.blocks.MPABlocks;
import mpaddon.tools.MPATools;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class BlockListener
{
	@SubscribeEvent
	public void onBlockBreak(BreakEvent e)
	{
		if(!e.world.isRemote)
		{
			Block b = e.block;

			if(b == Blocks.stained_hardened_clay || b == Blocks.hardened_clay)
			{
				if(e.getPlayer().inventory.getCurrentItem() == null || e.getPlayer().inventory.getCurrentItem().getItem().equals(MPATools.claySmash) || e.getPlayer().inventory.getCurrentItem().getItem() instanceof ItemPickaxe || !(e.getPlayer().inventory.getCurrentItem().getItem() instanceof ItemTool))
				{
					e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(b, 1, e.blockMetadata)));
				}
			}
			else if(b == Blocks.ice || b == Blocks.packed_ice)
			{
				if(e.getPlayer().inventory.getCurrentItem() != null && (e.getPlayer().inventory.getCurrentItem().getItem().equals(MPATools.iceSmash) || e.getPlayer().inventory.getCurrentItem().getItem().equals(MinechemItemsRegistration.polytool)))
				{
					e.world.spawnEntityInWorld(new EntityItem(e.world, e.x, e.y, e.z, new ItemStack(b, 1, e.blockMetadata)));
					e.world.setBlockToAir(e.x, e.y, e.z);
					e.getPlayer().inventory.getCurrentItem().damageItem(1, e.getPlayer());
				}
			}
		}
	}

	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent e)
	{
		if(!e.world.isRemote && e.harvester != null)
		{
			Block b = e.block;

			if(e.harvester.inventory.getCurrentItem() == null || e.harvester.inventory.getCurrentItem().getItem().equals(MPATools.claySmash) || e.harvester.inventory.getCurrentItem().getItem() instanceof ItemPickaxe || !(e.harvester.inventory.getCurrentItem().getItem() instanceof ItemTool))
			{
				if(b == Blocks.stained_hardened_clay || b == Blocks.hardened_clay)
				{
					e.drops.clear();
				}
			}
		}
	}

	@SubscribeEvent
	public void onPlayerInteract(PlayerInteractEvent e)
	{
		if(e.world.getBlock(e.x, e.y + 1, e.z).equals(MPABlocks.foreverFire))
		{
			e.world.setBlockToAir(e.x, e.y + 1, e.z);
			e.setCanceled(true);
		}
	}
}