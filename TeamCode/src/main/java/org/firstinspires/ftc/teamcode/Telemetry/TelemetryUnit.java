package org.firstinspires.ftc.teamcode.Telemetry;

public class TelemetryUnit <T> {
    private final T data;
    private final String name;

    public T getData() {
        return data;
    }

    public String getName() {
        return name;
    }

    public TelemetryUnit(T data, String name) {
        this.data = data;
        this.name = name;
    }
}
