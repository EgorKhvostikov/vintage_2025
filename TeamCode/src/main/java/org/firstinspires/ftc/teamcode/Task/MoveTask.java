package org.firstinspires.ftc.teamcode.Task;

import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class MoveTask {

    protected ElapsedTime timer = new ElapsedTime();

    public abstract void update();

}
