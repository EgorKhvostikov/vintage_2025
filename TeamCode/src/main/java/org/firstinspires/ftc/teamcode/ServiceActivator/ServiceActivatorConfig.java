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
    public static ServiceActivatorConfig getDefaultActive(){
        ServiceActivatorConfig config = new ServiceActivatorConfig();
        config.isMotorsActive            = true;
        config.isColorSensorsActive      = true;
        config.isServosActive            = true;
        config.isSonarActive             = true;
        config.isButtonActive            = true;
        config.isMoveTaskManagerActive   = true;
        config.isVoltageControllerActive = true;
        config.isWallFinderActive        = true;
        config.isBaseFinderActive        = true;
        config.isGyroActive              = true;
        return config;
    }

}
