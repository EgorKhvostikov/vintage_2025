package org.firstinspires.ftc.teamcode.Hardware.Pool;


import org.firstinspires.ftc.teamcode.Hardware.Factory.HardwareFactory;

import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;

import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Interface.Servo;

public class DevicePool {
    private static final DevicePool Instance = new DevicePool();

    public static DevicePool getInstance() {
        return Instance;
    }

    public void init(HardwareFactory factory){
         rightDrive = factory.createDcMotor("rightDrive");
         leftDrive = factory.createDcMotor("leftDrive");

         separatorMotor = factory.createEve3Motor("leftDrive");

         baseSensor = factory.createColorSensor("baseSensor");
         puckSensor = factory.createColorSensor("puckSensor");

         backWallServo = factory.createServo("backWallServo");
    }

    public Motor rightDrive;
    public Motor leftDrive;

    public Motor separatorMotor;

    public ColorSensor baseSensor;
    public ColorSensor puckSensor;

    public Servo backWallServo;
}
