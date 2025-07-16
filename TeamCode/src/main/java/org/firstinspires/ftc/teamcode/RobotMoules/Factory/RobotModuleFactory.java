package org.firstinspires.ftc.teamcode.RobotMoules.Factory;


import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Impls.SeparatorImpl;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Interface.Sepatator;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;

public class RobotModuleFactory {
    private ServiceActivatorConfig serviceActivatorConfig = new ServiceActivatorConfig();

    public RobotModuleFactory setServiceActivatorConfig(ServiceActivatorConfig serviceActivatorConfig) {
        this.serviceActivatorConfig = serviceActivatorConfig;
        return this;
    }

    public Sepatator createSeparator(){
        return new SeparatorImpl();
    }
}
