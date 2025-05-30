package org.firstinspires.ftc.teamcode.Modules.DriveTrain.Mover;


import org.firstinspires.ftc.teamcode.Config.ActiveServiceList;
import org.firstinspires.ftc.teamcode.Events.Event;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Events.EventUser;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;
import org.firstinspires.ftc.teamcode.Task.MoveTask;

import org.firstinspires.ftc.teamcode.Task.TaskPuckKeep;
import org.firstinspires.ftc.teamcode.Task.TaskPushCenter;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

public class MoveTaskManager implements IUpdatable, EventUser {
    static  {
        if(ActiveServiceList.autoDriveTrain){
            MainUpdater.getInstance().addModule(MoveTaskManager.class);
        }
    }
    public static void load(){}
    @Override
    public void init(){
        EventManager.getDefault().arriveOnBase.subscribe(this);
        EventManager.getDefault().halfOfGame  .subscribe(this);
        EventManager.getDefault().newMoveTask .subscribe(this);
    }

    private MoveTask actualTask = new TaskPushCenter(2);

    @Override
    public void update(){
        actualTask.update();
        EventManager.getDefault().telemtryEvent.publish(
                new TelemetryUnit<>("actualMoveTask",
                        actualTask.getClass().getSimpleName()
                ));
    }

    @Override
    public void onEvent(Event<?> e) {
        if(e == EventManager.getDefault().arriveOnBase){
            if(! (actualTask instanceof TaskPushCenter)) {
                actualTask = new TaskPuckKeep(new TaskPushCenter(2));
            }
        }

        if(e == EventManager.getDefault().newMoveTask){
            actualTask = (MoveTask) e.data;
        }
    }
}
