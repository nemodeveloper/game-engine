package ru.nemodev.engine.core.manager.system;

import ru.nemodev.engine.core.service.AdsService;
import ru.nemodev.engine.core.service.MockPlayService;
import ru.nemodev.engine.core.service.PlayService;

public final class AppServiceManager
{
    private static final AppServiceManager instance = new AppServiceManager();

    private PlayService playService;
    private AdsService adsService;

    public AppServiceManager()
    {
        this.playService = new MockPlayService();
    }

    public PlayService getPlayService()
    {
        return playService;
    }

    public void setPlayService(PlayService playService)
    {
        this.playService = playService;
    }

    public AdsService getAdsService()
    {
        return adsService;
    }

    public void setAdsService(AdsService adsService)
    {
        this.adsService = adsService;
    }

    public static AppServiceManager getInstance()
    {
        return instance;
    }
}
