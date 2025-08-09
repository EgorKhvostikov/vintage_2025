package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Event.NewMoveTask;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

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
        isRunOnce = true;
        //TODO change 0 to camera puck angle
        if(timer.seconds()<delay){
            velocity = new Position(12,0,0);
        }else{
            EventBus.getInstance().invoke(  new NewMoveTask(new TaskRotate(90,new TaskToWall()) ));
        }

    }
}
