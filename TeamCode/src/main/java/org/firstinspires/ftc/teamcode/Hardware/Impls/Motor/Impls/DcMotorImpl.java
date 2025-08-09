package org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;

public class DcMotorImpl implements Motor {
    protected DcMotorEx motor;

    public DcMotorImpl(DcMotorEx motor) {
        this.motor = motor;
    }

    @Override
    public double getPosition() {
        return motor.getCurrentPosition();
    }

    @Override
    public void setPower(double v) {
        motor.setPower(v);
    }

    @Override
    public double getCurrent() {
        return motor.getCurrent(CurrentUnit.AMPS);
    }

    @Override
    public void reset() {
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    @Override
    public void setZeroPowerBehavior(DcMotor.ZeroPowerBehavior m) {
        motor.setZeroPowerBehavior(m);
    }

    @Override
    public void setDerection(DcMotorSimple.Direction direction) {
        motor.setDirection(direction);
    }
}
