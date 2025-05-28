package org.firstinspires.ftc.teamcode.OpModes.ModulesTests;

import org.firstinspires.ftc.teamcode.Config.ActiveServiceList;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Math.Position;
import org.firstinspires.ftc.teamcode.OpModes.BaseOpMode.BaseopMode;

public class SeparatorTest extends BaseopMode {
    static  {
        ActiveServiceList.autoDriveTrain = false;
    }
    @Override
    public void initDevices() {

    }

    @Override
    public void loopCall() {
        EventManager.getDefault().newTargetVelocity.publish(new Position(
                -gamepad1.left_stick_y*12,0,gamepad1.right_stick_x*12
        ));
    }

    @Override
    public void conditionCall() {

    }
}
