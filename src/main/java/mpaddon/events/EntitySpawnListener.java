package mpaddon.events;

import mpaddon.MPASettings;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntitySpawnListener
{
	@SubscribeEvent
	public void onEntitySpawn(LivingSpawnEvent e) 
	{
		long day = (e.world.getWorldInfo().getWorldTime() / 24000L) * 24000L;
		if(day < 1 && e.entity instanceof EntityMob)
		{
			e.setCanceled(true);
			return;
		}
		
		if(e.entity instanceof EntityWither)
		{
			((EntityWither)e.entity).setCustomNameTag("Devourer");
			((EntityWither)e.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(((EntityWither)e.entity).getMaxHealth() * MPASettings.witherHealthMultiplier);
			((EntityWither)e.entity).setHealth(((EntityWither)e.entity).getMaxHealth());
		}
	}
}
