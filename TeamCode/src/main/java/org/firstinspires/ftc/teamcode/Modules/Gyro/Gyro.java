package org.firstinspires.ftc.teamcode.Modules.Gyro;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;

public class Gyro implements IUpdatable {
    public static void load(){}
    static  {
        MainUpdater.getInstance().addModule(Gyro.class);
    }

    public Gyro() {
    }

    private IMU imu;
    private final ElapsedTime timer = new ElapsedTime();

    public void init() {
        imu = Hardware.hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot
                (RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.RIGHT);
        imu.initialize(new IMU.Parameters(orientationOnRobot));
        reset();
    }

    public  void reset() {imu.resetYaw();}

    @Override
    public  void update() {
        if(timer.seconds()>0.05) {
            double angle = -imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
            EventManager.getDefault().newAngle.publish(angle);
            timer.reset();
        }
    }

}
