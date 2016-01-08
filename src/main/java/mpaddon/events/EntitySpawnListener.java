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
		if(e.entity != null && e.entity instanceof EntitySnowman)
		{
			if(e.isCancelable())
			{
				e.setCanceled(true);
				return;
			}
		}

		if(!e.entity.getEntityData().hasKey("HealthMultiplied"))
		{
			if(!e.entity.getEntityData().getBoolean("HealthMultiplied"))
			{
				if(e.entity instanceof EntityWither)
				{
					((EntityWither) e.entity).setCustomNameTag("Devourer");
					double health = ((EntityWither) e.entity).getMaxHealth() * MPASettings.witherHealthMultiplier;
					((EntityWither) e.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(health > Integer.MAX_VALUE ? Integer.MAX_VALUE : health);
					((EntityWither) e.entity).setHealth((float) (health > Integer.MAX_VALUE ? Integer.MAX_VALUE - 300 : health - 300));
					e.entity.getEntityData().setBoolean("HealthMultiplied", true);
				}

				if(e.entity instanceof EntityDragon)
				{
					((EntityDragon) e.entity).setCustomNameTag("Executioner");
					double health = ((EntityDragon) e.entity).getMaxHealth() * MPASettings.dragonHealthMultiplier;
					((EntityDragon) e.entity).getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(health > Integer.MAX_VALUE ? Integer.MAX_VALUE : health);
					((EntityDragon) e.entity).setHealth((float) (health > Integer.MAX_VALUE ? Integer.MAX_VALUE : health));
					e.entity.getEntityData().setBoolean("HealthMultiplied", true);
				}
			}
		}

		long day = (e.world.getWorldInfo().getWorldTime() / 24000L) * 24000L;
		if(day < 1 && e.entity instanceof EntityMob)
		{
			if(e.isCancelable())
			{
				e.setCanceled(true);
				return;
			}
		}
	}
}
