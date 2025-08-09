package org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Impls;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Interface.ServoMotor;

public class ServoImpl implements ServoMotor {

    private final Servo servo;

    public ServoImpl(Servo servo) {
        this.servo = servo;
    }

    @Override
    public void setPosition(double t) {
        servo.setPosition(t);
    }
}
