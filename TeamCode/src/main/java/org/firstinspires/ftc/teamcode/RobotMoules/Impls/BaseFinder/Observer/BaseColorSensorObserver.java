package org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.RobotMoules.Observers.IObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Observers.IListener;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;

import java.util.ArrayList;

public class BaseColorSensorObserver implements IEventUser, IObserver<ColorState, IListener<ColorState>> {
    ArrayList<IListener<ColorState>> registered = new ArrayList<>();

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
