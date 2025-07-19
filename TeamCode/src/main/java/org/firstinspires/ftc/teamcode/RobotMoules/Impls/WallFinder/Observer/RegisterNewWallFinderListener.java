package org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;

public class RegisterNewWallFinderListener implements IEvent<WallFinderListener> {
    private final WallFinderListener data;

    public RegisterNewWallFinderListener(WallFinderListener data) {
        this.data = data;
    }

    @Override
    public WallFinderListener getData() {
        return data;
    }
}
