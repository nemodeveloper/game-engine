package ru.nemodev.engine.constant;


import ru.nemodev.engine.core.util.ScreenUtils;

public final class GameConstant
{
    private GameConstant() { }

    public static final float METERS_X = 9.f;
    public static final float METERS_Y = ScreenUtils.getHeight() / ScreenUtils.getWidth()  * METERS_X;

    public static final float UNIT_SIZE = 1.f;
}
