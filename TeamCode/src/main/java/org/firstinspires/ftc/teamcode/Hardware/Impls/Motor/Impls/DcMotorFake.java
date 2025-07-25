package org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;

public class DcMotorFake implements Motor {

    private Double motorPos = 0d;
    private Double motorVol = 0d;

    public DcMotorFake(Double motorPos, Double motorVol) {
        this.motorPos = motorPos;
        this.motorVol = motorVol;
    }

    @Override
    public double getPosition() {
        return motorPos;
    }

    @Override
    public void setPower(double v) {

    }

    @Override
    public double getCurrent() {
        return motorVol;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior m) {

    }
}
