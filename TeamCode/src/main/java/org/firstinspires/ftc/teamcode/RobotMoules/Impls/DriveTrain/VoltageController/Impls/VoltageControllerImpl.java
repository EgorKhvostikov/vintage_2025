package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.VoltageController.Impls;

import static java.lang.Math.max;

import org.firstinspires.ftc.teamcode.Config.PidsConfig;
import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.NewVoltageAvailable;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Observer.DriveTargetListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Observer.RegisterNewDriveTargetListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.Observer.RegisterNewRobotAtAngleListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.Observer.RobotAtAngleObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.VoltageController.Interface.VoltageController;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Observer.AngleListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Observer.RegisterNewAngleListener;
import org.firstinspires.ftc.teamcode.Util.Math.Pid.Pid;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

public class VoltageControllerImpl implements VoltageController, IEventUser, AngleListener, DriveTargetListener {
    private Motor rightDrive;
    private Motor leftDrive;

    private Double voltage = 12d;
    private Position target = new Position();

    private double angle = 0;

    private final RobotAtAngleObserver atAngleObserver = new RobotAtAngleObserver();

    private final Pid pid = new Pid(PidsConfig.anglePidConfig);
    {
        pid.isAngle = true;
    }

    @Override
    public void lateUpdate() {
        pid.setTarget(target.h);
        pid.setPos(angle);
        pid.update();
        setVoltage(target.x, pid.getU());

        boolean atAngle = Math.abs( Position.normalizeAngle(pid.getPos()-target.h) ) < 5;
        atAngleObserver.notifyListeners(atAngle);
    }


    public void onEvent(NewVoltageAvailable e){
       voltage = e.getData();
    }

    public void onEvent(RegisterNewRobotAtAngleListener l){
        atAngleObserver.register(l.getData());
    }

    @Override
    public void init() {
        rightDrive = DevicePool.getInstance().rightDrive;
         leftDrive = DevicePool.getInstance(). leftDrive;

        EventBus.getInstance().invoke(new RegisterNewAngleListener(this));
        EventBus.getInstance().invoke(new RegisterNewDriveTargetListener(this));

    }

    @Override
    public void subscribeInit(){
        EventBus.getInstance().subscribe(NewVoltageAvailable.class,this::onEvent);
        EventBus.getInstance().subscribe(RegisterNewRobotAtAngleListener.class,this::onEvent);
    }

    public void setVoltage(double x, double h){
        double rightVoltage    = x - h;
        double leftVoltage     = x + h;

        double maxTargetVoltage = max(rightVoltage, leftVoltage);


        if (maxTargetVoltage > voltage) {
            double k = voltage / maxTargetVoltage;
            rightVoltage *= k;
            leftVoltage  *= k;
        }

        rightDrive.setPower( rightVoltage/voltage);
        leftDrive .setPower( leftVoltage /voltage);
    }

    @Override
    public void setAngle(Double angle) {
        this.angle = angle;
    }

    @Override
    public void setDriveTarget(Position t) {
        target = t;
    }
}
