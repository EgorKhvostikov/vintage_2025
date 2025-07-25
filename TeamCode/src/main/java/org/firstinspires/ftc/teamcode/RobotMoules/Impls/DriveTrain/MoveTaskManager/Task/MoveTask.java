package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

public abstract class MoveTask {

    protected ElapsedTime timer = new ElapsedTime();

    protected Position velocity = new Position();

    public abstract void update();

    public Position getVelocity(){
        return velocity;
    }

}