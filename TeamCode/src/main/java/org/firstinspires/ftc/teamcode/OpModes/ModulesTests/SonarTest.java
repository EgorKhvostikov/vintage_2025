package org.firstinspires.ftc.teamcode.OpModes.ModulesTests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.I2cAddr;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Sonar.I2cPort;

@TeleOp
public class SonarTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        I2cPort i2cPort = hardwareMap.get(I2cPort.class, "arduinonano");
        i2cPort.initWithI2cAddress(I2cAddr.create7bit(5));

        waitForStart();
        resetRuntime();

        Telemetry allTelemetry = new MultipleTelemetry(FtcDashboard.getInstance().getTelemetry(), telemetry);

        while (opModeIsActive()){
            i2cPort.write((byte) 5);

            byte data = i2cPort.read();

            allTelemetry.addData("data", data);
            allTelemetry.update();
        }
    }
}
