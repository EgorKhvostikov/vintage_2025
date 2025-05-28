package org.firstinspires.ftc.teamcode.Events;


import org.firstinspires.ftc.teamcode.Color.ColorState;
import org.firstinspires.ftc.teamcode.Math.Position;
import org.firstinspires.ftc.teamcode.Task.MoveTask;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

public class EventManager{
    private static final EventManager Default = new EventManager();
    public static EventManager getDefault(){
        return Default;
    }

    public Event<ColorState> nowOnBase    = new Event<>();
    public Event<Boolean> arriveOnBase = new Event<>();

    public Event<Boolean> halfOfGame          = new Event<>();

    public Event<Double>  newVoltageAvailable = new Event<>();
    public Event<Position> newTargetVelocity  = new Event<>();

    public Event<ColorState> newPuckInSeparator       = new Event<>();

    public Event<TelemetryUnit<?>> telemtryEvent = new Event<>();

    public Event<Long> mainLoopEnd = new Event<>();

    public Event<MoveTask> newMoveTask = new Event<>();

    public Event<Double> newAngle = new Event<>();

    public Event<Boolean> robotAtAngle = new Event<>();

    public Event<Boolean> wallNear = new Event<>();

}
