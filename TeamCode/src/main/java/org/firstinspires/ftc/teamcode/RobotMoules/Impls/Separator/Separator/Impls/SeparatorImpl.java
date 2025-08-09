package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Separator.Impls;

import org.firstinspires.ftc.teamcode.Config.PidsConfig;
import org.firstinspires.ftc.teamcode.Config.SeparatorConfig;
import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.NewPuckInSeparator;
import org.firstinspires.ftc.teamcode.EventBus.Events.TelemetryEvent;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Motor.Interface.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer.RegisterNewBaseColorSensorListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Separator.Interface.Separator;
import org.firstinspires.ftc.teamcode.Telemetry.Telemetry;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;
import org.firstinspires.ftc.teamcode.Util.Math.Pid.Pid;

public class SeparatorImpl implements Separator, IEventUser {
    private final Pid pid = new Pid(PidsConfig.separatorPidConfig);

    private Motor motor;
    private double target = 0;
    private boolean isSeparate = false;
    private ColorState puckState = ColorState.NONE;

    @Override
    public void update() {
        Telemetry.getInstance().add(new TelemetryUnit<>(isSeparate,"isSeparate"));
        Telemetry.getInstance().add(new TelemetryUnit<>(puckState,"puckInSep"));

        Telemetry.getInstance().add(new TelemetryUnit<>(pid.getPos(),"position"));
        Telemetry.getInstance().add(new TelemetryUnit<>(target,"target"));
    }

    @Override
    public void lateUpdate() {
        pid.setTarget(target);
        pid.setPos(motor.getPosition());
        pid.update();
        double u = pid.getU();
        motor.setPower(u);
    }

    public void onEvent(NewPuckInSeparator newPuckInSeparator){
        puckState = newPuckInSeparator.getData();
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
        motor = DevicePool.getInstance().separatorMotor;
        EventBus.getInstance().invoke(new RegisterNewBaseColorSensorListener(this));
    }

    @Override
    public void subscribeInit() {
        EventBus.getInstance().subscribe(NewPuckInSeparator.class,this::onEvent);
    }

    @Override
    public void set(ColorState data) {
        isSeparate = data.equals(ColorState.NONE);
    }
}
