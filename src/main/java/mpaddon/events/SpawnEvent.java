package mpaddon.events;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S05PacketSpawnPosition;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;

public class SpawnEvent
{
	private static int x = -6;
	private static int y = 28;
	private static int z = 11;

	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent e)
	{
		if(!(e.player instanceof EntityPlayerMP))
			return;
		if(e.player.getBedLocation(0) == null)
		{
			WorldServer worldserver = MinecraftServer.getServer().worldServerForDimension(0);
			worldserver.theChunkProviderServer.loadChunk((int) x >> 4, (int) z >> 4);
			ChunkCoordinates chunkcoordinates1 = worldserver.getSpawnPoint();
			((EntityPlayerMP) e.player).dimension = 0;
			((EntityPlayerMP) e.player).setPosition(x, y, z);
			((EntityPlayerMP) e.player).playerNetServerHandler.setPlayerLocation(x, y, z, e.player.rotationYaw, e.player.rotationPitch);
			((EntityPlayerMP) e.player).playerNetServerHandler.sendPacket(new S05PacketSpawnPosition(chunkcoordinates1.posX, chunkcoordinates1.posY, chunkcoordinates1.posZ));
		}
	}

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event)
	{
		if(event.entityLiving instanceof EntityPlayerMP)
		{
			if(event.entity.ticksExisted >= 1 && !event.entity.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getBoolean("AM_START"))
			{
				NBTTagCompound pTags = event.entity.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
				pTags.setBoolean("AM_START", true);
				event.entity.getEntityData().setTag(EntityPlayer.PERSISTED_NBT_TAG, pTags);
				((EntityPlayerMP) event.entityLiving).playerNetServerHandler.setPlayerLocation(x, y, z, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
				return;
			}
		}
	}
}
