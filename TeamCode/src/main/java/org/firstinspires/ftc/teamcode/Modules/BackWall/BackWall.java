package org.firstinspires.ftc.teamcode.Modules.BackWall;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Color.ColorState;
import org.firstinspires.ftc.teamcode.Config.ActiveServiceList;
import org.firstinspires.ftc.teamcode.Config.ServoPositionConfig;
import org.firstinspires.ftc.teamcode.Events.Event;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Events.EventUser;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;

public class BackWall implements EventUser, IUpdatable{

    {
        if(ActiveServiceList.backWall){
            MainUpdater.getInstance().addModule(BackWall.class);
        }
    }
    public static void load(){}

    private Servo servo;
    @Override
    public void init(){
        servo = Hardware.wallServo;
        EventManager.getDefault().nowOnBase.subscribe(this);
    }
    @Override
    public void lateUpdate(){
        if(isOpen){
            servo.setPosition(ServoPositionConfig.upBackWallPos);
        }else{
            servo.setPosition(ServoPositionConfig.downBackWallPos);
        }
    }
    private boolean isOpen = false;
    @Override
    public void onEvent(Event<?> e) {
        isOpen = e.data == ColorState.OUR;
    }
}
