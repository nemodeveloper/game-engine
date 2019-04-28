package ru.nemodev.engine.core.physic.collision;


import ru.nemodev.engine.entity.game.ContactType;

public interface Contactable
{
    void beginContact(Contactable contactable);

    void endContact(Contactable contactable);

    ContactType getContactType();
}
