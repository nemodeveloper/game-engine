package ru.nemodev.engine;

import com.badlogic.gdx.Screen;

import ru.nemodev.engine.core.app.BaseGame;
import ru.nemodev.engine.core.manager.resource.FontManager;
import ru.nemodev.engine.core.manager.resource.PhysicManager;
import ru.nemodev.engine.core.manager.resource.ResourceLoader;
import ru.nemodev.engine.core.manager.system.AppServiceManager;
import ru.nemodev.engine.core.service.AdbService;
import ru.nemodev.engine.core.service.PlayService;
import ru.nemodev.engine.screen.load.SplashScreen;


public final class GameApp extends BaseGame
{
	public GameApp(PlayService playService, AdbService adbService)
	{
		AppServiceManager.getInstance().setPlayService(playService);
		AppServiceManager.getInstance().setAdbService(adbService);
	}

	@Override
	public void dispose()
	{
		super.dispose();

		ResourceLoader.getInstance().dispose();
		PhysicManager.getInstance().dispose();
        FontManager.getInstance().dispose();
	}

	@Override
	protected Screen getStartScreen()
	{
		return new SplashScreen();
	}
}
