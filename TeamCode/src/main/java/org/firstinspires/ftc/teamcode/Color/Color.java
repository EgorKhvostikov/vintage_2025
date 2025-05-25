package org.firstinspires.ftc.teamcode.Color;

import org.firstinspires.ftc.teamcode.Config.ColorSensorConfig;

public enum Color {
    BLUE,RED, WHITE;

    public static Color getColor(int r, int g, int b){
        if(r> ColorSensorConfig.redBorder){
            return RED;
        }
        if(b> ColorSensorConfig.blueBorder){
            return BLUE;
        }
        return WHITE;
    }
}
