package org.firstinspires.ftc.teamcode.EventBus.Interfaces;

@FunctionalInterface
public interface OnEventMethod <K,T extends IEvent<K>> {
    void onEvent(T event);
}
