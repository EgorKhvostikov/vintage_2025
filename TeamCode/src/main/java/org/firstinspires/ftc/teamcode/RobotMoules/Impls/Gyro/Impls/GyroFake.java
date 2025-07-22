package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Impls;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Interface.Gyro;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Observer.AngleObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Observer.RegisterNewAngleListener;

@Config
public class GyroFake implements Gyro, IEventUser {
    public static double angle = 0;

    private final AngleObserver observer = new AngleObserver();

    @Override
    public void subscribeInit() {
        EventBus.getInstance().subscribe(RegisterNewAngleListener.class,this::onEvent);
    }

    public void onEvent(RegisterNewAngleListener l){
        observer.register(l.getData());
    }

    @Override
    public void update(){
        observer.notifyListeners(angle);
    }
}
