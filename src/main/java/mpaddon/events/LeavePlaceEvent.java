package mpaddon.events;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class LeavePlaceEvent
{
	@SubscribeEvent
	public void placeEvent(PlayerInteractEvent e)
	{
		if(e.action.equals(Action.RIGHT_CLICK_BLOCK))
		{
			if(e.entityPlayer.inventory.getCurrentItem().getItem().equals(Item.getItemFromBlock(Blocks.leaves)) || e.entityPlayer.inventory.getCurrentItem().getItem().equals(Item.getItemFromBlock(Blocks.leaves2)))
			{
				boolean placed = false;
				if(e.face == 0)
				{
					e.world.setBlock(e.x, e.y - 1, e.z, Blocks.leaves);
					e.world.getBlock(e.x, e.y - 1, e.z).beginLeavesDecay(e.world, e.x, e.y - 1, e.z);
					placed = true;
				}
				else if(e.face == 1)
				{
					e.world.setBlock(e.x, e.y + 1, e.z, Blocks.leaves);
					e.world.getBlock(e.x, e.y + 1, e.z).beginLeavesDecay(e.world,e.x, e.y + 1, e.z);
					placed = true;
				}
				else if(e.face == 2)
				{
					e.world.setBlock(e.x + 1, e.y, e.z, Blocks.leaves);
					e.world.getBlock(e.x + 1, e.y, e.z).beginLeavesDecay(e.world, e.x + 1, e.y, e.z);
					placed = true;
				}
				else if(e.face == 3)
				{
					e.world.setBlock(e.x, e.y, e.z + 1, Blocks.leaves);
					e.world.getBlock(e.x, e.y, e.z + 1).beginLeavesDecay(e.world, e.x, e.y, e.z + 1);
					placed = true;
				}
				else if(e.face == 4)
				{
					e.world.setBlock(e.x - 1, e.y, e.z, Blocks.leaves);
					e.world.getBlock(e.x - 1, e.y, e.z).beginLeavesDecay(e.world, e.x - 1, e.y, e.z);
					placed = true;
				}
				else if(e.face == 5)
				{
					e.world.setBlock(e.x, e.y, e.z - 1, Blocks.leaves);
					e.world.getBlock(e.x, e.y, e.z - 1).beginLeavesDecay(e.world, e.x, e.y, e.z - 1);
					placed = true;
				}
				
				if(placed)
				{
					e.setCanceled(true);
				}
			}
		}
	}
}