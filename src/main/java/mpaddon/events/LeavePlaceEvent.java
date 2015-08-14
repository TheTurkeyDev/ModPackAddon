package mpaddon.events;

import mpaddon.blocks.MPABlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LeavePlaceEvent
{
	@SubscribeEvent
	public void placeEvent(PlayerInteractEvent e)
	{
		if(e.world.isRemote)
			return;
		if(e.action.equals(Action.RIGHT_CLICK_BLOCK))
		{
			if(e.entityPlayer.inventory.getCurrentItem() == null)
				return;
			if(e.entityPlayer.inventory.getCurrentItem().getItem().equals(Item.getItemFromBlock(Blocks.leaves)) || e.entityPlayer.inventory.getCurrentItem().getItem().equals(Item.getItemFromBlock(Blocks.leaves2)))
			{
				boolean placed = false;
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