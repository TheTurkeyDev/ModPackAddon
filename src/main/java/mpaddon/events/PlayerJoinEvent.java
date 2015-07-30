package mpaddon.events;

import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class PlayerJoinEvent
{
	boolean hasChecked = false;

	@SubscribeEvent
	public void onPlayerLogin(PlayerLoggedInEvent event)
	{
		event.player.addChatComponentMessage(new ChatComponentText("Notice! Aftermath collects anonymous gameplay stats for public display"));
		event.player.addChatComponentMessage(new ChatComponentText("These stats are available for viewing here:"));
		event.player.addChatComponentMessage(new ChatComponentText("http://theprogrammingturkey.com/AMStats.php"));
		event.player.addChatComponentMessage(new ChatComponentText("You can opout of these anonymous stats in the Modpack addon config"));
	}
}