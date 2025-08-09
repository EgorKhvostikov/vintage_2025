package org.firstinspires.ftc.teamcode.Hardware.Factory;

import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.Button;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.ButtonFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.ButtonImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls.Eve3MotorImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Impls.ServoImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Impls.SonarFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Impls.SonarImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Intarface.Sonar;
import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Impls.RevVoltageSensorFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Impls.RevVoltageSensorImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Interface.RevVoltageSensor;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.I2CPort.I2cPort;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Impls.ColorSensorFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Impls.ColorSensorImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls.DcMotorFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls.DcMotorImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Impls.ServoFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Interface.ServoMotor;
import org.firstinspires.ftc.teamcode.Util.Color.RgbColorVector;

public class HardwareFactory {
    private final HardwareMap hardwareMap;
    private final ServiceActivatorConfig serviceActivatorConfig;

    public HardwareFactory(HardwareMap hardwareMap, ServiceActivatorConfig serviceActivatorConfig) {
        this.hardwareMap = hardwareMap;
        this.serviceActivatorConfig = serviceActivatorConfig;
    }

    public Motor createDcMotor(String name,Double pos,Double vol){
        if(serviceActivatorConfig.isMotorsActive) {
            return new DcMotorImpl(hardwareMap.get(DcMotorEx.class,name));
        }else{
            return new DcMotorFake(pos,vol);
        }
    }
    public Motor createEve3Motor(String name,Double pos,Double vol){
        if(serviceActivatorConfig.isMotorsActive) {
            DcMotorEx motor = hardwareMap.get(DcMotorEx.class,name);
            motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            return new Eve3MotorImpl(motor);
        }else{
            return new DcMotorFake(pos,vol);
        }
    }

    public ServoMotor createServo(String name){
        if(serviceActivatorConfig.isServosActive){
            return new ServoImpl(hardwareMap.get(Servo.class,name));
        }else{
            return new ServoFake();
        }
    }

    public ColorSensor createColorSensor(String name, RgbColorVector vector){
        if(serviceActivatorConfig.isColorSensorsActive){
            return new ColorSensorImpl(hardwareMap.get(AdafruitI2cColorSensor.class,name));
        }else{
            return new ColorSensorFake(vector);
        }
    }

    public RevVoltageSensor createVoltageSensor(){
        if(serviceActivatorConfig.isColorSensorsActive){
            return new RevVoltageSensorImpl(hardwareMap.voltageSensor.get("Control Hub"));
        }else{
            return new RevVoltageSensorFake();
        }
    }

    public IMU createIMU(){
        return hardwareMap.get(IMU.class, "imu");
    }

    public Sonar createSonar(String name,Byte dist){
       if(serviceActivatorConfig.isSonarActive){
           return new SonarImpl(hardwareMap.get(I2cPort.class, name));
       }else {
           return new SonarFake(dist);
       }
    }

    public Button createButton(String name,Boolean check){
        if(serviceActivatorConfig.isButtonActive){
            return new ButtonImpl(hardwareMap.get(DigitalChannel.class,name));
        }else{
            return new ButtonFake(check);
        }
    }
}
