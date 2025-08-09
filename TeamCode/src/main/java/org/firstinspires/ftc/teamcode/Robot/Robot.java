package org.firstinspires.ftc.teamcode.Robot;

import org.firstinspires.ftc.teamcode.RobotMoules.Factory.RobotModuleFactory;
import org.firstinspires.ftc.teamcode.RobotMoules.Interface.IRobotModule;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;
import org.firstinspires.ftc.teamcode.Telemetry.Telemetry;

public class Robot {
    private RobotModulesList robotModulesList;
    private ServiceActivatorConfig serviceActivatorConfig = ServiceActivatorConfig.getDefault();

    public Robot setServiceActivatorConfig(ServiceActivatorConfig serviceActivatorConfig) {
        this.serviceActivatorConfig = serviceActivatorConfig;
        return this;
    }

    public Robot build(){
        robotModulesList = new RobotModulesList(new RobotModuleFactory().setServiceActivatorConfig(serviceActivatorConfig));
        return this;
    }

    public void init(){
        robotModulesList.getRobotModules().forEach(IRobotModule::subscribeInit);
        robotModulesList.getRobotModules().forEach(IRobotModule::init );
    }

    public void update(){
        robotModulesList.getRobotModules().forEach(IRobotModule::update);
        robotModulesList.getRobotModules().forEach(IRobotModule::lateUpdate);
        Telemetry.getInstance().loopEnd();
    }
}
