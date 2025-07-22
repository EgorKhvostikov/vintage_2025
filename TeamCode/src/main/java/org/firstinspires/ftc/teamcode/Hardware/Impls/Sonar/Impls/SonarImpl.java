package org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Impls;

import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Intarface.Sonar;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.I2CPort.I2cPort;

public class SonarImpl implements Sonar {
    private final I2cPort i2cPort;
    public SonarImpl(I2cPort i2cPort) {
        this.i2cPort = i2cPort;
        i2cPort.initWithI2cAddress(I2cAddr.create7bit(5));
    }

    private byte data = 0;
    private final ElapsedTime timer = new ElapsedTime();
    @Override
    public byte read() {
        i2cPort.write((byte) 5);
        if(timer.seconds()>0.05) {
            data = i2cPort.read();
            timer.reset();
        }
        return data;
    }
}
