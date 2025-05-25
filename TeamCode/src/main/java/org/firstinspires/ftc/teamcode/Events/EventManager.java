package org.firstinspires.ftc.teamcode.Events;


import org.firstinspires.ftc.teamcode.Color.ColorState;
import org.firstinspires.ftc.teamcode.Math.Position;

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
}
