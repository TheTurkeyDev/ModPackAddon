package mpaddon.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelSpaceChestplate extends ModelBiped
{
	public static ModelSpaceChestplate modelChest = new ModelSpaceChestplate();

	public ModelSpaceChestplate()
	{
		super(1.0F, 0.0F, 64, 64);
		
		this.bipedBody.showModel = true;
        this.bipedRightArm.showModel = true;
        this.bipedLeftArm.showModel = true;
        this.bipedHead.showModel = false;
        this.bipedHeadwear.showModel = false;
        this.bipedRightLeg.showModel = false;
        this.bipedLeftLeg.showModel = false;

        ModelRenderer mainPlate = new ModelRenderer(this, 18, 0);
        mainPlate.setTextureSize(64, 32);
		mainPlate.addBox(0F, 0F, 0F, 9, 12, 5);
		mainPlate.setRotationPoint(-4.5F, 0F, -2.533333F);
		mainPlate.mirror = true;
		setRotation(mainPlate, 0F, 0F, 0F);
		
		ModelRenderer leftArm = new ModelRenderer(this, 0, 14);
		leftArm.setTextureSize(64, 32);
		leftArm.addBox(-1.5F, -3.5F, -2.5F, 5, 13, 5);
		leftArm.setRotationPoint(5.0F, 3.0F, 0.0F);
		leftArm.mirror = true;
		setRotation(leftArm, 0F, 0F, 0F);
		
		ModelRenderer rightArm = new ModelRenderer(this, 44, 14);
		rightArm.setTextureSize(64, 32);
		rightArm.addBox(-3.5F, -3.5F, -2.5F, 5, 13, 5);
		rightArm.setRotationPoint(-5.0F, 3.0F, 0.0F);
		rightArm.mirror = true;
		setRotation(rightArm, 0F, 0F, 0F);
		
		ModelRenderer airTank = new ModelRenderer(this, 23, 19);
		airTank.setTextureSize(64, 32);
		airTank.addBox(0F, 0F, 0F, 6, 10, 3);
		airTank.setRotationPoint(-3F, 1F, 2.5F);
		airTank.mirror = true;
		setRotation(airTank, 0F, 0F, 0F);
		
		this.bipedBody.addChild(mainPlate);
		this.bipedBody.addChild(leftArm);
		this.bipedBody.addChild(rightArm);
		this.bipedBody.addChild(airTank);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}