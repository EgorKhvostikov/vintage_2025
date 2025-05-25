package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Hardware.ColorSensorFix.fix;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

public class Hardware {
    public static DcMotorEx rightDrive;
    public static DcMotorEx leftDrive;

    private static void initDriveMotors(HardwareMap map) {
        rightDrive = map.get(DcMotorEx.class, "rightDrive");
        leftDrive = map.get(DcMotorEx.class, "leftDrive");
    }


    public static AdafruitI2cColorSensor baseSensor;
    public static AdafruitI2cColorSensor puckSensor;

    private static void initColorSensor(HardwareMap map) {
        puckSensor = fix(map.get(AdafruitI2cColorSensor.class, "puckSensor"));
        baseSensor = fix(map.get(AdafruitI2cColorSensor.class, "baseSensor"));
    }


    public static DcMotorEx separatorMotor;

    private static void initSeparatorMotor(HardwareMap map){
        separatorMotor = leftDrive = map.get(DcMotorEx.class, "separatorMotor");
    }

    public static VoltageSensor voltageSensor;

    private static void initVoltageSensor(HardwareMap map){
        voltageSensor = map.voltageSensor.get("Control Hub");
    }


    public void init(HardwareMap map){
        initDriveMotors   (map);
        initColorSensor   (map);
        initSeparatorMotor(map);
        initVoltageSensor (map);
    }
}
