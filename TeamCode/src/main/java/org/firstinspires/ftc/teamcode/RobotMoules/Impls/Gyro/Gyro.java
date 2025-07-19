package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Interface.IRobotModule;

public class Gyro implements IRobotModule, IEventUser {

    private final AngleObserver observer = new AngleObserver();
    private IMU imu;
    private final ElapsedTime timer = new ElapsedTime();

    public void init() {
        imu = DevicePool.getInstance().gyro;
        RevHubOrientationOnRobot orientationOnRobot = new RevHubOrientationOnRobot
                (RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.RIGHT);
        imu.initialize(new IMU.Parameters(orientationOnRobot));
        reset();
        EventBus.getInstance().subscribe(RegisterNewAngleListener.class,this::onEvent);
    }

    public  void reset() {imu.resetYaw();}

    @Override
    public  void update() {
        if(timer.seconds()>0.05) {
            double angle = -imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);
            observer.notifyListeners(angle);
            timer.reset();
        }
    }

    public void onEvent(RegisterNewAngleListener l){
        observer.register(l.getData());
    }
}
