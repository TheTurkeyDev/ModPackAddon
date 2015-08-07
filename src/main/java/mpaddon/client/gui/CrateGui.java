package mpaddon.client.gui;

import mpaddon.MPACore;
import mpaddon.blocks.containers.CrateContainer;
import mpaddon.blocks.tileEntities.CrateTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class CrateGui extends GuiContainer
{

	public static ResourceLocation texture = new ResourceLocation(MPACore.MODID + ":textures/gui/GuiCrate.png");

	public CrateGui(InventoryPlayer inventory, CrateTileEntity tileEntity, World world)
	{
		super(new CrateContainer(inventory, tileEntity));
		this.xSize = 256;
		this.ySize = 256;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
	{
		this.fontRendererObj.drawString("Crate", 8, 6, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}
}