package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.Observer;

import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IObserver;
import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

import java.util.ArrayList;

public class MoveTaskManagerObserver implements IObserver<Position, IListener<Position>> {
    private final ArrayList<IListener<Position>> listeners = new ArrayList<>();

    @Override
    public void register(IListener<Position> r) {
        listeners.add(r);
    }

    @Override
    public void remove(IListener<Position> r) {
        listeners.remove(r);
    }

    @Override
    public void notifyListeners(Position data) {
        listeners.forEach(i->i.set(data));
    }


}
