package org.firstinspires.ftc.teamcode.ServiceActivator;

public class ServiceActivatorConfig {
    public boolean isMotorsActive = false;
    public boolean isServosActive = false;

    public boolean isColorSensorsActive = false;

    public static ServiceActivatorConfig getDefault(){
        return new ServiceActivatorConfig();
    }

}
