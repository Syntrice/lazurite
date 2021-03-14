package com.syntrice.lazurite.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.syntrice.lazurite.Lazurite;
import com.syntrice.lazurite.world.World;
import com.syntrice.lazurite.world.generation.WorldBuilder;

public class GameScreen implements Screen{

    Lazurite game;
    World world;

    float centerX, centerY;

    public GameScreen(Lazurite game) {
        this.game = game;
        generateWorld();
    }

    private void generateWorld() {
        WorldBuilder builder = new WorldBuilder(200,200);
        world = builder.makeCaves().build();
    }

    @Override
    public void render(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) scrollBy(0,-0.8f);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) scrollBy(0,0.8f);
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) scrollBy(-0.8f,0);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) scrollBy(0.8f,0);

        updateWorld();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    private void updateWorld() {
        for (int sx = 0; sx < Lazurite.GRID_WIDTH; sx++) {
            for (int sy = 0; sy < Lazurite.GRID_HEIGHT; sy++) {
                int x = sx + (int) centerX;
                int y = sy + (int) centerY;
                game.grid.write(world.glyph(x,y),sx,sy,world.foreground(x,y),world.background(x,y));
            }
        }
    }

    private void scrollBy(float x, float y) {
        centerX += x; centerY+= y;
    }

}
