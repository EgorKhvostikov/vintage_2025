package org.firstinspires.ftc.teamcode.EventBus.Interfaces;

@FunctionalInterface
public interface OnEventMethod <T extends IEvent<?>> {
    void onEvent(T event);
}
