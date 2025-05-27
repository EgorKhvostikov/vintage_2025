package org.firstinspires.ftc.teamcode.Telemetry;


import com.acmerobotics.dashboard.telemetry.TelemetryPacket;

import org.firstinspires.ftc.teamcode.Events.Event;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Events.EventUser;

public class Telemetry implements EventUser {
    private static final Telemetry instance = new Telemetry();
    public static Telemetry getInstance() {
        return instance;
    }
    static {
        EventManager.getDefault().telemtryEvent.subscribe(instance);
        EventManager.getDefault().mainLoopEnd  .subscribe(instance);
    }
    private TelemetryPacket telemetryPacket = new TelemetryPacket();
    @Override
    public void onEvent(Event<?> e) {
        if(e == EventManager.getDefault().telemtryEvent){
            telemetryPacket.put( ((TelemetryUnit<?>) e.data).string, ((TelemetryUnit<?>) e.data).data );
        }
        if(e == EventManager.getDefault().mainLoopEnd){
            telemetryPacket = new TelemetryPacket();
        }
    }
}
