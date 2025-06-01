package org.firstinspires.ftc.teamcode.Task;

import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Math.Position;

public class TaskPushCenter extends MoveTask{

    public TaskPushCenter(double delay) {
        this.delay = delay;
    }

    private final double delay;
    private boolean isRunOnce = false;
    @Override
    public void update() {
        if(!isRunOnce){
            timer.reset();
        }
        if(timer.seconds()<delay){
            EventManager.getDefault().newTargetVelocity.publish(new Position(12,0,0));
        }else{
            EventManager.getDefault().newMoveTask.publish(new TaskRotate(-45,new TaskToWall()));
        }
        isRunOnce = true;
    }
}
