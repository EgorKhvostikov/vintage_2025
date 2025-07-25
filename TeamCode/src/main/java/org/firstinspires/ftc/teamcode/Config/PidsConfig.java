package org.firstinspires.ftc.teamcode.Config;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.Util.Math.Pid.PidConfig;

@Config
public class PidsConfig {
    public static PidConfig separatorPidConfig = new PidConfig(0,0,0,0,0,0,0,0,0);
    public static PidConfig     anglePidConfig = new PidConfig(0,0,0,0,0,0,0,0,0);
}
