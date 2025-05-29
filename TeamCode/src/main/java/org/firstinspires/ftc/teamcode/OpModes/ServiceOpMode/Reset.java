package org.firstinspires.ftc.teamcode.OpModes.ServiceOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous
public class Reset extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        System.exit(0);
    }
}
