package org.firstinspires.ftc.teamcode.Util.Math.Pid;

import static java.lang.Math.abs;
import static java.lang.Math.signum;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Util.Math.Position.Position;

public class Pid {
    private final PidConfig status;

    public Pid(PidConfig status) {
        this.status = status;
    }

    public double getPos() {
        return pos;
    }

    public String name;

    public boolean isAngle = false;
    public void setName(String n) {
        name = n;
    }

    private double tLast = (double) System.nanoTime() / (double) ElapsedTime.SECOND_IN_NANO;
    private double errLast = 0;
    private double P = 0;
    private double I = 0;
    private double D = 0;
    private double F = 0;
    private double u = 0;
    private double target = 0;
    private double pos = 0;

    public void setPos(double pos) {
        this.pos = pos;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public double getU() {
        return u;
    }

    public void update() {
        calc();
    }

    double err = 0;

    private void calc() {
        err = target - pos;

        if(isAngle){
            err = Position.normalizeAngle(err);
        }

        double dErr = err - errLast;
        errLast = err;

        double tNow = (double) System.nanoTime() / (double) ElapsedTime.SECOND_IN_NANO;
        double dt = tNow - tLast;
        tLast = tNow;

        P = status.kp * err;
        I += status.ki * err * dt;
        D = status.kd * dErr / dt;
        F = status.kf0+
                status.kf1*target+
                status.kf2*target*target+
                status.kf3*target*target*target
        ;

        if (abs(I) > status.maxI) {
            I = status.maxI * signum(I);
        }
        double u = P + I + D + F;

        if (abs(u) < status.zeroBorder) {
            u = 0;
        }
        this.u = u;
    }

}
