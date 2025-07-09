package org.firstinspires.ftc.teamcode.OpModes.BaseOpMode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotModulesUpdater.Robot;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;

public abstract class BaseOpMode extends LinearOpMode {
    protected Robot robot;
    protected static ServiceActivatorConfig serviceActivatorConfig = ServiceActivatorConfig.getDefault();

    private void initOpMode(){

    }

    private void robotInit(){
        robot = new Robot()
                .setServiceActivatorConfig(serviceActivatorConfig)
                .build();
        robot.init();
    }

    protected abstract void loopRun();

    @Override
    public void runOpMode() {
        loopRun();
    }
}
