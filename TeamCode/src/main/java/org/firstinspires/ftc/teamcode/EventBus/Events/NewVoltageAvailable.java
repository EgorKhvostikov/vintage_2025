package org.firstinspires.ftc.teamcode.EventBus.Events;
import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;

public class NewVoltageAvailable implements IEvent<Double> {
    Double data = 1d;

    public NewVoltageAvailable(Double data) {
        this.data = data;
    }

    @Override
    public Double getData() {
        return data;
    }


}
