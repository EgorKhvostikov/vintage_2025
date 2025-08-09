package org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IListener;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;

import java.util.ArrayList;

public class BaseColorSensorObserver implements IEventUser, IObserver<ColorState, IListener<ColorState>> {
    private final ArrayList<IListener<ColorState>> registered = new ArrayList<>();

    public ArrayList<IListener<ColorState>> getRegistered() {
        return registered;
    }

    @Override
    public void register(IListener<ColorState> r) {
        registered.add(r);
    }

    @Override
    public void remove(IListener<ColorState> r) {
        registered.remove(r);
    }

    @Override
    public void notifyListeners(ColorState data) {
        for (IListener<ColorState> i: registered) {
            i.set(data);
        }
    }

}
