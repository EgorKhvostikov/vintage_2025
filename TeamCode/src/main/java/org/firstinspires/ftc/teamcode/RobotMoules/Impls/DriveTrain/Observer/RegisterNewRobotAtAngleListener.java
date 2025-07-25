package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.Observer;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;
import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IListener;

public class RegisterNewRobotAtAngleListener implements IEvent<IListener<Boolean>> {
    private final IListener<Boolean> data;

    public RegisterNewRobotAtAngleListener(IListener<Boolean> data) {
        this.data = data;
    }

    @Override
    public IListener<Boolean> getData() {
        return data;
    }
}
