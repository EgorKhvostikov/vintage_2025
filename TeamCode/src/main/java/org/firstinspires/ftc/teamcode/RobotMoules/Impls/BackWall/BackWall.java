package org.firstinspires.ftc.teamcode.RobotMoules.Impls.BackWall;

import org.firstinspires.ftc.teamcode.Config.ServoPositionConfig;
import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.Hardware.Impls.Servo.Interface.ServoMotor;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer.RegisterNewBaseColorSensorListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Interface.IRobotModule;
import org.firstinspires.ftc.teamcode.RobotMoules.Observer.IListener;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;

public class BackWall implements IRobotModule, IEventUser, IListener<ColorState> {
    private ServoMotor servo;
    private ColorState base = ColorState.OUR;

    @Override
    public void lateUpdate() {
        if(base == ColorState.OUR){
            servo.setPosition(ServoPositionConfig.backWallUpPosition);
        }else{
            servo.setPosition(ServoPositionConfig.backWallDownPosition);
        }
    }

    @Override
    public void init() {
        servo = DevicePool.getInstance().backWallServo;
    }

    @Override
    public void subscribeInit() {
        EventBus.getInstance().invoke(new RegisterNewBaseColorSensorListener(this));
    }

    @Override
    public void set(ColorState data) {
        base = data;
    }
}
