package org.firstinspires.ftc.teamcode.Task;

import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Math.Position;

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
        if(timer.seconds()<2){
            EventManager.getDefault().newTargetVelocity.publish(
                    new Position(-6,0,0)
            );
        }else{
            EventManager.getDefault().newMoveTask.publish(nextTask);
        }
        isRunOnce = true;
    }
}
