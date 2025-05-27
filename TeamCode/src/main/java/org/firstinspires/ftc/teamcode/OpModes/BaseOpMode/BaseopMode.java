package org.firstinspires.ftc.teamcode.OpModes.BaseOpMode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;

public abstract class BaseopMode extends LinearOpMode {
    public abstract void initDevices();
    public abstract void loopCall();
    public abstract void conditionCall();

    private void initOpMode(){
        Hardware.init(this.hardwareMap);
        MainUpdater.getInstance().init();
    }
    protected boolean isNeedToCall = false;
    @Override
    public void runOpMode(){
        initOpMode();
        initDevices();
        waitForStart();
        while (opModeIsActive()){
            if(isNeedToCall){
                conditionCall();
                isNeedToCall = false;
            }
            loopCall();
            MainUpdater.getInstance().init();
        }
    }
}
