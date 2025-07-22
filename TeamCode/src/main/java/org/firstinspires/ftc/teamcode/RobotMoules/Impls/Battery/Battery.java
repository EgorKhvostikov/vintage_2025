package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Battery;


import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.NewVoltageAvailable;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Hardware.Impls.VoltageSensor.Interface.RevVoltageSensor;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Interface.IRobotModule;
import org.firstinspires.ftc.teamcode.Util.Array.ArrayExtra;

public class Battery implements IEventUser, IRobotModule {
    private RevVoltageSensor revVoltageSensor;
    private final ElapsedTime timer = new ElapsedTime();

    private final double[] reads = new double[5];

    @Override
    public void init(){
        revVoltageSensor = DevicePool.getInstance().revVoltageSensor;
    }

    public void update() {
        if (timer.seconds() > 0.5) {
            ArrayExtra.updateLikeBuffer(revVoltageSensor.getVoltage(), reads);
            EventBus.getInstance().invoke(new NewVoltageAvailable(ArrayExtra.findMedian(reads)));
            timer.reset();
        }
    }
}
