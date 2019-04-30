package ru.nemodev.engine.service;

import android.app.Activity;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import ru.nemodev.engine.BuildConfig;
import ru.nemodev.engine.R;
import ru.nemodev.engine.core.service.AdsService;
import ru.nemodev.engine.core.util.LogUtils;
import ru.nemodev.engine.utils.AndroidUtils;

public class AndroidAdsService implements AdsService
{
    private static final String LOG_TAG = AndroidAdsService.class.getName();

    private final Activity activity;

    private final AdView simpleBanner;
    private InterstitialAd fullScreenBanner;

    private boolean enable;

    public AndroidAdsService(Activity activity, AdView simpleBanner, boolean enable)
    {
        this.activity = activity;
        this.simpleBanner = simpleBanner;
        this.enable = enable;

        if (this.enable)
        {
            MobileAds.initialize(activity, AndroidUtils.getString(activity, R.string.ads_app_id));
            initSimpleBanner();
            initFullScreenBanner();
        }
    }

    @Override
    public boolean showFullScreenBanner()
    {
        if (!enable)
            return false;

        if (fullScreenBanner.isLoaded())
        {
            fullScreenBanner.show();
            return true;
        }
        else
        {
            loadNewFullscreenBanner();
            return false;
        }
    }

    @Override
    public void disable()
    {
        enable = false;
        simpleBanner.setVisibility(View.GONE);

    }

    private AdRequest buildAdRequest()
    {
        AdRequest.Builder builder = new AdRequest.Builder();
        if (BuildConfig.DEBUG)
        {
            builder.addTestDevice(AndroidUtils.getString(activity, R.string.device_id_test));
        }

        return builder.build();
    }

    private void initSimpleBanner()
    {
        simpleBanner.setVisibility(View.VISIBLE);
        simpleBanner.loadAd(buildAdRequest());
    }

    private void initFullScreenBanner()
    {
        try
        {
            fullScreenBanner = new InterstitialAd(activity);
            fullScreenBanner.setAdUnitId(BuildConfig.DEBUG
                    ? AndroidUtils.getString(activity, R.string.ads_fullscreen_banner_id_test)
                    : AndroidUtils.getString(activity, R.string.ads_fullscreen_banner_id));

            fullScreenBanner.setAdListener(new AdListener() {
                @Override
                public void onAdClosed()
                {
                    loadNewFullscreenBanner();
                }
            });

            loadNewFullscreenBanner();
        }
        catch (Exception e)
        {
            LogUtils.error(LOG_TAG, "Ошибка инициализации полноэкранного баннера", e);
            enable = false;
        }
    }

    private void loadNewFullscreenBanner()
    {
        if (!fullScreenBanner.isLoaded())
        {
            fullScreenBanner.loadAd(buildAdRequest());
        }
    }
}
