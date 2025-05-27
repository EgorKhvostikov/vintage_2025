package org.firstinspires.ftc.teamcode.Modules.Separator;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;

import org.firstinspires.ftc.teamcode.Color.ColorState;
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

    @Override
    public void init(){
        colorSensor = Hardware.puckSensor;
    }

    @Override
    public void update() {
        Color color = Color.getColor(colorSensor.red(),colorSensor.blue(),colorSensor.green());

        if(color == MatchData.team){
            EventManager.getDefault().newPuckInSeparator.publish(ColorState.OUR);
            return;
        }

        if(color == Color.WHITE){
            EventManager.getDefault().newPuckInSeparator.publish(ColorState.NONE);
            return;
        }

        EventManager.getDefault().newPuckInSeparator.publish(ColorState.OPPONENT);
    }
}
