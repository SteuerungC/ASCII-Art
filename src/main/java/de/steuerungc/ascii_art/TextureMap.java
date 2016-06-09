package de.steuerungc.ascii_art;

import java.util.HashMap;
import java.util.Map;

public class TextureMap {

    private static Map<Float, Character> textures;

    public static void setTextureMap() {
        textures = new HashMap<>();

        textures.put(0f,   '@');
        textures.put(0.2f, '#');
        textures.put(0.4f, '&');
        textures.put(0.6f, '%');
        textures.put(0.8f, '+');
        textures.put(1f,   ' ');
    }

    public static char getTexture(float grey) {
        if (grey < 0.2f)                      return textures.get(0f);
        else if (grey >= 0.2f && grey < 0.4f) return textures.get(0.2f);
        else if (grey >= 0.4f && grey < 0.6f) return textures.get(0.4f);
        else if (grey >= 0.6f && grey < 0.8f) return textures.get(0.6f);
        else if (grey >= 0.8f && grey < 1f)   return textures.get(0.8f);
        else                                  return textures.get(1f);
    }
}
