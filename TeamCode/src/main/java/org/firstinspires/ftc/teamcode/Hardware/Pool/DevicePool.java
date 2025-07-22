package org.firstinspires.ftc.teamcode.Hardware.Pool;



import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Hardware.Factory.HardwareFactory;

import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.Button;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.ButtonsConfig;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.ColorSensorConfig;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;

import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.MotorsConfig;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Interface.ServoMotor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Intarface.Sonar;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.SonarConifg;
import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Interface.RevVoltageSensor;

public class DevicePool {
    private static final DevicePool Instance = new DevicePool();

    public static DevicePool getInstance() {
        return Instance;
    }

    public void init(HardwareFactory factory){
         rightDrive = factory.createDcMotor("rightDrive",MotorsConfig.rightDrivePos,MotorsConfig.rightDriveVol);
         leftDrive = factory.createDcMotor( "leftDrive", MotorsConfig.leftDrivePos,MotorsConfig.leftDriveVol);

         separatorMotor = factory.createEve3Motor("leftDrive", MotorsConfig.separatorPos,MotorsConfig.separatorVol);

         baseSensor = factory.createColorSensor("baseSensor", ColorSensorConfig.rgbBase);
         puckSensor = factory.createColorSensor("puckSensor", ColorSensorConfig.rgbPuck);

         backWallServo = factory.createServo("backWallServo");

         revVoltageSensor = factory.createVoltageSensor();

         gyro = factory.createIMU();

         sonar = factory.createSonar("nano", SonarConifg.dist);

         rightButton = factory.createButton("rightButton", ButtonsConfig.rightButton);
         leftButton  = factory.createButton("leftButton",  ButtonsConfig.rightButton);
    }

    public Motor rightDrive;
    public Motor leftDrive ;

    public Motor separatorMotor;

    public ColorSensor baseSensor;
    public ColorSensor puckSensor;

    public ServoMotor backWallServo;

    public RevVoltageSensor revVoltageSensor;

    public IMU gyro;

    public Sonar sonar;

    public Button rightButton;
    public Button leftButton;

}
