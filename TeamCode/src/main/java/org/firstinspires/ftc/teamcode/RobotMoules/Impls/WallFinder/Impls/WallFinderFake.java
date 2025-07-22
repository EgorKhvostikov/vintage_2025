package org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Impls;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Interface.WallFinder;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer.WallFinderObserver;

@Config
public class WallFinderFake implements WallFinder {

    public static boolean wall = false;

    private final WallFinderObserver observer = new WallFinderObserver();

    @Override
    public void update(){
        observer.notifyListeners(wall);
    }

}
