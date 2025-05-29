package org.firstinspires.ftc.teamcode.Modules.DriveTrain.Mover;

import static java.lang.Math.abs;
import static java.lang.Math.max;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Config.PidConfig;
import org.firstinspires.ftc.teamcode.Events.Event;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Events.EventUser;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Math.Pid.Pid;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Math.Position;

public class VoltageController implements EventUser, IUpdatable {
    private DcMotorEx rightDrive;
    private DcMotorEx leftDrive ;

    private Double   actualVoltage = 12.0;
    private Position actualTarget = new Position();
    public static void load(){}
    static {
        MainUpdater.getInstance().addModule(VoltageController.class);
    }

    public void init() {
        rightDrive        = Hardware.rightDrive;
        leftDrive         = Hardware.leftDrive;
        EventManager.getDefault().newVoltageAvailable.subscribe(this);
        EventManager.getDefault().newTargetVelocity.subscribe(this);
        EventManager.getDefault().newAngle.subscribe(this);
    }

    public void setVoltage(double x, double h){
        double rightVoltage    = x - h;
        double leftVoltage     = x + h;

        double maxTargetVoltage = max(rightVoltage, leftVoltage);


        if (maxTargetVoltage > actualVoltage) {
            double k = actualVoltage / maxTargetVoltage;
            rightVoltage *= k;
            leftVoltage  *= k;
        }

        rightDrive.setPower( rightVoltage/actualVoltage);
        leftDrive .setPower( leftVoltage /actualVoltage);
    }


    public void onEvent(Event<?> e) {
        if(e == EventManager.getDefault().newVoltageAvailable){
            actualVoltage = (Double) e.data;
        }
        if(e == EventManager.getDefault().newTargetVelocity){
            actualTarget = (Position) e.data;
        }
        if(e == EventManager.getDefault().newAngle){
            pid.setPos((Double) e.data);
        }

    }

    private final Pid pid = new Pid(PidConfig.anglePidStatus);
    {
        pid.isAngle = true;
    }
    @Override
    public void lateUpdate() {
        pid.setTarget(actualTarget.h);
        pid.update();
        setVoltage(actualTarget.x, pid.getU());
        EventManager.getDefault().robotAtAngle.publish (abs( Position.normalizeAngle(pid.getPos()-actualTarget.h) ) < 5 );
    }
}
