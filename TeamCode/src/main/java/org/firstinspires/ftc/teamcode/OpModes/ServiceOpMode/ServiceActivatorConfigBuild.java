package org.firstinspires.ftc.teamcode.OpModes.ServiceOpMode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.OpModes.BaseOpMode.BaseOpMode;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;

@Config
@TeleOp(name = "build")
public class ServiceActivatorConfigBuild extends BaseOpMode {
    public static ServiceActivatorConfig serviceActivatorConfig = new ServiceActivatorConfig();

    @Override
    protected void loopRun() {
    }

    @Override
    public void runOpMode(){
       waitForStart();
       while (opModeIsActive()) {
           BaseOpMode.serviceActivatorConfig = serviceActivatorConfig;
       }
    }
}
