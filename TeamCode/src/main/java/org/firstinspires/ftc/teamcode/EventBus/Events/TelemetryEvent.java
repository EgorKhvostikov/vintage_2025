package org.firstinspires.ftc.teamcode.EventBus.Events;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

public class TelemetryEvent<T> implements IEvent<TelemetryUnit<T>> {
    @Override
    public TelemetryUnit<T> getData() {
        return null;
    }
}
