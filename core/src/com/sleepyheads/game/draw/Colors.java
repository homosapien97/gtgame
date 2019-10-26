package com.sleepyheads.game.draw;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;

public class Colors {
    //public static Texture BLUE = new Texture(new FileHandle("textures/colors/blue.jpg"));
    //public static Texture RED = new Texture(new FileHandle("textures/colors/red.jpg"));
    public static Texture BLACK = new Texture(new FileHandle("textures/colors/black.jpg"));
    public static final HashMap<Color, Texture> COLORS = new HashMap<>();
    static {
        //COLORS.put(Color.BLUE, BLUE);
        COLORS.put(Color.BLACK, BLACK);
    }
}
