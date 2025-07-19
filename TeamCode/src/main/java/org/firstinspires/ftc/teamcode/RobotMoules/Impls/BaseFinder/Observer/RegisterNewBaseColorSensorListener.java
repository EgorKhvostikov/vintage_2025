package org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;
import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IListener;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;


public class RegisterNewBaseColorSensorListener implements IEvent<IListener<ColorState>> {

    private final IListener<ColorState> data;

    public RegisterNewBaseColorSensorListener(IListener<ColorState> data) {
        this.data = data;
    }

    @Override
    public IListener<ColorState> getData() {
        return data;
    }
}
