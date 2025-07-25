package org.firstinspires.ftc.teamcode.Robot;

import org.firstinspires.ftc.teamcode.RobotMoules.Factory.RobotModuleFactory;
import org.firstinspires.ftc.teamcode.RobotMoules.Interface.IRobotModule;
import org.firstinspires.ftc.teamcode.Telemetry.Telemetry;

import java.util.Arrays;
import java.util.List;

public class RobotModulesList {
    private final List<IRobotModule> robotModules;

    public List<IRobotModule> getRobotModules() {
        return robotModules;
    }

    public RobotModulesList(RobotModuleFactory factory) {
        robotModules = Arrays.asList(
                factory.createSeparator(),factory.createVoltageController(),
                factory.createSeparatorColorSensor(),factory.createBattery(),
                factory.createBaseFinder(),factory.createWallFinder(),
                factory.createGyro(),factory.createMoveTaskManager(),factory.createBackWall()
        );
    }
}
