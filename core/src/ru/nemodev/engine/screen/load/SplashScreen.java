package ru.nemodev.engine.screen.load;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ru.nemodev.engine.constant.SoundConstant;
import ru.nemodev.engine.constant.texture.AtlasLoaderConstant;
import ru.nemodev.engine.constant.texture.BackgroundTextureConstant;
import ru.nemodev.engine.core.manager.resource.FontManager;
import ru.nemodev.engine.core.manager.resource.PhysicManager;
import ru.nemodev.engine.core.manager.resource.ResourceLoader;
import ru.nemodev.engine.core.scene.BaseScene;
import ru.nemodev.engine.core.screen.BaseLoaderScreen;
import ru.nemodev.engine.core.util.ScreenUtils;
import ru.nemodev.engine.core.util.SpriteUtils;
import ru.nemodev.engine.manager.GameManager;
import ru.nemodev.engine.entity.load.SplashActor;
import ru.nemodev.engine.screen.main.MainScreen;

public class SplashScreen extends BaseLoaderScreen
{
    private final Sprite splashActor;

    public SplashScreen()
    {
        super();

        BaseScene baseScene = new BaseScene(new ScreenViewport(), GameManager.getInstance().getSpriteBatch());

        splashActor = SpriteUtils.create(BackgroundTextureConstant.SPLASH);
        splashActor.setSize(ScreenUtils.getWidth(), ScreenUtils.getHeight());
        splashActor.setPosition(0, 0);

        baseScene.addGameObject(new SplashActor(splashActor));

        addScene(baseScene);
    }

    @Override
    protected void loadResources()
    {
        loadTexture();
        loadSound();
        loadPhysic();

        FontManager.getInstance();
    }

    private void loadTexture()
    {
        ResourceLoader.getInstance().loadAtlas(AtlasLoaderConstant.ATLAS_BODY_FOR_LOADING);
    }

    public void loadSound()
    {
        ResourceLoader.getInstance().loadMusic(SoundConstant.MUSIC_FOR_LOADING);
        ResourceLoader.getInstance().loadSound(SoundConstant.SOUND_FOR_LOADING);
    }

    public void loadPhysic()
    {
        PhysicManager.getInstance();
    }

    @Override
    protected void doAfterLoadResource()
    {
        PhysicManager.getInstance().preparePhysicBodies();

        GameManager.getInstance().getScreenManager().popScreen();
        GameManager.getInstance().getScreenManager().pushScreen(new MainScreen());
    }

    @Override
    public void dispose()
    {
        super.dispose();
        splashActor.getTexture().dispose();
    }
}
