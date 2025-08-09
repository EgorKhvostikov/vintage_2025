package org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Impls;


import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.ColorSensorFix;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;
import org.firstinspires.ftc.teamcode.Util.Color.RgbColorVector;

public class ColorSensorImpl implements ColorSensor {

    public ColorSensorImpl(AdafruitI2cColorSensor colorSensor) {
        this.colorSensor = ColorSensorFix.fix(colorSensor);
    }

    private final AdafruitI2cColorSensor colorSensor;
    private final ElapsedTime timer = new ElapsedTime();
    private RgbColorVector state = new RgbColorVector(0,0,0);

    @Override
    public RgbColorVector getRgbVector() {
        if(timer.seconds()>0.1) {
            state = new RgbColorVector(colorSensor.red(), colorSensor.green(), colorSensor.blue());
            timer.reset();
        }
        return state;
    }
}
