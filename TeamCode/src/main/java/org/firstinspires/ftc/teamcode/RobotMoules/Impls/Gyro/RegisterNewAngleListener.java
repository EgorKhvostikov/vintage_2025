package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;

public class RegisterNewAngleListener implements IEvent<AngleListener> {

    private final AngleListener data;

    public RegisterNewAngleListener(AngleListener data) {
        this.data = data;
    }

    @Override
    public AngleListener getData() {
        return data;
    }

}
