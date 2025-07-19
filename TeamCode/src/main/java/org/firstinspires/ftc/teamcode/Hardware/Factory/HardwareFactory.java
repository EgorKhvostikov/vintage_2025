package org.firstinspires.ftc.teamcode.Hardware.Factory;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;


import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.Button;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.ButtonImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls.Eve3MotorImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Impls.SonarImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Intarface.Sonar;
import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Impls.VoltageSensorImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Interface.VoltageSensor;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.I2CPort.I2cPort;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Impls.ColorSensorFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Impls.ColorSensorImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls.DcMotorFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Impls.DcMotorImpl;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Impls.ServoFake;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Interface.Servo;

public class HardwareFactory {
    private final HardwareMap hardwareMap;
    private final ServiceActivatorConfig serviceActivatorConfig;

    public HardwareFactory(HardwareMap hardwareMap, ServiceActivatorConfig serviceActivatorConfig) {
        this.hardwareMap = hardwareMap;
        this.serviceActivatorConfig = serviceActivatorConfig;
    }

    public Motor createDcMotor(String name){
        if(serviceActivatorConfig.isMotorsActive) {
            return new DcMotorImpl();
        }else{
            return new DcMotorFake();
        }
    }
    public Motor createEve3Motor(String name){
        if(serviceActivatorConfig.isMotorsActive) {
            return new Eve3MotorImpl();
        }else{
            return new DcMotorFake();
        }
    }

    public Servo createServo(String name){
        if(serviceActivatorConfig.isServosActive){
            return hardwareMap.get(Servo.class,name);
        }else{
            return new ServoFake();
        }
    }

    public ColorSensor createColorSensor(String name){
        if(serviceActivatorConfig.isColorSensorsActive){
            return new ColorSensorImpl();
        }else{
            return new ColorSensorFake();
        }
    }

    public VoltageSensor createVoltageSensor(String name){
        if(serviceActivatorConfig.isColorSensorsActive){
            return new VoltageSensorImpl();
        }else{
            return new VoltageSensorImpl();
        }
    }

    public IMU createIMU(){
        return hardwareMap.get(IMU.class, "imu");
    }

    public Sonar createSonar(String name){
        return new SonarImpl(hardwareMap.get(I2cPort.class, name));
    }

    public Button createButton(String name){
        return new ButtonImpl();
    }
}
