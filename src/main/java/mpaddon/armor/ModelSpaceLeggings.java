package mpaddon.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;

public class ModelSpaceLeggings extends ModelBiped
{
	public static ModelSpaceLeggings modelLeggings = new ModelSpaceLeggings();

	public ModelSpaceLeggings()
	{
		super(1.0F, 0.0F, 64, 32);
		
		this.bipedBody.showModel = false;
        this.bipedRightArm.showModel = false;
        this.bipedLeftArm.showModel = false;
        this.bipedHead.showModel = false;
        this.bipedHeadwear.showModel = false;
        this.bipedRightLeg.showModel = true;
        this.bipedLeftLeg.showModel = true;

        ModelRenderer leftleg = new ModelRenderer(this, 20, 16);
		leftleg.setTextureSize(64, 32);
		leftleg.addBox(-2.5F, -0.5F, -2.5F, 5, 12, 5);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		
		ModelRenderer rightleg = new ModelRenderer(this, 0, 16);
		rightleg.setTextureSize(64, 32);
		rightleg.addBox(-2.5F, -0.5F, -2.5F, 5, 12, 5);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		
		this.bipedBody.addChild(leftleg);
		this.bipedBody.addChild(rightleg);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}