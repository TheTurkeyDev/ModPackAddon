package mpaddon.events;

import mpaddon.MPASettings;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntitySpawnListener
{
	@SubscribeEvent
	public void onEntitySpawn(EntityJoinWorldEvent e)
	{
		long day = (e.world.getWorldInfo().getWorldTime() / 24000L) * 24000L;
		if(day < 1 && e.entity instanceof EntityMob)
		{
			if(e.isCancelable())
			{
				e.setCanceled(true);
				return;
			}
		}

		if(e.entity != null && e.entity instanceof EntitySnowman)
		{
			if(e.isCancelable())
			{
				e.setCanceled(true);
				return;
			}
		}

		if(e.entity instanceof EntityWither)
		{
			((EntityWither) e.entity).setCustomNameTag("Devourer");
			((EntityWither) e.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(((EntityWither) e.entity).getMaxHealth() * MPASettings.witherHealthMultiplier);
			((EntityWither) e.entity).setHealth(((EntityWither) e.entity).getMaxHealth() - 300);
		}

		if(e.entity instanceof EntityDragon)
		{
			((EntityDragon) e.entity).setCustomNameTag("Executioner");
			((EntityDragon) e.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(((EntityDragon) e.entity).getMaxHealth() * MPASettings.dragonHealthMultiplier);
			((EntityDragon) e.entity).setHealth(((EntityDragon) e.entity).getMaxHealth());
		}
	}
}
