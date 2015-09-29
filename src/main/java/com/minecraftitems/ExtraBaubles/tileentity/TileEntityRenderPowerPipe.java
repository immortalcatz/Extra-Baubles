package com.minecraftitems.ExtraBaubles.tileentity;

import com.minecraftitems.ExtraBaubles.reference.Reference;
import com.minecraftitems.ExtraBaubles.utility.Log;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileEntityRenderPowerPipe extends TileEntitySpecialRenderer {

    ResourceLocation texture = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/blocks/PowerPipe.png");
    float pixel = 1f/16f;
    float TexturePixel = 1f/32f;
    boolean drawInside = true;

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double translationX, double translationY, double translationZ, float f)
    {
        GL11.glTranslated(translationX, translationY, translationZ);
        GL11.glDisable(GL11.GL_LIGHTING);
        this.bindTexture(texture);
        DrawCore(tileEntity);
        DrawConnector(ForgeDirection.UP);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glTranslated(-translationX, -translationY, -translationZ);
    }

    public void DrawConnector(ForgeDirection direction)
    {
        if (direction.equals(ForgeDirection.UP))
        {
            //ROTATE
        }

        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        {
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 10 * TexturePixel, 5 * TexturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1, 1-11 * pixel / 2, 10 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1, 1-11 * pixel / 2, 5 * TexturePixel, 10 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1-11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);
        }
        tessellator.draw();
    }

    public void DrawCore(TileEntity tileEntity)
    {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        {
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);

            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(1-11 * pixel / 2, 1 - 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(1-11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);

            tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);

            tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);

            tessellator.addVertexWithUV(1-11 * pixel / 2, 1-11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);
            tessellator.addVertexWithUV(1-11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 1-11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);

            tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);
            tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(1-11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
            tessellator.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);

            if (drawInside)
            {
                tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);

                tessellator.addVertexWithUV(1-11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);
                tessellator.addVertexWithUV(1-11 * pixel / 2, 1 - 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);

                tessellator.addVertexWithUV(1 - 11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);
                tessellator.addVertexWithUV(1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);

                tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);

                tessellator.addVertexWithUV(11 * pixel / 2, 1-11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(1-11 * pixel / 2, 1 - 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(1-11 * pixel / 2, 1-11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);

                tessellator.addVertexWithUV(1-11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 0 * TexturePixel, 5 * TexturePixel);
                tessellator.addVertexWithUV(1-11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 0 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 5 * TexturePixel, 0 * TexturePixel);
                tessellator.addVertexWithUV(11 * pixel / 2, 11 * pixel / 2, 1-11 * pixel / 2, 5 * TexturePixel, 5 * TexturePixel);

            }
        }
        tessellator.draw();
    }
}
