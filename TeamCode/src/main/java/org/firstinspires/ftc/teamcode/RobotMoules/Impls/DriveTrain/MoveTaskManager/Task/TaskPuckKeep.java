package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Event.NewMoveTask;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

public class TaskPuckKeep extends MoveTask{

    public TaskPuckKeep(MoveTask nextTask) {
        this.nextTask = nextTask;
    }

    private final MoveTask nextTask;
    private boolean isRunOnce = false;

    @Override
    public void update() {
        if(!isRunOnce){
            timer.reset();
        }
        isRunOnce = true;
        if(timer.seconds()<2){
            velocity = new Position(-6,0,0);

        }else{
            EventBus.getInstance().invoke( new NewMoveTask(nextTask) );
        }
    }

}
