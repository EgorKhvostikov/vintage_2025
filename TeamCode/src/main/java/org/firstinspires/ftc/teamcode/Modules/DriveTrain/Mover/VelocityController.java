package org.firstinspires.ftc.teamcode.Modules.DriveTrain.Mover;

import org.firstinspires.ftc.teamcode.Math.Position;
import org.firstinspires.ftc.teamcode.Task.MoveTask;

import java.util.ArrayList;

public class VelocityController {
    ArrayList<MoveTask> taskQueue;
    private boolean isWallNear = false;

    MoveTask pushForward = new MoveTask(2,
            new Position(12,0,0)
    );

    MoveTask goToWall = new MoveTask(()->isWallNear,
            new Position(12,0,0)
    );

    MoveTask rotateRight = new MoveTask(1,
            new Position(6,0,12)
    );

    MoveTask rotateLeft = new MoveTask(1,
            new Position(6,0,-12)
    );


    public void init(){
        taskQueue.add(pushForward);
    }
}
