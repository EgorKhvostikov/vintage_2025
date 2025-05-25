package org.firstinspires.ftc.teamcode.MainUpdater;

import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;

import java.util.ArrayList;

public class MainUpdater {
    static ArrayList<IUpdatable> robotModules;
    public static void addModule(Class<? extends IUpdatable> module) {
        try {
            robotModules.add(module.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            throw new RuntimeException("bad robot module");
        }
    }

    public static void init(){
        robotModules.forEach(IUpdatable::init);
    }

    public static void update(){
        robotModules.forEach(IUpdatable::update);
        robotModules.forEach(IUpdatable::lateUpdate);
    }
}
