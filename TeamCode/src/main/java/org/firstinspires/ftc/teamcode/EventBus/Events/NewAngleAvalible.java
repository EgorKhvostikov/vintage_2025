package org.firstinspires.ftc.teamcode.EventBus.Events;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;

public class NewAngleAvalible implements IEvent<Double> {
    @Override
    public Double getData() {
        return 0.0;
    }
}
