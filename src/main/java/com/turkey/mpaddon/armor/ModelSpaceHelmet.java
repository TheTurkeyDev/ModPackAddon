package com.turkey.mpaddon.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class ModelSpaceHelmet extends ModelBiped
{
	public static ModelSpaceHelmet modelHelm = new ModelSpaceHelmet();
	
	private ModelRenderer helmet;
	private ModelRenderer tank;
	private ModelRenderer pipeOne;
	private ModelRenderer pipeTwo;

	public ModelSpaceHelmet()
	{
		super(1.0F, 1.0F, 128, 64);
		
		textureWidth = 128;
		textureHeight = 64;

		helmet = new ModelRenderer(this, 0, 32);
		helmet.addBox(-5.0F, -10.0F, -5.0F, 10, 10, 10);
		helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotation(helmet, 0F, 0F, 0F);
		tank = new ModelRenderer(this, 40, 32);
		tank.addBox(0F, 0F, 0F, 6, 9, 3);
		tank.setRotationPoint(-3F, 2F, 2F);
		setRotation(tank, 0F, 0F, 0F);
		pipeOne = new ModelRenderer(this, 0, 52);
		pipeOne.addBox(0F, 0F, 0F, 1, 4, 1);
		pipeOne.setRotationPoint(1F, -1F, 3F);
		setRotation(pipeOne, 0F, 0F, 0F);
		pipeTwo = new ModelRenderer(this, 4, 52);
		pipeTwo.addBox(0F, 0F, 0F, 1, 4, 1);
		pipeTwo.setRotationPoint(-2F, -1F, 3F);
		setRotation(pipeTwo, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		helmet.render(f5);
		tank.render(f5);
		pipeOne.render(f5);
		pipeTwo.render(f5);
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
