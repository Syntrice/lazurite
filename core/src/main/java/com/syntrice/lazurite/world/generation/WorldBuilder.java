package com.syntrice.lazurite.world.generation;

import com.syntrice.lazurite.world.Position;
import com.syntrice.lazurite.world.Tile;
import com.syntrice.lazurite.world.World;

import java.util.ArrayList;
import java.util.HashMap;

public class WorldBuilder {

    private int width, height;
    private Tile[][] tiles;

    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
    }

    public WorldBuilder makeCaves() {
        randomize().smooth(8).seedOre();
        return this;
    }



    private WorldBuilder randomize() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.48 ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }

    private WorldBuilder smooth(int times) {
        Tile[][] tilesNew = new Tile[width][height];
        for (int t = 0; t < times; t++) {
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    HashMap<Tile, Integer> counts = countTiles(x-1,y-1,3,3);
                    tilesNew[x][y] = (counts.getOrDefault(Tile.FLOOR,0) >= counts.getOrDefault(Tile.WALL,0)) ? Tile.FLOOR : Tile.WALL;
                }
            }
            tiles = tilesNew;
        }
        return this;
    }

    private WorldBuilder seedOre() {
        Tile[][] tilesNew = tiles;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                double rand = Math.random();
                HashMap<Tile,Integer> counts = countTiles(x-2,y-2,5,5);
                if (rand > 0.98 && counts.getOrDefault(Tile.WALL,0) >= 23) {
                    tilesNew[x][y] = Tile.ORE;
                }
            }
        }
        tiles = tilesNew;
        return this;
    }

    private HashMap<Tile,Integer> countTiles(int x, int y, int w, int h) {
        HashMap<Tile, Integer> counts = new HashMap<>();
        for (int nx = x; nx < x + w; nx++) {
            for (int ny = y; ny < y + h; ny++) {
                if (nx < 0 || nx >= width || ny < 0 || ny >= height) continue;
                Integer count = counts.getOrDefault(tiles[nx][ny], 0);
                counts.put(tiles[nx][ny],++count);
            }
        }
        return counts;
    }

    /**
     * Builds generated world into a new world object
     * @return new World
     */
    public World build() {
        return new World(tiles);
    }
}
