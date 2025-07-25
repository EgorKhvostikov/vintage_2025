package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Impls;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.ArriveOnBase;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Event.NewMoveTask;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Interface.MoveTaskManager;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Observer.DriveTargetObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task.MoveTask;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task.TaskPuckKeep;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task.TaskPushCenter;

public class MoveTaskManagerImpl implements MoveTaskManager, IEventUser {
    private MoveTask actualTask = new TaskPushCenter(2);
    private final DriveTargetObserver observer = new DriveTargetObserver();

    @Override
    public void update() {
        actualTask.update();
        observer.notifyListeners(actualTask.getVelocity());
    }

    public void onEvent(ArriveOnBase e){
        if(! (actualTask instanceof TaskPushCenter) ) {
            actualTask = new TaskPuckKeep(new TaskPushCenter(2));
        }
    }

    public void onEvent(NewMoveTask e){
        actualTask = e.getData();
    }

    @Override
    public void init(){
        EventBus.getInstance().subscribe(ArriveOnBase.class,this::onEvent);
        EventBus.getInstance().subscribe(NewMoveTask.class,this::onEvent);
    }
}
