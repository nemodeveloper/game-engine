package ru.nemodev.engine;

import android.app.Activity;

import ru.nemodev.engine.core.service.AdbService;

public class AndroidAdbService implements AdbService
{
    private final Activity activity;

    public AndroidAdbService(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    public void showFullScreenBanner()
    {

    }
}
