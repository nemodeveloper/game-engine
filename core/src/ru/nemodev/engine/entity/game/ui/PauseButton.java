package ru.nemodev.engine.entity.game.ui;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ru.nemodev.engine.core.manager.GameStatus;
import ru.nemodev.engine.core.model.ButtonActor;
import ru.nemodev.engine.manager.GameManager;

public class PauseButton extends ButtonActor
{
    private final GamePauseListener gamePauseListener;

    public PauseButton(Sprite neutralState, Sprite pressState,
                       GamePauseListener gamePauseListener)
    {
        super(neutralState, pressState);
        this.gamePauseListener = gamePauseListener;
    }

    @Override
    public void doTouchUp(float x, float y)
    {
        if (GameManager.getInstance().isRunning())
        {
            GameManager.getInstance().setGameStatus(GameStatus.PAUSE);
            gamePauseListener.pauseStart();
        }
        else if (GameManager.getInstance().isPause())
        {
            GameManager.getInstance().setGameStatus(GameStatus.RUNNING);
            gamePauseListener.pauseEnd();
        }
    }

}
