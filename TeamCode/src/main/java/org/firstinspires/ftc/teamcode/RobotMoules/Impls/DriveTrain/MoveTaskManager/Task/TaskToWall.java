package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Event.NewMoveTask;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Observer.AngleListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Observer.RegisterNewAngleListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer.WallFinderListener;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

public class TaskToWall extends MoveTask implements AngleListener, WallFinderListener {

    public TaskToWall() {
        EventBus.getInstance().invoke(new RegisterNewAngleListener(this));
        EventBus.getInstance().invoke(new RegisterNewAngleListener(this));
    }

    private boolean isRunOnce = false;
    private double angle;
    private boolean wallNear = false;
    @Override
    public void update() {
        if(!isRunOnce){
            timer.reset();
            isRunOnce = true;
        }
        if((!wallNear && (timer.seconds() < 5)) ){
            velocity = new Position(12 ,0,angle);
        }else{
            EventBus.getInstance().invoke( new NewMoveTask(new TaskRotate(angle+15,new TaskToWall())) ) ;
        }
    }

    @Override
    public void setAngle(Double angle) {
        this.angle = angle;
    }

    @Override
    public void setWallFindState(boolean data) {
        wallNear = data;
    }
}
