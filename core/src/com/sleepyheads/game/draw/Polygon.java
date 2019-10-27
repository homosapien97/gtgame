package com.sleepyheads.game.draw;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.utils.ShortArray;

public class Polygon {
    private float[] points;
    private Color color;
    private float x;
    private float y;
    private float rotation;
    private float scale;
    private EarClippingTriangulator earClipper = new EarClippingTriangulator();
    private ShortArray triangleIndices;
    private PolygonSprite polySprite;
    private PolygonSprite transformedPolySprite;

    public Polygon() {
        this(new float[0], Color.BLACK);
    }

    public Polygon(float[] points, Color color) {
        this(points, color, 0.0f, 0.0f, 0.0f, 1.0f);
    }

    public Polygon(float[] points, Color color, float x, float y, float rotation, float scale) {
        this.points = points;
        this.color = color;
        triangleIndices = earClipper.computeTriangles(points);
        polySprite = new PolygonSprite(new PolygonRegion(new TextureRegion(Colors.COLORS.get(color)), points, triangleIndices.toArray()));
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        this.scale = scale;
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

    /**
     * Draws this model with the given shape renderer
     * @param sb
     */
    public void draw(PolygonSpriteBatch sb) {
        draw(sb, 0.0f, 0.0f, 0.0f, 1.0f);
    }
    public void draw(PolygonSpriteBatch sb, float xoff, float yoff, float rot, float sc) {
        transformedPolySprite = new PolygonSprite(polySprite);
        transformedPolySprite.rotate(rotation);
        transformedPolySprite.translate(x, y);
        transformedPolySprite.setScale(scale);
        transformedPolySprite.rotate(rot);
        transformedPolySprite.setScale(sc * scale);
        transformedPolySprite.translate(xoff, yoff);
        sb.begin();
        transformedPolySprite.draw(sb);
        sb.end();
    }

    public void setPoints(float[] points) {
        this.points = points;
        triangleIndices = earClipper.computeTriangles(points);
        polySprite = new PolygonSprite(new PolygonRegion(new TextureRegion(Colors.COLORS.get(color)), points, triangleIndices.toArray()));
    }

    public void setColor(Color color) {
        this.color = color;
        polySprite = new PolygonSprite(new PolygonRegion(new TextureRegion(Colors.COLORS.get(color)), points, triangleIndices.toArray()));
    }
}
