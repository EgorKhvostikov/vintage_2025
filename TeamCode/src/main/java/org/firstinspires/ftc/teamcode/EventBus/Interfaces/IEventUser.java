package org.firstinspires.ftc.teamcode.EventBus.Interfaces;

public interface IEventUser<T extends IEvent<?> >{
    void onEvent(T event);
}
