package org.firstinspires.ftc.teamcode.Hardware.Impls.Button;

import com.qualcomm.robotcore.hardware.DigitalChannel;

public class ButtonImpl implements Button {
    private final DigitalChannel digitalChannel;
    public ButtonImpl(DigitalChannel digitalChannel) {
        this.digitalChannel = digitalChannel;
    }

    @Override
    public boolean getState() {
        return digitalChannel.getState();
    }
}
