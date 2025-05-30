package org.firstinspires.ftc.teamcode.Modules.Separator;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Color.ColorState;
import org.firstinspires.ftc.teamcode.Config.ActiveServiceList;
import org.firstinspires.ftc.teamcode.Config.PidConfig;
import org.firstinspires.ftc.teamcode.Config.SeparatorConfig;
import org.firstinspires.ftc.teamcode.Events.Event;
import org.firstinspires.ftc.teamcode.Events.EventManager;
import org.firstinspires.ftc.teamcode.Events.EventUser;
import org.firstinspires.ftc.teamcode.Hardware.Hardware;
import org.firstinspires.ftc.teamcode.MainUpdater.MainUpdater;
import org.firstinspires.ftc.teamcode.Math.Pid.Pid;
import org.firstinspires.ftc.teamcode.Modules.Interfaces.IUpdatable;
import org.firstinspires.ftc.teamcode.Telemetry.TelemetryUnit;

public class Separator implements IUpdatable, EventUser {

    private final Pid pid = new Pid(PidConfig.sepatatorPidStatus);

    DcMotorEx motor;
    public static void load(){}
    static  {
        if(ActiveServiceList.separator) {
            MainUpdater.getInstance().addModule(Separator.class);
        }
    }
    @Override
    public void init(){
        EventManager.getDefault().newPuckInSeparator.subscribe(this);
        EventManager.getDefault().nowOnBase.subscribe(this);
        motor = Hardware.separatorMotor;
    }


    @Override
    public void lateUpdate() {
        pid.setTarget(target);
        pid.setPos(motor.getCurrentPosition());
        pid.update();
        double u = pid.getU();

        if(Math.abs(u)>0.5){
            u = 0.5 * Math.signum(u);
        }

        motor.setPower(u);
        EventManager.getDefault().telemtryEvent.publish(new TelemetryUnit<>("current sep target", target));
        EventManager.getDefault().telemtryEvent.publish(new TelemetryUnit<>("current sep position", motor.getCurrentPosition()));
    }

    private double target = 0;
    private boolean isSeparate = false;
    @Override
    public void onEvent(Event<?> e) {
        if(e == EventManager.getDefault().nowOnBase){
            if(e.data == ColorState.NONE){
                isSeparate = true;
            }else {
                isSeparate = false;
            }
        }

        if(e == EventManager.getDefault().newPuckInSeparator){
            if( Math.abs(motor.getCurrentPosition() - target) > 5) {
                return;
            }

            if (isSeparate) {
                if (e.data == ColorState.OUR) {
                    target += SeparatorConfig.onePuckPositionStep;
                }
                if (e.data == ColorState.OPPONENT) {
                    target -= SeparatorConfig.onePuckPositionStep;
                }
            }
        }
    }
}
