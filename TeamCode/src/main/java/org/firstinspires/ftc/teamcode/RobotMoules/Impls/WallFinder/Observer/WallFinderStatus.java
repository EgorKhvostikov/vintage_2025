package org.firstinspires.ftc.teamcode.RobotMoules.Impls.WallFinder.Observer;

public class WallFinderStatus {
    public boolean sonar   = false;
    public boolean voltage = false;
    public boolean button  = false;

    public WallFinderStatus(boolean sonar, boolean voltage, boolean button) {
        this.sonar = sonar;
        this.voltage = voltage;
        this.button = button;
    }

    public boolean getOr(){
        return sonar || voltage || button;
    }
}
