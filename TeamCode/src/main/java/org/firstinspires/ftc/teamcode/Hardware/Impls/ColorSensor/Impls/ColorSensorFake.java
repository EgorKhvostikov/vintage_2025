package org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Impls;

import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;
import org.firstinspires.ftc.teamcode.Util.Color.RgbColorVector;

public class ColorSensorFake implements ColorSensor {
    private final RgbColorVector vector;

    public ColorSensorFake(RgbColorVector vector) {
        this.vector = vector;
    }

    @Override
    public RgbColorVector getRgbVector() {
        return vector;
    }

    @Override
    public int getAlpha() {
        return 0;
    }
}
