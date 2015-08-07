package mpaddon.client.gui;

import mpaddon.blocks.containers.CrateContainer;
import mpaddon.blocks.tileEntities.CrateTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class MPAGuiHandler implements IGuiHandler
{
	public final static int CRATE_ID = 0;
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if (tileEntity != null)
		{
			switch (ID)
			{
			case CRATE_ID:
				if (tileEntity instanceof CrateTileEntity)
				{
					return new CrateGui(player.inventory, (CrateTileEntity) tileEntity, world);
				}
				break;
			default:
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if (tileEntity != null)
		{
			switch (ID)
			{
			case CRATE_ID:
				if (tileEntity instanceof CrateTileEntity)
				{
					return new CrateContainer(player.inventory, (CrateTileEntity) tileEntity);
				}
				break;
			default:
				return null;
			}
		}
		return null;
	}
}