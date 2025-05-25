package org.firstinspires.ftc.teamcode.Modules.Interfaces;

public interface IUpdatable {
    default void update    (){}
    default void lateUpdate(){}
    default void init      (){}
}
