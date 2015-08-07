package mpaddon.armor;

import mpaddon.MPACore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelSpaceCombined extends ModelBiped
{
	public static ModelSpaceCombined modelCombined = new ModelSpaceCombined();

	private final ResourceLocation texture = new ResourceLocation(MPACore.MODID + ":models/armor/Space_Combined.png");

	private ModelRenderer helmet;

	private ModelRenderer mainPlate;
	private ModelRenderer leftArm;
	private ModelRenderer rightArm;
	private ModelRenderer airTank;

	public ModelSpaceCombined()
	{
		super(1.0F, 1.0F, 128, 32);

		textureWidth = 128;
		textureHeight = 32;

		mainPlate = new ModelRenderer(this, 18, 0);
		mainPlate.addBox(0F, 0F, 0F, 9, 12, 5);
		mainPlate.setRotationPoint(-4.5F, 0F, -2.533333F);
		setRotation(mainPlate, 0F, 0F, 0F);

		leftArm = new ModelRenderer(this, 0, 14);
		leftArm.addBox(-1.5F, -3.5F, -2.5F, 5, 13, 5);
		leftArm.setRotationPoint(5.0F, 3.0F, 0.0F);
		setRotation(leftArm, 0F, 0F, 0F);

		rightArm = new ModelRenderer(this, 44, 14);
		rightArm.addBox(-3.5F, -3.5F, -2.5F, 5, 13, 5);
		rightArm.setRotationPoint(-5.0F, 3.0F, 0.0F);
		setRotation(rightArm, 0F, 0F, 0F);

		airTank = new ModelRenderer(this, 23, 19);
		airTank.addBox(0F, 0F, 0F, 6, 10, 3);
		airTank.setRotationPoint(-3F, 1F, 2.5F);
		setRotation(airTank, 0F, 0F, 0F);
		
		helmet = new ModelRenderer(this, 64, 0);
		helmet.addBox(-5.0F, -10.0F, -5.0F, 10, 10, 10);
		helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		setRotation(helmet, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);	
		setRotationAngles(entity, f, f1, f2, f3, f4, f5);
		helmet.render(f5);
		mainPlate.render(f5);
		leftArm.render(f5);
		rightArm.render(f5);
		airTank.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		this.rightArm.rotateAngleX = this.bipedRightArm.rotateAngleX;
		this.rightArm.rotateAngleY = this.bipedRightArm.rotateAngleY;
		this.rightArm.rotateAngleZ = this.bipedRightArm.rotateAngleZ;

		this.leftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX;
		this.leftArm.rotateAngleY = this.bipedLeftArm.rotateAngleY;
		this.leftArm.rotateAngleZ = this.bipedLeftArm.rotateAngleZ;
		
		this.helmet.rotateAngleY = this.bipedHead.rotateAngleY;
		this.helmet.rotateAngleX = this.bipedHead.rotateAngleX;
	}

}
