package org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Impls;

import org.firstinspires.ftc.teamcode.Config.WallFinderConfig;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Button.Button;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Intarface.Sonar;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Interface.WallFinder;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer.WallFinderObserver;

public class WallFinderImpl implements WallFinder, IEventUser {
    private final WallFinderObserver observer = new WallFinderObserver();

    @Override
    public void update() {
        byte sonarDist = sonar.read();
        boolean sonar = sonarDist< WallFinderConfig.wallFindDistance;
        boolean button = buttonRight.getState() || buttonLeft.getState();
        boolean voltage = (motorLeft.getCurrent()+ motorRight.getCurrent())*0.5 > WallFinderConfig.wallFindVoltage;

        observer.notifyListeners(sonar||button||voltage);

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
    }
}
