package com.syntrice.lazurite.world;

import com.badlogic.gdx.graphics.Color;

public class World {

    private Tile[][] tiles;
    private int width, height;

    public World(Tile[][] tiles) {
        this.tiles = tiles;
        width = tiles.length;
        height = tiles[0].length;
    }

    public Tile tile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) return Tile.BOUNDS;
        return tiles[x][y];
    }

    public int glyph(int x, int y) {
        return tile(x,y).glyph();
    }

    public Color background(int x, int y) {
        return tile(x,y).background();
    }

    public Color foreground (int x, int y) {
        return tile(x,y).foreground();
    }
}
