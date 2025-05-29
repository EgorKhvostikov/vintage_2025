package org.firstinspires.ftc.teamcode.Task;

import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Math.Position;

public class TaskRotate extends MoveTask{

    public TaskRotate(double angle, MoveTask nextTask) {
        this.angle = angle;
        this.nextTask = nextTask;
    }

    private final MoveTask nextTask;
    private final double angle ;
    private boolean isRunOnce = false;
    @Override
    public void update() {
        if(!isRunOnce || !EventManager.getDefault().robotAtAngle.data){
            EventManager.getDefault().newTargetVelocity.publish(
                    new Position(0,0,angle)
            );
        }else{
            EventManager.getDefault().newMoveTask.publish(nextTask);
        }
        isRunOnce = true;
    }
}
