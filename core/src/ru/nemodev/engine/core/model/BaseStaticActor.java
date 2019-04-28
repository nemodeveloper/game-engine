package ru.nemodev.engine.core.model;


public abstract class BaseStaticActor extends BaseActor
{
    @Override
    protected boolean isNeedUpdate()
    {
        return false;
    }
}
