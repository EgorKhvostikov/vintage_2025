package org.firstinspires.ftc.teamcode.Util.Math.Position;

import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.signum;
import static java.lang.Math.sin;

public class Position {
    public double x;
    public double y;
    public double h;

    public void setH(double h) {
        this.h = h;
    }

    public Position(double x, double y, double h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public Position() {
        this.x = 0;
        this.y = 0;
        this.h = 0;
    }

    public void rotateVector(double angle) {
        double angle1 = Math.toRadians(angle);
        double y1 = y * cos(angle1) - x * sin(angle1);
        x = y * sin(angle1) + x * cos(angle1);
        y = y1;
    }

    public Position vectorMinus(Position pos) {
        x -= pos.x;
        y -= pos.y;
        return this;
    }

    public void positionMinus(Position pos){
        x -= pos.x;
        y -= pos.y;
        h -= pos.h;
    }
    public Position positionPlus(Position pos){
        x += pos.x;
        y += pos.y;
        h += pos.h;
        return this;
    }

    public Position vectorPlus(Position pos) {
        x += pos.x;
        y += pos.y;
        return this;
    }

    public static double normalizeAngle(double error){
        while (abs(error)>180) error -=360*signum(error);
        return error;
    }

    public Position copyFrom(Position p){
        this.x = p.x;
        this.h = p.h;
        this.y = p.y;
        return this;
    }


    public void angleMultiply(double k){
        this.h = h*k;
    }

    public Position linearMultiply(double k) {
        this.x = x*k;
        this.y = y*k;
        return this;
    }

    public double getLength(){
        return Math.sqrt(x*x+y*y) ;
    }

    public static double length(Position s, Position e){
        return Math.sqrt((s.x-e.x)*(s.x-e.x) - (s.y-e.y)*(s.y-e.y));
    }

    @Override
    public String toString(){
        return "x: " + x + " y: " + y;
    }
}
