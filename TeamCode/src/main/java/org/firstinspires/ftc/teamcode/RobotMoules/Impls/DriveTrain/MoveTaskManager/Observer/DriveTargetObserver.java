package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Observer;


import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

import java.util.ArrayList;

public class DriveTargetObserver implements IEventUser {
    private final ArrayList<DriveTargetListener> listeners = new ArrayList<>();

    public void onEvent(RegisterNewDriveTargetListener l){
        listeners.add(l.getData());
    }

    public void notifyListeners(Position t){
        listeners.forEach(i->i.setDriveTarget(t));
    }
    public DriveTargetObserver() {
        EventBus.getInstance().subscribe(RegisterNewDriveTargetListener.class,this::onEvent);
    }
}
