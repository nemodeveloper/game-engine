package ru.nemodev.engine.manager.pool;

import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

import ru.nemodev.engine.entity.game.background.BackgroundActor;

/**
 * created by NemoDev on 08.05.2018 - 20:45
 */
public final class PoolManager
{
    private static volatile PoolManager instance = new PoolManager();

    private PoolManager()
    {
        initialize();
    }

    private void initialize()
    {
        Pools.set(BackgroundActor.class, SimplePool.backgroundActorPool);
    }

    public static PoolManager getInstance()
    {
        return instance;
    }

    public <T extends Pool.Poolable> T get(Class<T> type)
    {
        Pool<T> pool = Pools.get(type);
        if (pool == null)
            return null;

        return pool.obtain();
    }

    public void free(Pool.Poolable free)
    {
        if (free == null)
            return;

        Pools.free(free);
    }
}
