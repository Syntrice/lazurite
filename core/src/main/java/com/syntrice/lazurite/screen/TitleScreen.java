package com.syntrice.lazurite.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.syntrice.lazurite.Lazurite;

public class TitleScreen implements Screen {

    private Lazurite game;

    public TitleScreen(Lazurite game) {
        this.game = game;
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
        game.grid.writeCenter("-- Lazurite --",19);
    }

    @Override
    public boolean keyDown(int character) {
        switch (character) {
            case Input.Keys.ENTER: game.setScreen(new GameScreen(game)); return true;
        }
        return false;
    }
}
