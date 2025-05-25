package org.firstinspires.ftc.teamcode.Config;

import static java.lang.Math.PI;

import com.acmerobotics.dashboard.config.Config;

@Config
public class RobotConstantConfig {

    public static double TICKS_PER_REV = 480;
    public static double MAX_RPM = 300;
    public static double MAX_MOTOR_TICKS_VEL = 2400;

    public static double ENCODER_CONSTANT = 480;
    public static double TRANSMISSION = 21d/27;
    public static double LENGTH_OF_WHEEL = 9.6d*PI;
}
