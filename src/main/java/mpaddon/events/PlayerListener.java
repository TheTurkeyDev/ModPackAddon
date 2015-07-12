package mpaddon.events;

import mpaddon.MPACore;
import mpaddon.util.DataBaseConnect;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.event.entity.player.PlayerEvent;

import com.google.gson.JsonObject;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerListener
{
	public static long time;

	@SubscribeEvent
	public void onlogin(PlayerEvent.LoadFromFile e) 
	{
		JsonObject json = new JsonObject();
		json.addProperty("Type", "World_Joins");
		if(MPACore.proxy.isClient())
		{
			json.addProperty("User", e.playerUUID);
			time = System.currentTimeMillis();
		}
		else
			json.addProperty("User", "Server");
		DataBaseConnect.sendMessage(json.toString());
	}

	@SubscribeEvent
	public void onlogout(PlayerEvent.SaveToFile e)
	{
		if(MinecraftServer.getServer().isServerRunning())
			return;
		JsonObject json = new JsonObject();
		json.addProperty("Type", "TimePlayer");
		if(MPACore.proxy.isClient())
		{
			json.addProperty("User", e.playerUUID);
			long elapsed = System.currentTimeMillis()-time;
			int h = (int) (elapsed / (60*60*1000));
			elapsed = elapsed - h*(60*60*1000);
			int m = (int) (elapsed / (60*1000));
			elapsed = elapsed - m*(60*1000);
			int s = (int) (elapsed / 1000);
			elapsed = elapsed - s*1000;
			
			String hr = h<10 ? "0"+h : ""+h;
			String min = m<10 ? "0"+m : ""+m;
			String sec = s<10 ? "0"+s : ""+s;
			
			json.addProperty("Time", hr + ":" + min + ":" + sec);
		}
		else
			json.addProperty("User", "Server");
		DataBaseConnect.sendMessage(json.toString());
	}
}