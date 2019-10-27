package com.sleepyheads.game.draw;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

import java.io.*;
import java.util.HashSet;

public class Model extends HashSet<Polygon> {
    float x;
    float y;
    float rotation;
    float scale;
    public Model(String modelFilePath) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(modelFilePath));
            String viewport = br.readLine();
            String[] vpxy = viewport.trim().split(" ");
            float height = Float.parseFloat(vpxy[3].trim());
            br.readLine();//empty
            String line = br.readLine();
            while(line != null) {
                line = line.substring(8,line.length()-1);
                String[] ptstrings = line.trim().split(",");
                float[] pts = new float[ptstrings.length * 2 + 2];
                for(int i = 0; i < ptstrings.length; i++) {
                    String[] xystring = ptstrings[i].trim().split(" ");
                    for(String s : xystring) {
                        System.out.println("-"+s);
                    }
                    if(xystring.length != 2) break;
                    pts[2*i] = Float.parseFloat(xystring[0]) - height / 2.0f;
                    pts[2*i+1] = (height - Float.parseFloat(xystring[1])) - height / 2.0f;
                }
                pts[pts.length - 2] = pts[0];
                pts[pts.length - 1] = pts[1];
                Color color = Color.BLACK;//TODO temp
                this.add(new Polygon(pts, color));
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        x = 0.0f;
        y = 0.0f;
    }
    public void draw(PolygonSpriteBatch sb) {
        for(Polygon p : this) {
            p.draw(sb, x, y, rotation, scale);
        }
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }
    public void setScale(float scale) {
        this.scale = scale;
    }
}
