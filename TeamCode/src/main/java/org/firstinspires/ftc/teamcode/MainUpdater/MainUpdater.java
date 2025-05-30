package org.firstinspires.ftc.teamcode.MainUpdater;


import com.acmerobotics.dashboard.FtcDashboard;

import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

import java.util.ArrayList;
import java.util.Arrays;

public class MainUpdater {
    private static final MainUpdater instance = new MainUpdater();
    public static MainUpdater getInstance() {
        return instance;
    }
    private final ArrayList<IUpdatable> robotModules = new ArrayList<>();
    public  void addModule(Class<? extends IUpdatable> module) {
        try {
            robotModules.add(module.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            throw new RuntimeException("bad robot module");
        }
    }

    public void init() {
        robotModules.forEach(IUpdatable::init);
    }

    private long i = 0;
    public void update(){
        i ++;
        robotModules.forEach(IUpdatable::update);
        robotModules.forEach(IUpdatable::lateUpdate);
        EventManager.getDefault().mainLoopEnd.publish(i);
    }
}
