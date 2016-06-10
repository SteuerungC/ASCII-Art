package de.steuerungc.ascii_art;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Worker {

    public static String build(BufferedImage bfi) throws IOException {
        TextureMap.setTextureMap();
        String line = "";

        for (int y = 0; y < bfi.getHeight(); y++) {

            for (int x = 0; x < bfi.getWidth(); x++) {

                int color = bfi.getRGB(x, y);

                int r = (color >>> 16) & 0xFF;
                int g = (color >>>  8) & 0xFF;
                int b = 0xFF;

                float grey = (r * 0.2126f + g * 0.7152f + b * 0.0722f) / 255;
                line += TextureMap.getTexture(grey);
                line += " ";
            }

            line += "\n";
        }
        return line;
    }

    public static BufferedImage render(String text, int height, int width) throws IOException {

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.setFont(new Font("Monospaced", Font.PLAIN, 12));

        int x = 20,  y = 17;

        for (String s : text.split("\n")) {
            g.drawString(s, x, y);
            y += 17;
        }

        return bufferedImage;

    }
}
