package org.firstinspires.ftc.teamcode.Modules.BackWall;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;

import org.firstinspires.ftc.teamcode.Color.ColorState;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.MatchData.MatchData;
import org.firstinspires.ftc.teamcode.Color.Color;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;

public class BaseColorSensor implements IUpdatable {
    AdafruitI2cColorSensor baseSensor;
    static {
        MainUpdater.getInstance().addModule(BaseColorSensor.class);
    }
    public void init(){
        baseSensor = Hardware.baseSensor;
    }

    ColorState oldColorState = ColorState.NONE;
    @Override
    public void update() {
        Color color = Color.getColor(baseSensor.red(),baseSensor.blue(),baseSensor.green());
        if(color == Color.WHITE){
            EventManager.getDefault().nowOnBase.publish(ColorState.NONE);
            return;
        }

        if(color == MatchData.team){
            EventManager.getDefault().nowOnBase.publish(ColorState.OUR);
            return;
        }

        EventManager.getDefault().nowOnBase.publish(ColorState.OPPONENT);

        if(oldColorState != ColorState.OUR && EventManager.getDefault().nowOnBase.data == ColorState.OUR){
            EventManager.getDefault().arriveOnBase.publish(true);
        }
        oldColorState =  EventManager.getDefault().nowOnBase.data;
    }

    
}
