package org.firstinspires.ftc.teamcode.RobotMoules.Factory;


import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BackWall.BackWall;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Interface.BaseFinder;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.impls.BaseFinderFake;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.impls.BaseFinderImpl;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Battery.Battery;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Impls.MoveTaskManagerFake;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Impls.MoveTaskManagerImpl;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.MoveTaskManager.Interface.MoveTaskManager;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.VoltageController.Impls.VoltageControllerFake;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.VoltageController.Impls.VoltageControllerImpl;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.DriveTrain.VoltageController.Interface.VoltageController;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Impls.GyroFake;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Impls.GyroImpl;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Gyro.Interface.Gyro;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.ColorSensor.Impls.SeparatorColorSensorImpl;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.ColorSensor.Interface.SeparatorColorSensor;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Separator.Impls.SeparatorImpl;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Separator.Interface.Separator;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Impls.WallFinderFake;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Impls.WallFinderImpl;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Interface.WallFinder;
import org.firstinspires.ftc.teamcode.ServiceActivator.ServiceActivatorConfig;

public class RobotModuleFactory {
    private  ServiceActivatorConfig config = ServiceActivatorConfig.getDefault();

    public RobotModuleFactory setServiceActivatorConfig(ServiceActivatorConfig serviceActivatorConfig) {
        this.config = serviceActivatorConfig;
        return this;
    }

    public Separator createSeparator(){
        return new SeparatorImpl();
    }

    public VoltageController createVoltageController(){
        if(config.isVoltageControllerActive){
            return new VoltageControllerImpl();
        }
        return new VoltageControllerFake();
    }

    public SeparatorColorSensor createSeparatorColorSensor(){
        return new SeparatorColorSensorImpl();
    }

    public BaseFinder createBaseFinder(){
        if(config.isBaseFinderActive){
            return new BaseFinderImpl();
        }
        return new BaseFinderFake();
    }

    public MoveTaskManager createMoveTaskManager(){
        if(config.isMoveTaskManagerActive){
            return new MoveTaskManagerImpl();
        }
        return new MoveTaskManagerFake();
    }

    public WallFinder createWallFinder(){
        if(config.isWallFinderActive){
            return new WallFinderImpl();
        }
        return new WallFinderFake();
    }

    public BackWall createBackWall(){
        return new BackWall();
    }

    public Battery createBattery(){
        return new Battery();
    }

    public Gyro createGyro(){
        if(config.isGyroActive){
            return new GyroImpl();
        }
        return new GyroFake();
    }
}
