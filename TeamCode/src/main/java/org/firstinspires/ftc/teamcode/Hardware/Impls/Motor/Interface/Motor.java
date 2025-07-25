package org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface;

import com.qualcomm.robotcore.hardware.DcMotor;

public interface Motor {
    double getPosition();
    void setPower(double v);
    double getCurrent();
    void reset();
    void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior m);
}
