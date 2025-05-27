package org.firstinspires.ftc.teamcode.Task;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Math.Position;

import java.util.function.Supplier;

public class MoveTask {
    Supplier<Boolean> endCondition;
    Position run;
    public ElapsedTime timer = new ElapsedTime();

    public MoveTask(double delay, Position run) {
        endCondition = ()->timer.seconds()>delay;
        this.run = run;
    }

    public MoveTask(Supplier<Boolean> endCondition, Position run) {
        this.endCondition = endCondition;
        this.run = run;
    }

    private boolean isRunOnce = false;
    public Position get(){
        if(!isRunOnce){
            timer.reset();
        }
        isRunOnce = true;
        if(!endCondition.get()){
            return run;
        }else{
            return null;
        }
    }

}
