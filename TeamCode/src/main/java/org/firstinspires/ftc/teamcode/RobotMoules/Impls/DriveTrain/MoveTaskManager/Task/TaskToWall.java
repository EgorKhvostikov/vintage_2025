package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Event.NewMoveTask;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Observer.AngleListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Observer.RegisterNewAngleListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer.RegisterNewWallFinderListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer.WallFinderListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer.WallFinderStatus;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

public class TaskToWall extends MoveTask implements AngleListener, WallFinderListener {
    public static int direction = 1;
    public TaskToWall() {
        EventBus.getInstance().invoke(new RegisterNewWallFinderListener(this));
        EventBus.getInstance().invoke(new RegisterNewAngleListener(this));
    }

    private boolean isRunOnce = false;
    private double angle = 0;
    private WallFinderStatus wallNear = new WallFinderStatus(false,false,false);

    @Override
    public void update() {
        if(!isRunOnce){
            timer.reset();
            isRunOnce = true;
        }
        if( ((!wallNear.getOr() && (timer.seconds() < 2.5))) || timer.seconds() < 0.5 ){
            velocity = new Position(12 ,0,angle);
        }else{
            if(wallNear.sonar){
                EventBus.getInstance().invoke(new NewMoveTask(new TaskSplineRotate(angle + 100*Math.signum(direction), new TaskToWall())));
            }else {
                EventBus.getInstance().invoke(new NewMoveTask(new TaskRotate(angle + 100*Math.signum(direction), new TaskToWall())));
            }
        }
    }

    @Override
    public void setAngle(Double angle) {
        this.angle = angle;
    }

    @Override
    public void setWallFindState(WallFinderStatus data) {
        wallNear = data;
    }
}
