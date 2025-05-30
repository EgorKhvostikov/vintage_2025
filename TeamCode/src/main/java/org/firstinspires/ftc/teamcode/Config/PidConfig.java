package org.firstinspires.ftc.teamcode.Config;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.Math.Pid.PidStatus;

@Config
public class PidConfig {
    public static PidStatus sepatatorPidStatus = new PidStatus(0.01,0,0.001,0,0,0,0,0.0,0.0);
    public static PidStatus anglePidStatus     = new PidStatus(0.09,0.05,0.02,0,0,0,0,1,0);
}
