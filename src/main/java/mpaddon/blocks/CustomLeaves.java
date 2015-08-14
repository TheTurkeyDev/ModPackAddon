package mpaddon.blocks;

import java.util.Random;

import mpaddon.MPACore;
import mpaddon.MPASettings;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class CustomLeaves extends Block
{

	public CustomLeaves()
	{
		super(Material.ground);
		super.setBlockName("Leave_Block");
		super.setBlockTextureName(MPACore.MODID + ":leaves");
		super.setCreativeTab(MPACore.modTab);
		super.setStepSound(soundTypeGrass);
		super.setTickRandomly(true);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if(meta >= MPASettings.randomleafDelay)
			world.setBlock(x, y, z, MPABlocks.deadLeave);
		else
			world.setBlockMetadataWithNotify(x, y, z, meta + 1, 3);
	}
}