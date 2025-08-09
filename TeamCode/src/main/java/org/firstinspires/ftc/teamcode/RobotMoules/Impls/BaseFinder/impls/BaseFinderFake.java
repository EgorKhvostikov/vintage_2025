package org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.impls;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Interface.BaseFinder;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer.BaseColorSensorObserver;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.BaseFinder.Observer.RegisterNewBaseColorSensorListener;
import org.firstinspires.ftc.teamcode.Telemetry.Telemetry;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;

@Config
public class BaseFinderFake implements BaseFinder {

    public static String state = "none";

    @Override
    public void subscribeInit() {
        EventBus.getInstance().subscribe(RegisterNewBaseColorSensorListener.class, this::onEvent);
    }

    private final BaseColorSensorObserver observer = new BaseColorSensorObserver();

    public void onEvent(RegisterNewBaseColorSensorListener e){
        observer.register(e.getData());
    }

    @Override
    public void update() {
        Telemetry.getInstance().add( new TelemetryUnit<>(observer.getRegistered(),"listenersBaseFinder") );

        if(state.equals("our")){
            observer.notifyListeners(ColorState.OUR);
        } else if (state.equals("opponent")) {
            observer.notifyListeners(ColorState.OPPONENT);
        }else{
            observer.notifyListeners(ColorState.NONE);
        }
    }
}
