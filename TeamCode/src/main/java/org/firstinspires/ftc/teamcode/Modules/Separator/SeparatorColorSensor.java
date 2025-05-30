package org.firstinspires.ftc.teamcode.Modules.Separator;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Color.ColorMap;
import org.firstinspires.ftc.teamcode.Color.ColorState;
import org.firstinspires.ftc.teamcode.Config.ColorSensorConfig;
import org.firstinspires.ftc.teamcode.Events.Event;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Events.EventUser;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Color.Color;
import org.firstinspires.ftc.teamcode.MatchData.MatchData;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;

public class SeparatorColorSensor implements IUpdatable{
    static {
        MainUpdater.getInstance().addModule(SeparatorColorSensor.class);
    }
    AdafruitI2cColorSensor colorSensor;
    public static void load(){}
    @Override
    public void init(){
        colorSensor = Hardware.puckSensor;
    }

    private final ElapsedTime timer = new ElapsedTime();
    @Override
    public void update() {
        if(timer.seconds()>0.2) {
            timer.reset();
            ColorMap colorMap = ColorMap.findNearest(
                    new ColorMap(colorSensor.red(), colorSensor.green(), colorSensor.blue()),
                    ColorSensorConfig.puckRedMap, ColorSensorConfig.puckBlueMap, ColorSensorConfig.puckWhiteMap
            );

            Color color;
            if (colorMap == ColorSensorConfig.puckBlueMap) {
                color = Color.BLUE;
            } else if (colorMap == ColorSensorConfig.puckRedMap) {
                color = Color.RED;
            } else {
                color = Color.WHITE;
            }

            if (color == MatchData.team) {
                EventManager.getDefault().newPuckInSeparator.publish(ColorState.OUR);
                return;
            }

            if (color == Color.WHITE) {
                EventManager.getDefault().newPuckInSeparator.publish(ColorState.NONE);
                return;
            }

            EventManager.getDefault().newPuckInSeparator.publish(ColorState.OPPONENT);
        }
    }
}
