package ru.nemodev.engine.core.service;

public interface AdsService
{
    interface AdsListener
    {
        void adsShowed(boolean showed);
    }

    void showSimpleBanner();
    void showFullScreenBanner(final AdsListener adsListener);
    void disable();
}
