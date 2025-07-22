package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Impls;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Interface.MoveTaskManager;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Observer.DriveTargetObserver;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

@Config
public class MoveTaskManagerFake implements MoveTaskManager {
    private final DriveTargetObserver observer = new DriveTargetObserver();
    public static Position target = new Position();

    @Override
    public void update(){
        observer.notifyListeners(target);
    }

}
