package ru.nemodev.engine.core.service;

public class MockAdsService implements AdsService
{
    @Override
    public boolean showFullScreenBanner()
    {
        return true;
    }

    @Override
    public void disable()
    {

    }
}
