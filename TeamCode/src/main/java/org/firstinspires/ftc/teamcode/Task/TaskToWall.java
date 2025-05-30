package org.firstinspires.ftc.teamcode.Task;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Math.Position;

public class TaskToWall extends MoveTask {
    private final ElapsedTime timer = new ElapsedTime();
    private boolean isRunOnce = false;
    @Override
    public void update() {
        if(!isRunOnce){
            isRunOnce = true;
            timer.reset();
        }
        if(!EventManager.getDefault().wallNear.data && (timer.seconds() < 5)){
            EventManager.getDefault().newTargetVelocity.publish(
                    new Position(0 ,0,EventManager.getDefault().newAngle.data)
            );
        }else{
            EventManager.getDefault().newMoveTask.publish(
                    new TaskRotate(EventManager.getDefault().newAngle.data+30,new TaskToWall()));

        }
    }
}
