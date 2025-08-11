package org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Impls;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Config.WallFinderConfig;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.Button;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Intarface.Sonar;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task.TaskToWall;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Interface.WallFinder;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer.WallFinderObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer.WallFinderStatus;
import org.firstinspires.ftc.teamcode.Telemetry.Telemetry;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

public class WallFinderImpl implements WallFinder, IEventUser {
    private final WallFinderObserver observer = new WallFinderObserver();
    private final ElapsedTime timer = new ElapsedTime();

    @Override
    public void update() {
        byte sonarDist = sonar.read();
        boolean sonar;
        if(timer.seconds()<60) {
            TaskToWall.direction = 1;
            sonar = sonarDist < WallFinderConfig.wallFindDistance && sonarDist > 0;
        }else{
            TaskToWall.direction = -1;
            sonar = sonarDist < WallFinderConfig.wallFindLateDistance && sonarDist > 0;
        }
        boolean button = !buttonRight.getState() || !buttonLeft.getState();
        boolean voltage = (motorLeft.getCurrent()+ motorRight.getCurrent())*0.5 > WallFinderConfig.wallFindVoltage;

        observer.notifyListeners( new WallFinderStatus(sonar,voltage,button) );

        Telemetry.getInstance().add(new TelemetryUnit<>(sonar,"sonar"));
        Telemetry.getInstance().add(new TelemetryUnit<>(button,"button"));
        Telemetry.getInstance().add(new TelemetryUnit<>(voltage,"voltage"));
    }

    private Sonar  sonar;
    private Button buttonRight;
    private Button buttonLeft ;
    private Motor motorRight;
    private Motor motorLeft ;

    @Override
    public void init(){
        motorRight = DevicePool.getInstance().rightDrive;
        motorLeft = DevicePool.getInstance().leftDrive;

        buttonLeft = DevicePool.getInstance().leftButton;
        buttonRight = DevicePool.getInstance().rightButton;

        sonar = DevicePool.getInstance().sonar;

        timer.reset();
    }
}
