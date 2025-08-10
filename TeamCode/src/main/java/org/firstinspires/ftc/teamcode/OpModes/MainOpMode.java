package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GlobalState.MatchData.TeamData;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.OpModes.BaseOpMode.BaseOpMode;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;
import org.firstinspires.ftc.teamcode.Telemetry.Telemetry;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;


@TeleOp(name = "main")
public class MainOpMode extends BaseOpMode {
    static {
        BaseOpMode.serviceActivatorConfig = ServiceActivatorConfig.getDefaultActive();

    }

    @Override
    protected void loopRun() {
        DevicePool.getInstance().brush.setPower(0.7);
        Telemetry.getInstance().add(new TelemetryUnit<>(TeamData.team,"team"));
    }
}
