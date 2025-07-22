package org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Impls;


import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;

import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.ColorSensorFix;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;
import org.firstinspires.ftc.teamcode.Util.Color.RgbColorVector;

public class ColorSensorImpl implements ColorSensor {

    public ColorSensorImpl(AdafruitI2cColorSensor colorSensor) {
        this.colorSensor = ColorSensorFix.fix(colorSensor);
    }

    private final AdafruitI2cColorSensor colorSensor;

    @Override
    public RgbColorVector getRgbVector() {
        return new RgbColorVector(colorSensor.red(),colorSensor.green(),colorSensor.blue());
    }
}
