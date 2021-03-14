package com.syntrice.lazurite.screen;

import com.badlogic.gdx.InputProcessor;

public interface Screen extends com.badlogic.gdx.Screen, InputProcessor {

    @Override
    default void show() {

    }

    @Override
    default void render(float delta) {

    }

    @Override
    default void resize(int width, int height) {

    }

    @Override
    default void pause() {

    }

    @Override
    default void resume() {

    }

    @Override
    default void hide() {

    }

    @Override
    default void dispose() {

    }

    @Override
    default boolean keyDown(int keycode) {
        return false;
    }

    @Override
    default boolean keyUp(int keycode) {
        return false;
    }

    @Override
    default boolean keyTyped(char character) {
        return false;
    }

    @Override
    default boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    default boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    default boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    default boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    default boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
