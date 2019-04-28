package ru.nemodev.engine.manager.pool;

import com.badlogic.gdx.utils.Pool;

import ru.nemodev.engine.constant.GameConstant;
import ru.nemodev.engine.constant.texture.BackgroundTextureConstant;
import ru.nemodev.engine.core.util.SpriteUtils;
import ru.nemodev.engine.entity.game.background.BackgroundActor;


public final class SimplePool
{
    public static final Pool<BackgroundActor> backgroundActorPool = new Pool<BackgroundActor>(1, 1)
    {
        @Override
        protected BackgroundActor newObject()
        {
            return new BackgroundActor(
                    SpriteUtils.create(BackgroundTextureConstant.BACKGROUND_ATLAS, BackgroundTextureConstant.BACKGROUND,
                            1.f, GameConstant.METERS_Y,
                            GameConstant.METERS_X / 2.f, GameConstant.METERS_Y / 2.f));
        }
    };

}
