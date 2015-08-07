package mpaddon.blocks;

import mpaddon.MPACore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UselessCoarsedDirt extends Block
{
	public UselessCoarsedDirt()
	{
		super(Material.rock);
		super.setBlockName("Useless_Coarsed_Dirt");
		super.setCreativeTab(MPACore.modTab);
		super.setBlockTextureName(MPACore.MODID + ":coarse_dirt");
		super.setStepSound(soundTypeGravel);
		super.setHardness(0.5f);
	}
}
