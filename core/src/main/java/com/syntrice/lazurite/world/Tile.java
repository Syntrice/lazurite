package com.syntrice.lazurite.world;

import com.badlogic.gdx.graphics.Color;

public enum Tile {
    FLOOR(',', new Color(0.2f,0.2f,0.2f,1.0f),null),
    WALL('#', new Color(0.6f,0.6f,0.6f,1.0f),null),
    ORE(176,new Color(0.2f,0.4f,0.8f,1.0f),null),
    BOUNDS('X',Color.RED,Color.YELLOW);


    private Color background, foreground;
    private int glyph;

    Tile(int glyph, Color foreground, Color background) {
        this.background = background;
        this.foreground = foreground;
        this.glyph = glyph;
    }

    public int glyph() {
        return glyph;
    }

    public Color background() {
        return background;
    }

    public Color foreground() {
        return foreground;
    }
}
