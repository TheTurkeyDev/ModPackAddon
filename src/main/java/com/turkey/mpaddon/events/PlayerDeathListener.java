package com.turkey.mpaddon.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import com.google.gson.JsonObject;
import com.turkey.mpaddon.util.DataBaseConnect;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerDeathListener
{
	@SubscribeEvent
	public void onBlockBreak(LivingDeathEvent e) 
	{
		if(e.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) e.entity;
			JsonObject json = new JsonObject();
			json.addProperty("Type", "Death");
			json.addProperty("User", player.getCommandSenderName());
			DataBaseConnect.sendMessage(json.toString());
		}
	}
}
