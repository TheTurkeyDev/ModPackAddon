package mpaddon.events;

import mpaddon.util.DataBaseConnect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.google.gson.JsonObject;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerDeathListener
{
	@SubscribeEvent
	public void onBlockBreak(LivingDeathEvent e) 
	{
		if(e.entity instanceof EntityPlayer)
		{
			JsonObject json = new JsonObject();
			json.addProperty("Type", "Death");
			DataBaseConnect.sendMessage(json.toString());
		}
	}
}
