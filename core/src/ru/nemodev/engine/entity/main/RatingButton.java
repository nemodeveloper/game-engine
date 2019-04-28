package ru.nemodev.engine.entity.main;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.engine.core.manager.system.AppServiceManager;
import ru.nemodev.engine.core.model.ButtonActor;

public class RatingButton extends ButtonActor
{
    public RatingButton(Sprite neutralState, Sprite pressState)
    {
        super(neutralState, pressState);
    }

    @Override
    public void doTouchUp(float x, float y)
    {
        if (!AppServiceManager.getInstance().getPlayService().isSignedIn())
        {
            AppServiceManager.getInstance().getPlayService().signIn();
        }

        AppServiceManager.getInstance().getPlayService().showScore();
    }
}
