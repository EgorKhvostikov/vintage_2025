package org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Eve3MotorImpl extends DcMotorImpl{

    public Eve3MotorImpl(DcMotorEx motor) {
        super(motor);
    }
    @Override
    public void setPower(double v){
        motor.setPower(Math.min(v, 0.5));
    }
}
