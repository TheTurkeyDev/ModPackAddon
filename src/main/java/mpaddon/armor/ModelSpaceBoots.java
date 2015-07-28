package mpaddon.armor;

import mpaddon.MPACore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelSpaceBoots extends ModelBiped
{
	public static ModelSpaceBoots modelBoots = new ModelSpaceBoots();

	private final ResourceLocation texture = new ResourceLocation(MPACore.MODID + ":models/armor/Space_Boots.png");

	private ModelRenderer leftboot;
	private ModelRenderer rightboot;

	public ModelSpaceBoots()
	{
		super(1.0F, 1.0F, 64, 32);

		textureWidth = 64;
		textureHeight = 32;

		leftboot = new ModelRenderer(this, 20, 16);
		leftboot.addBox(-2.5F, 8F, -2.5F, 5, 4, 5);
		leftboot.setRotationPoint(2F, 12F, 0F);
		leftboot.setTextureSize(64, 32);
		leftboot.mirror = true;
		setRotation(leftboot, 0F, 0F, 0F);

		rightboot = new ModelRenderer(this, 0, 16);
		rightboot.addBox(-2.5F, 8F, -2.5F, 5, 4, 5);
		rightboot.setRotationPoint(-2F, 12F, 0F);
		rightboot.setTextureSize(64, 32);
		rightboot.mirror = true;
		setRotation(rightboot, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);	
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leftboot.render(f5);
		rightboot.render(f5);
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
		
		leftboot.rotateAngleX = super.bipedLeftLeg.rotateAngleX;
		leftboot.rotateAngleY = super.bipedLeftLeg.rotateAngleY;
		leftboot.rotateAngleZ = super.bipedLeftLeg.rotateAngleZ;
		
		rightboot.rotateAngleX = super.bipedRightLeg.rotateAngleX;
		rightboot.rotateAngleY = super.bipedRightLeg.rotateAngleY;
		rightboot.rotateAngleZ = super.bipedRightLeg.rotateAngleZ;
	}

}
