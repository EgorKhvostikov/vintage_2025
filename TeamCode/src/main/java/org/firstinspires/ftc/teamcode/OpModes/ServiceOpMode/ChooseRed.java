package org.firstinspires.ftc.teamcode.OpModes.ServiceOpMode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GlobalState.MatchData.TeamData;
import org.firstinspires.ftc.teamcode.Util.Color.ColorUnit;

@TeleOp(name  = "choose_red")
public class ChooseRed extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        while (opModeIsActive()){
            TeamData.team = ColorUnit.RED;
        }
    }
}
