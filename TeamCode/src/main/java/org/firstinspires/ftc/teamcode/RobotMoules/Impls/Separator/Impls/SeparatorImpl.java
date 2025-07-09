package org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Impls;

import org.firstinspires.ftc.teamcode.EventBus.Bus.EventBus;
import org.firstinspires.ftc.teamcode.EventBus.Events.NewVoltageAvailableEvent;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEventUser;
import org.firstinspires.ftc.teamcode.RobotMoules.Impls.Separator.Interface.Sepatator;

public class SeparatorImpl implements Sepatator, IEventUser<NewVoltageAvailableEvent> {

    @Override
    public void onEvent(NewVoltageAvailableEvent event) {
        EventBus.getInstance().subscribe(NewVoltageAvailableEvent.class, this);
        event.getData();
        EventBus.getInstance().invoke(new NewVoltageAvailableEvent(12d));
    }

}
