package mpaddon.blocks;

import mpaddon.MPACore;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CustomDeadLeaves extends Block
{

	public CustomDeadLeaves()
	{
		super(Material.ground);
		super.setBlockName("Dead_Leave_Block");
		super.setBlockTextureName(MPACore.MODID + ":dead_leaves");
		super.setCreativeTab(MPACore.modTab);
		super.setStepSound(soundTypeGrass);
	}
}
