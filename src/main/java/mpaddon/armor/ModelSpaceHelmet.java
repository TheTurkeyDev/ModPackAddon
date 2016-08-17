package mpaddon.armor;

import org.lwjgl.opengl.GL11;

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
	public static ModelSpaceHelmet modelHelm = new ModelSpaceHelmet(false);
	public static ModelSpaceHelmet pirateModelHelm = new ModelSpaceHelmet(true);

	private final ResourceLocation texture = new ResourceLocation(MPACore.MODID + ":models/armor/Space_Helmet.png");
	private final ResourceLocation texture2 = new ResourceLocation(MPACore.MODID + ":models/armor/Space_Helmet_Pirate.png");

	private ModelRenderer helmet;

	private boolean isPirateHelm = false;

	public ModelSpaceHelmet(boolean pirate)
	{
		super(1.0F, 0.0F, 128, 64);
		
		this.bipedBody.showModel = false;
        this.bipedRightArm.showModel = false;
        this.bipedLeftArm.showModel = false;
        this.bipedHead.showModel = true;
        this.bipedHeadwear.showModel = true;
        this.bipedRightLeg.showModel = false;
        this.bipedLeftLeg.showModel = false;
		
		isPirateHelm = pirate;

		helmet = new ModelRenderer(this, 0, 32);
		helmet.setTextureSize(128, 64);
		helmet.addBox(-5.0F, -10.0F, -5.0F, 10, 10, 10);
		helmet.setRotationPoint(0.0F, 0.0F, 0.0F);
		helmet.mirror = true;
		setRotation(helmet, 0F, 0F, 0F);
		
		this.bipedBody.addChild(helmet);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		Minecraft.getMinecraft().renderEngine.bindTexture(isPirateHelm ? texture2 : texture);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		helmet.render(f5);
		GL11.glDisable(GL11.GL_BLEND);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}
