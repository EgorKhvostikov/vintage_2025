package org.firstinspires.ftc.teamcode.Config;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.Color.ColorMap;

@Config
public class ColorSensorConfig {
    public static ColorMap baseBlueMap  = new ColorMap(30,20,25);
    public static ColorMap baseRedMap   = new ColorMap(88,30,30);
    public static ColorMap baseWhiteMap = new ColorMap(146,99,92);

    public static ColorMap puckBlueMap  = new ColorMap(7 ,8,6);
    public static ColorMap puckRedMap   = new ColorMap(16,8,7);
    public static ColorMap puckWhiteMap = new ColorMap(11,11,8);
}
