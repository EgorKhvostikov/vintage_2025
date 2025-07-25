package org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Impls;

import org.firstinspires.ftc.teamcode.Hardware.Impls.Sonar.Intarface.Sonar;

public class SonarFake implements Sonar {
    private Byte dist;

    public SonarFake(Byte dist) {
        this.dist = dist;
    }

    @Override
    public byte read() {
        return dist;
    }
}
