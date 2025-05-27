package org.firstinspires.ftc.teamcode.Telemetry;

public class TelemetryUnit<T> {
    String string;
    T data;

    public TelemetryUnit(String string, T data) {
        this.string = string;
        this.data = data;
    }
}
