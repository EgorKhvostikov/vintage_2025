package org.firstinspires.ftc.teamcode.OpModes.ServiceOpMode;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.OpModes.BaseOpMode.BaseOpMode;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;

@Config
public class ServiceActivatorConfigBuild extends BaseOpMode {
    public static ServiceActivatorConfig serviceActivatorConfig = new ServiceActivatorConfig();

    @Override
    protected void loopRun() {

    }

    @Override
    public void runOpMode(){
        BaseOpMode.serviceActivatorConfig = serviceActivatorConfig;
    }
}
