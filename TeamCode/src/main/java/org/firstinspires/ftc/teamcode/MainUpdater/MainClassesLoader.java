package org.firstinspires.ftc.teamcode.MainUpdater;

import org.firstinspires.ftc.teamcode.Modules.BackWall.BackWall;
import org.firstinspires.ftc.teamcode.Modules.BackWall.BaseColorSensor;
import org.firstinspires.ftc.teamcode.Modules.Battery.Battery;
import org.firstinspires.ftc.teamcode.Modules.DriveTrain.Mover.MoveTaskManager;
import org.firstinspires.ftc.teamcode.Modules.DriveTrain.Mover.VoltageController;
import org.firstinspires.ftc.teamcode.Modules.Gyro.Gyro;
import org.firstinspires.ftc.teamcode.Modules.Separator.Separator;
import org.firstinspires.ftc.teamcode.Modules.Separator.SeparatorColorSensor;
import org.firstinspires.ftc.teamcode.Sonar.WallFinder;
import org.firstinspires.ftc.teamcode.Telemetry.Telemetry;

public class MainClassesLoader {
    public static void loadAll(){
        BackWall.load();
        BaseColorSensor.load();
        Battery.load();
        Gyro.load();
        MoveTaskManager.load();
        Separator.load();
        SeparatorColorSensor.load();
        Telemetry.load();
        VoltageController.load();
        WallFinder.load();
    }
}
