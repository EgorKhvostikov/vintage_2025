package org.firstinspires.ftc.teamcode.Modules.DriveTrain.Mover;

import static java.lang.Math.max;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Events.Event;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Events.EventUser;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Math.Position;

public class VoltageController implements EventUser, IUpdatable {
    private DcMotorEx rightDrive;
    private DcMotorEx leftDrive ;

    private Double   actualVoltage = 12.0;
    private Position actualTarget = new Position();

    static {
        MainUpdater.addModule(VoltageController.class);
    }

    public void init() {
        rightDrive        = Hardware.rightDrive;
        leftDrive         = Hardware.leftDrive;

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


    public void onEvent(Event e) {
        if(e == EventManager.getDefault().newVoltageAvailable){
            actualVoltage = (Double) e.data;
        }
        if(e == EventManager.getDefault().newTargetVelocity){
            actualTarget = (Position) e.data;
        }
    }

    @Override
    public void lateUpdate() {
        setVoltage(actualTarget.x, actualTarget.h);
    }
}
