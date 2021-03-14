package com.syntrice.lazurite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.syntrice.lazurite.screen.TitleScreen;
import com.syntrice.rozenite.graphics.AsciiGrid;

public class Lazurite extends Game {

    public static final int GRID_WIDTH = 80, GRID_HEIGHT = 40;

    private Lazurite game; // An instance of this class, representing our game
    public SpriteBatch batch;
    public FitViewport viewport;
    public OrthographicCamera camera;
    public AsciiGrid grid;

    @Override
    public void create() {
        this.game = this;

        camera = new OrthographicCamera();
        camera.setToOrtho(true,GRID_WIDTH,GRID_HEIGHT);
        viewport = new FitViewport(GRID_WIDTH,GRID_HEIGHT,camera);
        grid = new AsciiGrid(80,40,true);

        batch = new SpriteBatch();

        this.setScreen(new TitleScreen(game));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0f,0f,0f,1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        super.render();
        game.batch.begin();
        game.grid.draw(game.batch,1);
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height);
        super.resize(width, height);
    }

    @Override
    public void setScreen(Screen screen) {
        game.grid.clear();
        super.setScreen(screen);
    }
}