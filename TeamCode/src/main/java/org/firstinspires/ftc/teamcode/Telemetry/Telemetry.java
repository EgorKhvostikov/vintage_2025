package org.firstinspires.ftc.teamcode.Telemetry;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import org.firstinspires.ftc.teamcode.EventBus.Events.TelemetryEvent;

public class Telemetry{
    private static final Telemetry Instance = new Telemetry();
    public static Telemetry getInstance() {return Instance;}
    private TelemetryPacket telemetryPacket = new TelemetryPacket();

    public void loopAnd() {
        FtcDashboard.getInstance().sendTelemetryPacket(telemetryPacket);
        telemetryPacket = new TelemetryPacket();
    }

    public void add(TelemetryEvent<?> e){
        telemetryPacket.put( e.getData().getName(), e.getData().getData());
    }

}
