package ru.nemodev.engine.core.model;

public interface Touchable
{
    GameObject isTouch(float x, float y);
    boolean touchDown(float x, float y);
    void touchUp(float x, float y);
}
