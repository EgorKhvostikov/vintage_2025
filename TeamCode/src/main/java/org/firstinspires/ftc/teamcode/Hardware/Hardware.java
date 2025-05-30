package org.firstinspires.ftc.teamcode.Hardware;

import static org.firstinspires.ftc.teamcode.Hardware.ColorSensorFix.fix;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.teamcode.Sonar.I2cPort;


public class Hardware {
    public static HardwareMap hardwareMap;

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

    public static DigitalChannel rightButton;
    public static DigitalChannel leftButton;

    private static void initButtons(HardwareMap map){
        rightButton = map.get(DigitalChannel.class, "rightButton");
        leftButton =  map.get(DigitalChannel.class, "leftButton");
    }

    public static VoltageSensor voltageSensor;

    private static void initVoltageSensor(HardwareMap map){
        voltageSensor = map.voltageSensor.get("Control Hub");
    }

    public static I2cPort arduino;

    private static void initSonar(HardwareMap map){
        arduino = map.get(I2cPort.class, "arduinonano");
    }

    private static void motorsReset(){
        separatorMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightDrive.setDirection(DcMotorSimple.Direction.FORWARD);
        leftDrive.setDirection(DcMotorSimple.Direction.FORWARD);

        separatorMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        separatorMotor .setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDrive   .setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive   .setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    public static void init(HardwareMap map){
        hardwareMap = map;
        initDriveMotors   (map);
        initColorSensor   (map);
        initSeparatorMotor(map);
        initBrushMotor    (map);
        initVoltageSensor (map);
        initWallServo     (map);
        initButtons       (map);
        initSonar         (map);
        motorsReset();
    }
}
