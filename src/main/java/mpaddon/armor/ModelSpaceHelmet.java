package mpaddon.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mpaddon.MPACore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class ModelSpaceHelmet extends ModelBiped
{
	public static ModelSpaceHelmet modelHelm = new ModelSpaceHelmet();
	
	private final ResourceLocation texture = new ResourceLocation(MPACore.MODID + ":models/armor/Space_Helmet.png");
	
	private ModelRenderer helmet;

	public ModelSpaceHelmet()
	{
		super(1.0F, 1.0F, 128, 64);
		
		textureWidth = 128;
		textureHeight = 64;

		helmet = new ModelRenderer(this, 0, 32);
		helmet.addBox(-5.0F, -10.0F, -5.0F, 10, 10, 10);
		helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotation(helmet, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);	
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		helmet.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity ent)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, ent);
		
		this.helmet.rotateAngleY = this.bipedHead.rotateAngleY;
		this.helmet.rotateAngleX = this.bipedHead.rotateAngleX;
	}
}
