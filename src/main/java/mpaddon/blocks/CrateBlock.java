package mpaddon.blocks;

import mpaddon.MPACore;
import mpaddon.blocks.tileEntities.CrateTileEntity;
import mpaddon.client.gui.MPAGuiHandler;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class CrateBlock extends BlockContainer
{
	protected CrateBlock()
	{
		super(Material.ground);
		super.setBlockName("Crate");
		super.setBlockTextureName(MPACore.MODID + ":crate");
		super.setCreativeTab(MPACore.modTab);
		super.setHardness(2);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new CrateTileEntity();
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(world.isRemote || player.isSneaking())
			return false;
		else
			FMLNetworkHandler.openGui(player, MPACore.instance, MPAGuiHandler.CRATE_ID, world, x, y, z);
		return true;
	}

}
