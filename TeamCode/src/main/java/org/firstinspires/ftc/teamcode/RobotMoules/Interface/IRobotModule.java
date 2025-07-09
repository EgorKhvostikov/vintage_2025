package org.firstinspires.ftc.teamcode.RobotMoules.Interface;

public interface IRobotModule {
    default void update(){}
    default void lateUpdate(){}
    default void init(){}
}
