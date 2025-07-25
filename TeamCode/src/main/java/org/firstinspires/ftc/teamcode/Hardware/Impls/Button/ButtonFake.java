package org.firstinspires.ftc.teamcode.Hardware.Impls.Button;

public class ButtonFake implements Button{
    private Boolean checkBox = false;

    public ButtonFake(Boolean checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public boolean getState() {
        return checkBox;
    }
}
