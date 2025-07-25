package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.Observer;

import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IObserver;

import java.util.ArrayList;

public class RobotAtAngleObserver implements IObserver<Boolean, IListener<Boolean>> {
    private final ArrayList<IListener<Boolean>> listeners = new ArrayList<>();

    @Override
    public void register(IListener<Boolean> r) {
        listeners.add(r);
    }

    @Override
    public void remove(IListener<Boolean> r) {
        listeners.remove(r);
    }

    @Override
    public void notifyListeners(Boolean data) {
        listeners.forEach(i->i.set(data));
    }
}
