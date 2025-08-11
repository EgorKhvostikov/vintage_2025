package org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Impls;


import com.qualcomm.hardware.adafruit.AdafruitI2cColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.ColorSensorFix;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;
import org.firstinspires.ftc.teamcode.Util.Array.ArrayExtra;
import org.firstinspires.ftc.teamcode.Util.Color.RgbColorVector;

public class ColorSensorImpl implements ColorSensor {

    public ColorSensorImpl(AdafruitI2cColorSensor colorSensor) {
        this.colorSensor = ColorSensorFix.fix(colorSensor);
    }

    private final AdafruitI2cColorSensor colorSensor;
    private final ElapsedTime timer = new ElapsedTime();
    private final ElapsedTime timerA = new ElapsedTime();
    private RgbColorVector state = new RgbColorVector(0,0,0);
    private final int[] readsRed   = new int[1];
    private final int[] readsGreen = new int[1];
    private final int[] readsBlue  = new int[1];

    @Override
    public RgbColorVector getRgbVector() {
        if(timer.seconds()>0.1) {
            ArrayExtra.updateLikeBuffer(colorSensor.red()  ,readsRed);
            ArrayExtra.updateLikeBuffer(colorSensor.green(),readsGreen);
            ArrayExtra.updateLikeBuffer(colorSensor.blue() ,readsBlue);

            state = new RgbColorVector(ArrayExtra.findMedian(readsRed),
                                       ArrayExtra.findMedian(readsGreen),
                                       ArrayExtra.findMedian(readsBlue));
            timer.reset();
        }
        return state;
    }

    private int alpha = 0;
    public int getAlpha(){
        if(timerA.seconds()>0.1){
            alpha = colorSensor.alpha();
            timer.reset();
        }
        return alpha;
    }
}
