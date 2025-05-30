package org.firstinspires.ftc.teamcode.OpModes.ServiceOpMode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Color.Color;
import org.firstinspires.ftc.teamcode.MatchData.MatchData;

@Autonomous
public class ChooseRED extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        MatchData.team = Color.RED;
    }
}
