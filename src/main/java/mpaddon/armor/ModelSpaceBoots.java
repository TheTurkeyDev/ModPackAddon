package mpaddon.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelSpaceBoots extends ModelBiped
{
	public static ModelSpaceBoots modelBoots = new ModelSpaceBoots();

	public ModelSpaceBoots()
	{
		super(1.0F, 0.0F, 64, 32);
		
		this.bipedBody.showModel = false;
        this.bipedRightArm.showModel = false;
        this.bipedLeftArm.showModel = false;
        this.bipedHead.showModel = false;
        this.bipedHeadwear.showModel = false;
        this.bipedRightLeg.showModel = true;
        this.bipedLeftLeg.showModel = true;

        ModelRenderer leftboot = new ModelRenderer(this, 20, 16);
        leftboot.setTextureSize(64, 32);
		leftboot.addBox(-2.5F, 8F, -2.5F, 5, 4, 5);
		leftboot.setRotationPoint(2F, 12F, 0F);
		leftboot.mirror = true;
		setRotation(leftboot, 0F, 0F, 0F);

		ModelRenderer rightboot = new ModelRenderer(this, 0, 16);
		rightboot.setTextureSize(64, 32);
		rightboot.addBox(-2.5F, 8F, -2.5F, 5, 4, 5);
		rightboot.setRotationPoint(-2F, 12F, 0F);
		rightboot.mirror = true;
		setRotation(rightboot, 0F, 0F, 0F);
		
		this.bipedBody.addChild(leftboot);
		this.bipedBody.addChild(rightboot);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
