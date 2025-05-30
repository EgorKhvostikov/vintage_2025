package org.firstinspires.ftc.teamcode.Sonar;


import com.qualcomm.robotcore.hardware.I2cAddr;

import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import org.firstinspires.ftc.teamcode.Config.WallFindConfig;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

public class WallFinder implements IUpdatable {
    static {
        MainUpdater.getInstance().addModule(WallFinder.class);
    }

    @Override
    public void update(){
        i2cPort.write((byte) 5);
        int data = Math.abs( i2cPort.read() );
        boolean sonar = data < WallFindConfig.findWallDist;

        boolean buttons = !Hardware.rightButton.getState() || !Hardware.leftButton.getState();

        boolean voltage = (Hardware.rightDrive.getCurrent(CurrentUnit.AMPS) + Hardware.leftDrive.getCurrent(CurrentUnit.AMPS)) * 0.5
                > WallFindConfig.findWallVoltage;

        EventManager.getDefault().telemtryEvent.publish(
                new TelemetryUnit<>("sonar",data)
        );

        EventManager.getDefault().telemtryEvent.publish(
                new TelemetryUnit<>("voltage wall detect",voltage)
        );
        EventManager.getDefault().telemtryEvent.publish(
                new TelemetryUnit<>("buttons wall detect",buttons)
        );

        if(voltage || sonar || buttons){
            EventManager.getDefault().wallNear.publish(true);
        }else{
            EventManager.getDefault().wallNear.publish(false);
        }

    }

    I2cPort i2cPort;
    @Override
    public void init(){
        i2cPort = Hardware.arduino;
        i2cPort.initWithI2cAddress(I2cAddr.create7bit(5));
    }
    public static void load(){}
}
