package mpaddon.armor;

import mpaddon.MPACore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelSpaceLeggings extends ModelBiped
{
	public static ModelSpaceLeggings modelLeggings = new ModelSpaceLeggings();

	private final ResourceLocation texture = new ResourceLocation(MPACore.MODID + ":models/armor/Space_Leggings.png");

	private ModelRenderer leftleg;
	private ModelRenderer rightleg;

	public ModelSpaceLeggings()
	{
		super(1.0F, 1.0F, 64, 32);
		textureWidth = 64;
		textureHeight = 32;

		leftleg = new ModelRenderer(this, 20, 16);
		leftleg.addBox(-2.5F, -0.5F, -2.5F, 5, 12, 5);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2.5F, -0.5F, -2.5F, 5, 12, 5);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);	
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leftleg.render(f5);
		rightleg.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		leftleg.rotateAngleX = super.bipedLeftLeg.rotateAngleX;
		leftleg.rotateAngleY = super.bipedLeftLeg.rotateAngleY;
		leftleg.rotateAngleZ = super.bipedLeftLeg.rotateAngleZ;
		
		rightleg.rotateAngleX = super.bipedRightLeg.rotateAngleX;
		rightleg.rotateAngleY = super.bipedRightLeg.rotateAngleY;
		rightleg.rotateAngleZ = super.bipedRightLeg.rotateAngleZ;
	}
}