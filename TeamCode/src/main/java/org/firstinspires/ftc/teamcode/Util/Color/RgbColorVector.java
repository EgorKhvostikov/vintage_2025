package org.firstinspires.ftc.teamcode.Util.Color;

public class RgbColorVector {
    public int r;
    public int g;
    public int b;

    public RgbColorVector(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static RgbColorVector findNearest(RgbColorVector in, RgbColorVector... maps){
        RgbColorVector min = maps[0];
        int errMin = findErr(in,min);
        for (RgbColorVector i: maps) {
            int  err = findErr(in,i);
            if(err < errMin){
                errMin = err;
                min = i;
            }
        }
        return min;
    }

    private static int findErr(RgbColorVector i, RgbColorVector in){
        return (in.r - i.r)*(in.r - i.r) + (in.g - i.g)*(in.g - i.g) + (in.b - i.b)*(in.b - i.b);
    }
}
