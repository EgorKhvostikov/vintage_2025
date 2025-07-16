package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Impls;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.NewVoltageAvailable;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.OnEvent;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.OnEventMethod;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Interface.Sepatator;

public class SeparatorImpl implements Sepatator, IEventUser {

    OnEventMethod<NewVoltageAvailable> onVoltage = this::onEvent;

    @OnEvent(NewVoltageAvailable.class)
    public void onEvent(NewVoltageAvailable event){

    }

    {
        EventBus.getInstance().subscribe(NewVoltageAvailable.class,onVoltage);
    }

}
