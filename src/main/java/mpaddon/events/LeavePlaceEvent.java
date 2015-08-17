package mpaddon.events;

import mpaddon.blocks.MPABlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LeavePlaceEvent
{
	@SubscribeEvent
	public void placeEvent(PlayerInteractEvent e)
	{
		if(e.world.isRemote)
			return;
		if(e.getResult() != Result.DENY && e.action.equals(Action.RIGHT_CLICK_BLOCK) && e.entityPlayer.inventory.getCurrentItem() != null)
		{
			if(e.entityPlayer.inventory.getCurrentItem().getItem().equals(Item.getItemFromBlock(Blocks.leaves)) || e.entityPlayer.inventory.getCurrentItem().getItem().equals(Item.getItemFromBlock(Blocks.leaves2)))
			{
				Block block = e.world.getBlock(e.x, e.y, e.z);
				boolean placed = false;
				if(block.onBlockActivated(e.world, e.x, e.y, e.y, e.entityPlayer, e.face, 0F, 0F, 0F))
				{
					e.useItem = Result.DENY;
					e.useBlock = Result.ALLOW;
				}
				else
				{
					e.useItem = Result.ALLOW;

					if(e.face == 0)
					{
						e.world.setBlock(e.x, e.y - 1, e.z, MPABlocks.leave);
						placed = true;
					}
					else if(e.face == 1)
					{
						e.world.setBlock(e.x, e.y + 1, e.z, MPABlocks.leave);
						placed = true;
					}
					else if(e.face == 2)
					{
						e.world.setBlock(e.x, e.y, e.z - 1, MPABlocks.leave);
						placed = true;
					}
					else if(e.face == 3)
					{
						e.world.setBlock(e.x, e.y, e.z + 1, MPABlocks.leave);
						placed = true;
					}
					else if(e.face == 4)
					{
						e.world.setBlock(e.x - 1, e.y, e.z, MPABlocks.leave);
						placed = true;
					}
					else if(e.face == 5)
					{
						e.world.setBlock(e.x + 1, e.y, e.z, MPABlocks.leave);
						placed = true;
					}

					if(placed)
					{
						e.setCanceled(true);
						e.entityPlayer.inventory.getCurrentItem().stackSize--;
					}
				}
			}
		}
	}
}