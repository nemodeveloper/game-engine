package ru.nemodev.engine.scene.game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.viewport.Viewport;
import ru.nemodev.engine.core.scene.BaseScene;
import ru.nemodev.engine.entity.game.background.BackgroundActor;
import ru.nemodev.engine.manager.GameManager;
import ru.nemodev.engine.manager.pool.PoolManager;

public class GameBackgroundScene extends BaseScene
{
    private BackgroundActor backgroundActor;

    public GameBackgroundScene(Viewport viewport, Batch batch)
    {
        super(viewport, batch);

        init();
    }

    private void init()
    {
        backgroundActor = PoolManager.getInstance().get(BackgroundActor.class);
        addGameObject(backgroundActor);
    }

    @Override
    public void dispose()
    {
        super.dispose();

        PoolManager.getInstance().free(backgroundActor);
    }

    @Override
    protected boolean isNeedUpdate()
    {
        return !GameManager.getInstance().isPause();
    }

}
