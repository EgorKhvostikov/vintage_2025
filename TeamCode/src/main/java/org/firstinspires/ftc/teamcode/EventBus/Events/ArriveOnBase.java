package org.firstinspires.ftc.teamcode.EventBus.Events;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;

public class ArriveOnBase implements IEvent<Boolean> {

    @Override
    public Boolean getData() {
        return true;
    }
}
