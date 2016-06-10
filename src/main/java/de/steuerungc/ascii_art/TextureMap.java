package de.steuerungc.ascii_art;

import java.util.HashMap;
import java.util.Map;

public class TextureMap {

    private static Map<Float, Character> textures;

    public static void setTextureMap() {
        textures = new HashMap<>();

        textures.put(0f,   '@');
        textures.put(0.1f, '#');
        textures.put(0.2f, '&');
        textures.put(0.3f, '$');
        textures.put(0.4f, '%');
        textures.put(0.5f, '+');
        textures.put(0.6f, '*');
        textures.put(0.7f, '|');
        textures.put(0.8f, '.');
        textures.put(1f,   ' ');
    }

    public static char getTexture(float grey, boolean inverted) {

        if (!inverted) {
            grey = 1f - grey;
        }

        if (grey < 0.1f)                       return textures.get(0f);
        else if (grey >= 0.1f && grey < 0.2f)  return textures.get(0.1f);
        else if (grey >= 0.2f && grey < 0.3f)  return textures.get(0.2f);
        else if (grey >= 0.3f && grey < 0.4f)  return textures.get(0.3f);
        else if (grey >= 0.4f && grey < 0.5f)  return textures.get(0.4f);
        else if (grey >= 0.5f && grey < 0.6f)  return textures.get(0.5f);
        else if (grey >= 0.6f && grey < 0.7f)  return textures.get(0.6f);
        else if (grey >= 0.7f && grey < 0.8f)  return textures.get(0.7f);
        else if (grey >= 0.8f && grey < 0.9f)  return textures.get(0.8f);
        else                                   return textures.get(1f);
    }
}
