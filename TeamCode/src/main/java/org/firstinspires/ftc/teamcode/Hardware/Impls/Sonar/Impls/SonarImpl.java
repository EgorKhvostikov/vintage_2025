package org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Impls;

import com.qualcomm.robotcore.hardware.I2cAddr;

import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Intarface.Sonar;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.I2CPort.I2cPort;

public class SonarImpl implements Sonar {
    private final I2cPort i2cPort;
    public SonarImpl(I2cPort i2cPort) {
        this.i2cPort = i2cPort;
        i2cPort.initWithI2cAddress(I2cAddr.create7bit(5));
    }

    @Override
    public byte read() {
        i2cPort.write((byte) 5);
        return i2cPort.read();
    }
}
