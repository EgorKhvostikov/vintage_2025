package org.firstinspires.ftc.teamcode.Task;

import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Math.Position;

public class TaskToWall extends MoveTask {
    @Override
    public void update() {
        if(!EventManager.getDefault().wallNear.data){
            EventManager.getDefault().newTargetVelocity.publish(
                    new Position(12,0,EventManager.getDefault().newAngle.data)
            );
        }else{
            EventManager.getDefault().newMoveTask.publish(
                    new TaskRotate(EventManager.getDefault().newAngle.data+30,new TaskToWall()));

        }
    }
}
