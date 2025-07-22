package org.firstinspires.ftc.teamcode.ServiceActivator;

public class ServiceActivatorConfig {
    public boolean isMotorsActive = false;

    public boolean isServosActive = false;

    public boolean isColorSensorsActive = false;

    public boolean isSonarActive = false;

    public boolean isButtonActive = false;

    public boolean isMoveTaskManagerActive = false;

    public boolean isVoltageControllerActive = false;

    public boolean isWallFinderActive = false;

    public boolean isBaseFinderActive = false;

    public boolean isGyroActive = false;

    public static ServiceActivatorConfig getDefault(){
        return new ServiceActivatorConfig();
    }

}
