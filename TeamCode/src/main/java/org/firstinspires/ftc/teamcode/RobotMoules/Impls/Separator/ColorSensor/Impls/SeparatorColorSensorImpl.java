package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.ColorSensor.Impls;


import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.NewPuckInSeparator;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.GlobalState.MatchData.TeamData;
import org.firstinspires.ftc.teamcode.Hardware.Impls.ColorSensor.Interface.ColorSensor;
import org.firstinspires.ftc.teamcode.Hardware.Pool.DevicePool;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.ColorSensor.Interface.SeparatorColorSensor;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;
import org.firstinspires.ftc.teamcode.Util.Color.ColorUnit;
import org.firstinspires.ftc.teamcode.Util.Color.RgbColorVector;
import org.firstinspires.ftc.teamcode.Config.ColorSensorConfig;

public class SeparatorColorSensorImpl implements SeparatorColorSensor, IEventUser {
    ColorSensor colorSensor;

    @Override
    public void update() {
        RgbColorVector colorMap = RgbColorVector.findNearest(
                colorSensor.getRgbVector(),
                ColorSensorConfig.redPuckMap, ColorSensorConfig.bluePuckMap, ColorSensorConfig.whitePuckMap
        );

        ColorUnit color;
        if (colorMap == ColorSensorConfig.bluePuckMap) {
            color = ColorUnit.BLUE;
        } else if (colorMap == ColorSensorConfig.redPuckMap) {
            color = ColorUnit.RED;
        } else {
            color = ColorUnit.NONE;
        }

        if (color == TeamData.team) {
            EventBus.getInstance().invoke(new NewPuckInSeparator(ColorState.OUR));
            return;
        }

        if (color != ColorUnit.NONE) {
            EventBus.getInstance().invoke(new NewPuckInSeparator(ColorState.OPPONENT));
        }

    }

    @Override
    public void init() {
        colorSensor = DevicePool.getInstance().puckSensor;
    }
}
