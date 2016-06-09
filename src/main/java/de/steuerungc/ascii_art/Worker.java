package de.steuerungc.ascii_art;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Worker {

    public Worker(File picture, String target) throws IOException {
        BufferedImage bfi = ImageIO.read(picture);
        TextureMap.setTextureMap();

        for (int y = 0; y < bfi.getHeight(); y++) {

            String line = "";
            for (int x = 0; x < bfi.getWidth(); x++) {

                int color = bfi.getRGB(x, y);

                int r = (color >>> 16) & 0xFF;
                int g = (color >>>  8) & 0xFF;
                int b = 0xFF;

                float grey = (r * 0.2126f + g * 0.7152f + b * 0.0722f) / 255;
                line += TextureMap.getTexture(grey);
                line += " ";
            }

            System.out.println(line);
        }
    }
}
