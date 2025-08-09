package org.firstinspires.ftc.teamcode.Telemetry;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
public class Telemetry{
    private static final Telemetry Instance = new Telemetry();
    public static Telemetry getInstance() {return Instance;}
    private TelemetryPacket telemetryPacket = new TelemetryPacket();

    public void loopEnd() {
        FtcDashboard.getInstance().sendTelemetryPacket(telemetryPacket);
        telemetryPacket = new TelemetryPacket();
    }

    public <T> void add(TelemetryUnit<T> e){
        telemetryPacket.put( e.getName(), e.getData());
    }

}
