package org.firstinspires.ftc.teamcode.Modules.Battery;

import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Math.ArrayExtra;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;

public class Battery implements IUpdatable {
    static {
        MainUpdater.addModule(Battery.class);
    }
    VoltageSensor voltageSensor;

    private final ElapsedTime timer = new ElapsedTime();

    private boolean isUnInit = true;

    public void init() {
      voltageSensor = Hardware.voltageSensor;
    }
    private final double[] reads = new double[5];

    public void update() {
        if (timer.seconds() > 0.5) {
            ArrayExtra.updateLikeBuffer(voltageSensor.getVoltage(), reads);
            EventManager.getDefault().newVoltageAvailable.publish(ArrayExtra.findMedian(reads));
            timer.reset();
        }
    }

}
