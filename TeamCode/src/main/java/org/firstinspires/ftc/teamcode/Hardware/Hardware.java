package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Hardware.ColorSensorFix.fix;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.VoltageSensor;

public class Hardware {
    public static DcMotorEx rightDrive;
    public static DcMotorEx leftDrive;

    private static void initDriveMotors(HardwareMap map) {
        rightDrive = map.get(DcMotorEx.class, "rightDrive");
        leftDrive  = map.get(DcMotorEx.class, "leftDrive");
    }

    public static AdafruitI2cColorSensor baseSensor;
    public static AdafruitI2cColorSensor puckSensor;

    private static void initColorSensor(HardwareMap map) {
        puckSensor = fix(map.get(AdafruitI2cColorSensor.class, "puckSensor"));
        baseSensor = fix(map.get(AdafruitI2cColorSensor.class, "baseSensor"));
    }

    public static DcMotorEx separatorMotor;

    private static void initSeparatorMotor(HardwareMap map){
        separatorMotor = map.get(DcMotorEx.class, "separatorMotor");
    }

    public static DcMotorEx brushMotor;

    private static void initBrushMotor(HardwareMap map){
        brushMotor = map.get(DcMotorEx.class, "brushMotor");
    }

    public static Servo wallServo;

    private static void initWallServo(HardwareMap map){
        wallServo = map.get(Servo.class, "wallServo");
    }

    public static TouchSensor rightButton;
    public static TouchSensor leftButton;

    private static void initButtons(HardwareMap map){
        rightButton = map.get(TouchSensor.class, "rightButton");
        leftButton = map.get(TouchSensor.class, "leftButton");
    }

    public static VoltageSensor voltageSensor;

    private static void initVoltageSensor(HardwareMap map){
        voltageSensor = map.voltageSensor.get("Control Hub");
    }


    public static void init(HardwareMap map){
        initDriveMotors   (map);
        initColorSensor   (map);
        initSeparatorMotor(map);
        initBrushMotor    (map);
        initVoltageSensor (map);
        initWallServo     (map);
        initButtons       (map);
    }
}
