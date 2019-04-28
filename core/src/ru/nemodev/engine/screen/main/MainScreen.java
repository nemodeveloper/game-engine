package ru.nemodev.engine.screen.main;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import ru.nemodev.engine.constant.GameConstant;
import ru.nemodev.engine.core.manager.GameStatus;
import ru.nemodev.engine.core.scene.Scene;
import ru.nemodev.engine.core.screen.BaseScreen;
import ru.nemodev.engine.manager.GameManager;
import ru.nemodev.engine.scene.main.MainBackgroundScene;
import ru.nemodev.engine.scene.main.MainMenuScene;

/**
 * created by NemoDev on 06.05.2018 - 19:30
 */
public class MainScreen extends BaseScreen
{
    public MainScreen()
    {
        super(new Array<Scene>());

        Batch batch = GameManager.getInstance().getSpriteBatch();

        initBackgroundScene(batch);
        initMenuScene(batch);
    }

    @Override
    protected GameStatus getGameStatus()
    {
        return GameStatus.READY;
    }

    private void initBackgroundScene(Batch batch)
    {
        OrthographicCamera camera = new OrthographicCamera(GameConstant.METERS_X, GameConstant.METERS_Y);
        camera.setToOrtho(false, GameConstant.METERS_X, GameConstant.METERS_Y);

        MainBackgroundScene mainBackgroundScene = new MainBackgroundScene(
                new ExtendViewport(GameConstant.METERS_X, GameConstant.METERS_Y, GameConstant.METERS_X, GameConstant.METERS_Y, camera), batch);

        addScene(mainBackgroundScene);
    }

    private void initMenuScene(Batch batch)
    {
        OrthographicCamera camera = new OrthographicCamera(GameConstant.METERS_X, GameConstant.METERS_Y);
        camera.setToOrtho(false, GameConstant.METERS_X, GameConstant.METERS_Y);

        MainMenuScene mainMenuScene = new MainMenuScene(
                new ExtendViewport(GameConstant.METERS_X, GameConstant.METERS_Y, GameConstant.METERS_X, GameConstant.METERS_Y, camera), batch);

        addScene(mainMenuScene);
    }

    @Override
    public void dispose()
    {
        super.dispose();
    }
}
