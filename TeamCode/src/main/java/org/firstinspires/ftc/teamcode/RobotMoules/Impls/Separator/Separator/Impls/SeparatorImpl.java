package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Separator.Impls;

import org.firstinspires.ftc.teamcode.Config.PidConfigs;
import org.firstinspires.ftc.teamcode.Config.SeparatorConfig;
import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.NewPuckInSeparator;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Separator.Interface.Separator;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;
import org.firstinspires.ftc.teamcode.Util.Math.Pid.Pid;

public class SeparatorImpl implements Separator, IEventUser {
    private final Pid pid = new Pid(PidConfigs.separatorPidConfig);

    private Motor motor;
    private double target = 0;
    private boolean isSeparate = false;


    @Override
    public void update() {
        Separator.super.update();
    }

    @Override
    public void lateUpdate() {
        pid.setTarget(target);
        pid.setPos(motor.getPosition());
        pid.update();
        double u = pid.getU();
    }

    public void onEvent(NewPuckInSeparator newPuckInSeparator){
        if( Math.abs(motor.getPosition() - target) > 5) {
            return;
        }

        if (isSeparate) {
            if (newPuckInSeparator.getData() == ColorState.OUR) {
                target += SeparatorConfig.onePuckPositionStep;
            }
            if (newPuckInSeparator.getData() == ColorState.OPPONENT) {
                target -= SeparatorConfig.onePuckPositionStep;
            }
        }
    }





    @Override
    public void init() {
        EventBus.getInstance().subscribe(NewPuckInSeparator.class,this::onEvent);

        motor = DevicePool.getInstance().separatorMotor;
    }
}
