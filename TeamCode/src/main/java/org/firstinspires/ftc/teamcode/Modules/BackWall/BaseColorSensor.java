package org.firstinspires.ftc.teamcode.Modules.BackWall;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Color.ColorMap;
import org.firstinspires.ftc.teamcode.Color.ColorState;
import org.firstinspires.ftc.teamcode.Config.ColorSensorConfig;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.MatchData.MatchData;
import org.firstinspires.ftc.teamcode.Color.Color;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

public class BaseColorSensor implements IUpdatable {
    AdafruitI2cColorSensor baseSensor;
    static {
        MainUpdater.getInstance().addModule(BaseColorSensor.class);
    }
    public void init(){
        baseSensor = Hardware.baseSensor;
    }
    public static void load(){}
    private ColorState oldColorState = ColorState.NONE;
    private final ElapsedTime timer = new ElapsedTime();
    @Override
    public void update() {
        if(timer.seconds()>0.2) {
            timer.reset();
            ColorMap colorMap = ColorMap.findNearest(
                    new ColorMap(baseSensor.red(), baseSensor.green(), baseSensor.blue()),
                    ColorSensorConfig.baseRedMap, ColorSensorConfig.baseBlueMap, ColorSensorConfig.baseWhiteMap
            );

            Color color;
            if (colorMap == ColorSensorConfig.baseBlueMap) {
                color = Color.BLUE;
            } else if (colorMap == ColorSensorConfig.baseRedMap) {
                color = Color.RED;
            } else {
                color = Color.WHITE;
            }

            if (color == Color.WHITE) {
                EventManager.getDefault().nowOnBase.publish(ColorState.NONE);
                return;
            }

            if (color == MatchData.team) {
                EventManager.getDefault().nowOnBase.publish(ColorState.OUR);
                return;
            }

            EventManager.getDefault().nowOnBase.publish(ColorState.OPPONENT);

        }

        if (oldColorState != ColorState.OUR && EventManager.getDefault().nowOnBase.data == ColorState.OUR) {
            EventManager.getDefault().arriveOnBase.publish(true);
            EventManager.getDefault().telemtryEvent.publish(
                    new TelemetryUnit<>("arrive on base",1)
            );
        }else{
            EventManager.getDefault().telemtryEvent.publish(
                    new TelemetryUnit<>("arrive on base",0)
            );
        }
        oldColorState = EventManager.getDefault().nowOnBase.data;
    }

    
}
