package org.firstinspires.ftc.teamcode.EventBus.Events;

import org.firstinspires.ftc.teamcode.EventBus.Interfaces.IEvent;
import org.firstinspires.ftc.teamcode.Util.Color.ColorState;

public class NewPuckInSeparator implements IEvent<ColorState> {

    private final ColorState data;

    public NewPuckInSeparator(ColorState data) {
        this.data = data;
    }

    @Override
    public ColorState getData() {
        return data;
    }
}
