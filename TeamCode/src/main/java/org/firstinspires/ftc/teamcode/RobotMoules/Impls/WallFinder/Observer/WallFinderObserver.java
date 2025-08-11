package org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;

import java.util.ArrayList;

public class WallFinderObserver implements IEventUser {
    private final ArrayList<WallFinderListener> listeners = new ArrayList<>();

    public void register(WallFinderListener l){
        listeners.add(l);
    }

    public void remove(WallFinderListener l){
        listeners.remove(l);
    }

    public void notifyListeners(WallFinderStatus data){
        listeners.forEach(i-> i.setWallFindState(data));
    }

    public void onEvent(RegisterNewWallFinderListener l){
        register(l.getData());
    }

    public WallFinderObserver() {
        EventBus.getInstance().subscribe(RegisterNewWallFinderListener.class,this::onEvent);
    }
}
