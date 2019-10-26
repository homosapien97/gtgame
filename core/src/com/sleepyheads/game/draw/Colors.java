package com.sleepyheads.game.draw;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Colors {
    public static Texture BLUE = new Texture(new FileHandle("textures/colors/blue.jpg"));
    public static final HashMap<Color, Texture> COLORS = new HashMap<>();
    static {
        COLORS.put(Color.BLUE, BLUE);
    }
}
