package ru.nemodev.engine.core.service;

public class MockAdsService implements AdsService
{
    @Override
    public void showSimpleBanner()
    {

    }

    @Override
    public void showFullScreenBanner(final AdsListener adsListener)
    {
        adsListener.adsShowed(true);
    }

    @Override
    public void disable()
    {

    }
}
