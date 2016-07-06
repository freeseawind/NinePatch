package freeseawind.ninepatch.javafx;

import java.nio.IntBuffer;

import freeseawind.ninepatch.common.AbstractNinePatch;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;

/**
 *
 * @author freeseawind@github
 *
 */
public class FxNinePatch extends AbstractNinePatch<Image, GraphicsContext>
{
    public FxNinePatch(Image image)
    {
        super(image);
    }


    @Override
    public int[] getPixels(Image img, int x, int y, int w, int h)
    {
        int[] pixels = new int[w * h];

        PixelReader reader = img.getPixelReader();

        PixelFormat.Type type =  reader.getPixelFormat().getType();

        WritablePixelFormat<IntBuffer> format = null;

        if(type == PixelFormat.Type.INT_ARGB_PRE)
        {
            format = PixelFormat.getIntArgbPreInstance();
        }
        else
        {
            format = PixelFormat.getIntArgbInstance();
        }

        reader.getPixels(x, y, w, h, format, pixels, 0, w);

        return pixels;
    }

    @Override
    public int getImageWidth(Image img)
    {
        return img.widthProperty().intValue();
    }

    @Override
    public int getImageHeight(Image img)
    {
        return img.heightProperty().intValue();
    }

    @Override
    public void translate(GraphicsContext g2d, int x, int y)
    {
        g2d.translate(x, y);
    }


    @Override
    public void drawImage(GraphicsContext g2d,
                          Image image,
                          int x,
                          int y,
                          int scaledWidth,
                          int scaledHeight)
    {
        g2d.drawImage(image, x, y, scaledWidth, scaledHeight);
    }


    @Override
    public void drawImage(GraphicsContext g2d,
                          Image image,
                          int sx,
                          int sy,
                          int sw,
                          int sh,
                          int dx,
                          int dy,
                          int dw,
                          int dh)
    {
        g2d.drawImage(image, sx, sy, sw, sh, dx, dy, dw, dh);
    }
}
