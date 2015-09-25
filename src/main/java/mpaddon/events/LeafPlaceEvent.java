package mpaddon.events;

import mpaddon.blocks.MPABlocks;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LeafPlaceEvent
{
	@SubscribeEvent
	public void placeEvent(PlaceEvent e)
	{
		if(e.world.isRemote)
			return;

		if(e.player instanceof FakePlayer)
			return;
		
		if(e.placedBlock.equals(Blocks.leaves) || e.placedBlock.equals(Blocks.leaves2))
			e.world.setBlock(e.x, e.y, e.z, MPABlocks.leave);
	}
}