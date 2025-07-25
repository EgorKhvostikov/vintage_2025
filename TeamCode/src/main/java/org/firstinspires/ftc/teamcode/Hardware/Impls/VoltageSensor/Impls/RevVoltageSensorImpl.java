package org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Impls;

import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Interface.RevVoltageSensor;

public class RevVoltageSensorImpl implements RevVoltageSensor {

    private final VoltageSensor sensor;

    public RevVoltageSensorImpl(VoltageSensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public double getVoltage() {
        return sensor.getVoltage();
    }
}
