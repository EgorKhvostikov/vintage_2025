package org.firstinspires.ftc.teamcode.Task;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Math.Position;
import org.firstinspires.ftc.teamcode.OpModes.ModulesTests.SeparatorTest;

public class TaskToWall extends MoveTask {
    private final ElapsedTime timer = new ElapsedTime();
    private boolean isRunOnce = false;
    @Override
    public void update() {
        if(!isRunOnce){
            isRunOnce = true;
            timer.reset();
        }
        if((!EventManager.getDefault().wallNear.data && (timer.seconds() < 5)) ){
            EventManager.getDefault().newTargetVelocity.publish(
                    new Position(12 ,0,EventManager.getDefault().newAngle.data)
            );
        }else{
            double step = 15;
            if(SeparatorTest.timer.seconds()>60){
                step = - 15;
            }

            EventManager.getDefault().newMoveTask.publish(
                    new TaskRotate(EventManager.getDefault().newAngle.data+15,new TaskToWall()));

        }
    }
}
