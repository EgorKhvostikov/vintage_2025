package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.OpModes.BaseOpMode.BaseOpMode;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;


@TeleOp(name = "main")
public class MainOpMode extends BaseOpMode {
    static {
        BaseOpMode.serviceActivatorConfig = ServiceActivatorConfig.getDefaultActive();
    }
    @Override
    protected void loopRun() {

    }
}
