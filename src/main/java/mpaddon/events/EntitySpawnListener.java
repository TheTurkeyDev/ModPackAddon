package mpaddon.events;

import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntitySpawnListener
{
	@SubscribeEvent
	public void onlogin(LivingSpawnEvent e) 
	{
		long day = (e.world.getWorldInfo().getWorldTime() / 24000L) * 24000L;
		if(day < 1 && e.entity instanceof EntityMob)
		{
			e.setCanceled(true);
		}
	}
}
