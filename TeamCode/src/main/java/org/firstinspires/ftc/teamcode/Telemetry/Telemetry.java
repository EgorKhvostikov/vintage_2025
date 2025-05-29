package org.firstinspires.ftc.teamcode.Telemetry;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;

import org.firstinspires.ftc.teamcode.Events.Event;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Events.EventUser;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;

public class Telemetry implements EventUser, IUpdatable {
    private static final Telemetry instance = new Telemetry();
    public static Telemetry getInstance() {
        return instance;
    }
    public static void load(){}
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
            FtcDashboard.getInstance().sendTelemetryPacket(telemetryPacket);
            telemetryPacket = new TelemetryPacket();
        }
    }
    @Override
    public void init(){
        int q;
    }
}
