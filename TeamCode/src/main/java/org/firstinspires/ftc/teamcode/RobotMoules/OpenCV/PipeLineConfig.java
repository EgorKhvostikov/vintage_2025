package org.firstinspires.ftc.teamcode.RobotMoules.OpenCV;

import com.acmerobotics.dashboard.config.Config;

import org.opencv.core.Scalar;

@Config
public class PipeLineConfig {
    public static double sigmaColorFilter = 7;
    public static double sigmaSpaceFilter = 7;

    public static int K = 17;
    public static int attemps = 17;

    public static Scalar upHsv   = new Scalar(0,0,0);
    public static Scalar downHsv = new Scalar(0,0,0);

    public static int puckAreaUp   = 100;
    public static int puckAreaDown = 0;

}
