package org.firstinspires.ftc.teamcode.OpModes.ModulesTests;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Config.PidConfig;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Math.Pid.Pid;
import org.firstinspires.ftc.teamcode.Math.Pid.PidStatus;

@Config
@TeleOp
public class SeparatorPidTest  extends LinearOpMode {
    DcMotorEx motor;
    public static PidStatus pidStatus = new PidStatus(0,0,0,0,0,0,0,0,0);
    private final Pid pid = new Pid(PidConfig.sepatatorPidStatus);
    public static double target = 0;
    @Override
    public void runOpMode(){
        Hardware.init(this.hardwareMap);
        motor = Hardware.separatorMotor;
        waitForStart();
        while (opModeIsActive()){
            FtcDashboard.getInstance().getTelemetry().addData("target",target);
            FtcDashboard.getInstance().getTelemetry().addData("position",motor.getCurrentPosition());


            pid.setTarget(target);
            pid.setPos(motor.getCurrentPosition());
            pid.update();
            double u = pid.getU();

            if(Math.abs(u)>0.5){
                u = 0.5 * Math.signum(u);
            }
            FtcDashboard.getInstance().getTelemetry().addData("u",u);
            FtcDashboard.getInstance().getTelemetry().update();
            motor.setPower(u);
        }
    }
}
