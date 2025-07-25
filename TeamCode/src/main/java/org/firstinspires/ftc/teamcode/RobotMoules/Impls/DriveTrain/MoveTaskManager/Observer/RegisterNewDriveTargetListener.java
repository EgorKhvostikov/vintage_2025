package org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Observer;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;


public class RegisterNewDriveTargetListener implements IEvent<DriveTargetListener> {
    private final DriveTargetListener data;

    public RegisterNewDriveTargetListener(DriveTargetListener data) {
        this.data = data;
    }

    @Override
    public DriveTargetListener getData() {
        return data;
    }
}
