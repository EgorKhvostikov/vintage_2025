package org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.ColorSensor;


import org.firstinspires.ftc.teamcode.Config.ColorSensorConfig;
import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.ArriveOnBase;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.GlobalState.MatchData.TeamData;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer.BaseColorSensorObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer.RegisterNewBaseColorSensorListener;
import org.firstinspires.ftc.teamcode.RobotMoules.Interface.IRobotModule;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;
import org.firstinspires.ftc.teamcode.Util.Color.ColorUnit;
import org.firstinspires.ftc.teamcode.Util.Color.RgbColorVector;

public class BaseColorSensor implements IEventUser, IRobotModule {
    private ColorSensor colorSensor;
    private ColorState oldColorState = ColorState.NONE;
    private final BaseColorSensorObserver observer = new BaseColorSensorObserver();

    @Override
    public void update() {
        RgbColorVector rgbVector = RgbColorVector.findNearest(
                colorSensor.getRgbVector(),
                ColorSensorConfig.redBaseMap, ColorSensorConfig.blueBaseMap, ColorSensorConfig.whiteBaseMap
        );

        ColorUnit colorUnit = ColorUnit.NONE;
        if (rgbVector == ColorSensorConfig.blueBaseMap) {
            colorUnit = ColorUnit.BLUE;
        } else if (rgbVector == ColorSensorConfig.redBaseMap) {
            colorUnit = ColorUnit.RED;
        }

        ColorState base = ColorState.OPPONENT;
        if (colorUnit == ColorUnit.NONE) {
            base = ColorState.NONE;
        }

        if (colorUnit == TeamData.team) {
            base = ColorState.OUR;
        }

        observer.notifyListeners(base);

        if (oldColorState != ColorState.OUR && base == ColorState.OUR) {
            EventBus.getInstance().invoke(new ArriveOnBase());
        }
        oldColorState = base;

    }

    public void onEvent(RegisterNewBaseColorSensorListener e){
        observer.register(e.getData());
    }

    @Override
    public void init() {
        colorSensor = DevicePool.getInstance().baseSensor;
    }

    @Override
    public void subscribeInit() {
        EventBus.getInstance().subscribe(RegisterNewBaseColorSensorListener.class,this::onEvent);
    }
}
