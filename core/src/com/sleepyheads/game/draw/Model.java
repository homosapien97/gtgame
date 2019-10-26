package com.sleepyheads.game.draw;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.utils.ShortArray;

public class Model {
    public float[] points;
    public Color color;
    private EarClippingTriangulator earClipper = new EarClippingTriangulator();
    private ShortArray triangleIndices;
    private PolygonSprite polySprite;

    public Model() {
        this(new float[0], Color.BLACK);
    }

    public Model(float[] points, Color color) {
        this.points = points;
        this.color = color;
        triangleIndices = earClipper.computeTriangles(points);
        polySprite = new PolygonSprite(new PolygonRegion(new TextureRegion(Colors.COLORS.get(color)), points, triangleIndices.toArray()));
    }

    /**
     * Draws this model with the given shape renderer
     * @param sb
     */
    public void draw(PolygonSpriteBatch sb) {
        System.out.println("Drawing");
        sb.begin();
        polySprite.draw(sb);
        sb.end();
        System.out.println("Done Drawing");
    }

    /**
     * Don't use this to build models, it's expensive
     * @param x the x coordinate of the point to add
     * @param y the y coordinate of the point to add
     */
    public void addPoint(float x, float y) {
        float[] np = new float[points.length + 2];
        System.arraycopy(points, 0, np, 0, points.length);
        points = np;
        triangleIndices = earClipper.computeTriangles(points);
        polySprite = new PolygonSprite(new PolygonRegion(new TextureRegion(Colors.COLORS.get(color)), points, triangleIndices.toArray()));
    }
}
