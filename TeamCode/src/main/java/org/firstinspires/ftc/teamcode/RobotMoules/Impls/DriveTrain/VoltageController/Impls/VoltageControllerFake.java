package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.VoltageController.Impls;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.Observer.RegisterNewRobotAtAngleListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.Observer.RobotAtAngleObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.VoltageController.Interface.VoltageController;

@Config
public class VoltageControllerFake implements VoltageController {
    public static boolean atAngle = false;

    private final RobotAtAngleObserver atAngleObserver = new RobotAtAngleObserver();

    public void onEvent(RegisterNewRobotAtAngleListener l){
        atAngleObserver.register(l.getData());
    }

    public void subscribeInit(){
        EventBus.getInstance().subscribe(RegisterNewRobotAtAngleListener.class,this::onEvent);
    }

    @Override
    public void lateUpdate(){
        atAngleObserver.notifyListeners(atAngle);
    }

}
