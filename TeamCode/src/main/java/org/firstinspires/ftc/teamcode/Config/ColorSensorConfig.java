package org.firstinspires.ftc.teamcode.Config;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.Color.ColorMap;

@Config
public class ColorSensorConfig {
    public static ColorMap baseBlueMap  = new ColorMap(20,15,16);
    public static ColorMap baseRedMap   = new ColorMap(60,18,17);
    public static ColorMap baseWhiteMap = new ColorMap(105,77,55);

    public static ColorMap puckBlueMap  = new ColorMap(6,7,6);
    public static ColorMap puckRedMap   = new ColorMap(15,7,6);
    public static ColorMap puckWhiteMap = new ColorMap(11,11,8);
}
