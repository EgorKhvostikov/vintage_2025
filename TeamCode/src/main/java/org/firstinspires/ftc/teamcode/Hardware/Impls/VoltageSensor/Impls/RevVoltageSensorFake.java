package org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Impls;

import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Interface.RevVoltageSensor;

public class RevVoltageSensorFake implements RevVoltageSensor {
    @Override
    public double getVoltage() {
        return 12;
    }
}
