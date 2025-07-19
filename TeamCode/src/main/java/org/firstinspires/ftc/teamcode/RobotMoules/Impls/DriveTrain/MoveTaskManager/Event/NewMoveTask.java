package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Event;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Task.MoveTask;

public class NewMoveTask implements IEvent<MoveTask> {
    private final MoveTask data;

    public NewMoveTask(MoveTask data) {
        this.data = data;
    }

    @Override
    public MoveTask getData() {
        return data;
    }

}
