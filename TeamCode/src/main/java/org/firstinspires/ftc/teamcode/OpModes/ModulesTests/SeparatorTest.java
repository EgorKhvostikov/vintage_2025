package org.firstinspires.ftc.teamcode.OpModes.ModulesTests;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Events.EventManager;

import org.firstinspires.ftc.teamcode.OpModes.BaseOpMode.BaseOpMode;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

@TeleOp
public class SeparatorTest extends BaseOpMode {

    @Override
    public void initDevices() {

    }

    @Override
    public void loopCall() {

        EventManager.getDefault().telemtryEvent.publish(
                new TelemetryUnit<>("base",
                        EventManager.getDefault().nowOnBase.data
                        ));
        EventManager.getDefault().telemtryEvent.publish(
                new TelemetryUnit<>("puck",
                        EventManager.getDefault().newPuckInSeparator.data
                        ));

        try {
            EventManager.getDefault().telemtryEvent.publish(
                    new TelemetryUnit<>("forward target",
                            EventManager.getDefault().newTargetVelocity.data.x
                    ));
            EventManager.getDefault().telemtryEvent.publish(
                    new TelemetryUnit<>("current angle target",
                            EventManager.getDefault().newTargetVelocity.data.h
                    ));
            EventManager.getDefault().telemtryEvent.publish(
                    new TelemetryUnit<>("find wall",
                            EventManager.getDefault().wallNear.data
                    ));
            EventManager.getDefault().telemtryEvent.publish(
                    new TelemetryUnit<>("current angle ",
                            EventManager.getDefault().newAngle.data
                    ));


        } catch (Exception ignored) {
        }

    }

    @Override
    public void conditionCall() {

    }

}
