package org.firstinspires.ftc.teamcode.MainUpdater;


import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;

import java.util.ArrayList;

public class MainUpdater {
    private static final MainUpdater instance = new MainUpdater();
    public static MainUpdater getInstance() {
        return instance;
    }
    private ArrayList<IUpdatable> robotModules;
    public  void addModule(Class<? extends IUpdatable> module) {
        try {
            robotModules.add(module.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            throw new RuntimeException("bad robot module");
        }
    }

    public void init(){
        robotModules.forEach(IUpdatable::init);
    }
    private long i = 0;
    public void update(){
        robotModules.forEach(IUpdatable::update);
        robotModules.forEach(IUpdatable::lateUpdate);
        EventManager.getDefault().mainLoopEnd.publish(i);
        i++;
    }
}
