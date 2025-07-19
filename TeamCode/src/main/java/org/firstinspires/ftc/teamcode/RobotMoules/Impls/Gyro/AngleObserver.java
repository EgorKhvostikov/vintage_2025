package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro;

import java.util.ArrayList;

public class AngleObserver {
    private final ArrayList<AngleListener> listeners = new ArrayList<>();

    public void register(AngleListener r) {
        listeners.add(r);
    }

    public void remove(AngleListener r) {
        listeners.remove(r);
    }

    public void notifyListeners(Double data) {
        listeners.forEach(i->i.setAngle(data));
    }
}
