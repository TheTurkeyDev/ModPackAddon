package mpaddon.item;

import mpaddon.MPACore;
import net.minecraft.item.Item;

public class PieceOfDirt extends Item
{

	public PieceOfDirt()
	{
		super.setCreativeTab(MPACore.modTab);
		super.setTextureName(MPACore.MODID + ":piece_of_dirt");
		super.setUnlocalizedName("Piece_of_dirt");
	}
}
