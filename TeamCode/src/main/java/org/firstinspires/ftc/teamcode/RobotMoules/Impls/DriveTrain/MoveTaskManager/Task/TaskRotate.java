package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Event.NewMoveTask;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.Observer.RegisterNewRobotAtAngleListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IListener;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

public class TaskRotate extends MoveTask implements IListener<Boolean> {

    public TaskRotate(double angle, MoveTask nextTask) {
        this.angle = angle;
        this.nextTask = nextTask;
        EventBus.getInstance().invoke(new RegisterNewRobotAtAngleListener(this));
    }

    @Override
    public void set(Boolean data) {
        atAngle = data;
    }

    private final MoveTask nextTask;
    private final double angle;
    private boolean isRunOnce = false;
    private boolean atAngle = false;

    @Override
    public void update() {
        if(!isRunOnce){
            timer.reset();
        }

        if((!isRunOnce || !atAngle)  && timer.seconds() < 0.5){
            velocity = new Position(-6,0,angle);
        }else{
            atAngle = false;
            EventBus.getInstance().invoke( new NewMoveTask(nextTask) );
        }

        isRunOnce = true;
    }

}
