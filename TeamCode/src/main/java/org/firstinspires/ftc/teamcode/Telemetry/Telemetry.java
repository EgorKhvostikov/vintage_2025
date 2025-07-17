package org.firstinspires.ftc.teamcode.Telemetry;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;

import org.firstinspires.ftc.teamcode.EventBus.Events.MainLoopEnd;
import org.firstinspires.ftc.teamcode.EventBus.Events.TelemetryEvent;

public class Telemetry {
    private static final Telemetry Instance = new Telemetry();
    public static Telemetry getInstance() {return Instance;}
    private TelemetryPacket telemetryPacket = new TelemetryPacket();

    public void onEvent(MainLoopEnd e) {
        FtcDashboard.getInstance().sendTelemetryPacket(telemetryPacket);
        telemetryPacket = new TelemetryPacket();
    }

    public void onEvent(TelemetryEvent<?> e){
        telemetryPacket.put( e.getData().getName(), e.getData().getData());
    }
}
