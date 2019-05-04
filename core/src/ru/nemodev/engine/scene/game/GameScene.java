package ru.nemodev.engine.scene.game;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.physics.box2d.World;

import ru.nemodev.engine.constant.SoundConstant;
import ru.nemodev.engine.core.listener.SoundEventListener;
import ru.nemodev.engine.core.manager.resource.SoundManager;
import ru.nemodev.engine.core.manager.system.ConfigManager;
import ru.nemodev.engine.core.scene.Box2dScene;
import ru.nemodev.engine.manager.GameManager;



/**
 * created by NemoDev on 06.05.2018 - 21:39
 */
public class GameScene extends Box2dScene
{
    private Music musicBackground;

    public GameScene(World world, Batch batch)
    {
        super(world, batch);
        init();
    }

    private void init()
    {
        initHero();
        initBorder();

        musicBackground = SoundManager.getInstance().getMusic(SoundConstant.MAIN_THEME_MUSIC, true);
        if (ConfigManager.getInstance().isEnableSound())
        {
            musicBackground.play();
        }
    }

    private void initBorder()
    {

    }

    private void initHero()
    {

    }

    @Override
    public boolean isInputController()
    {
        return true;
    }

    @Override
    public void dispose()
    {
        super.dispose();

        musicBackground.stop();
    }

    @Override
    protected boolean isNeedUpdate()
    {
        return !GameManager.getInstance().isPause();
    }

    public SoundEventListener getSoundEventListener()
    {
        return new SoundEventListener()
        {
            @Override
            public void soundEnable()
            {
                musicBackground.play();
            }

            @Override
            public void soundDisable()
            {
                musicBackground.stop();
            }
        };
    }
}
