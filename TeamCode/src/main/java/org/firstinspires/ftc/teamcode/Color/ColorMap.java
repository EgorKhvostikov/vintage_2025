package org.firstinspires.ftc.teamcode.Color;

import java.util.Arrays;

public class ColorMap {
    public int r;
    public int g;
    public int b;

    public ColorMap(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public static ColorMap findNearest(ColorMap in,ColorMap... maps){
        ColorMap min = maps[0];
        int errMin = findErr(in,min);
        for (ColorMap i: maps) {
            int  err = findErr(in,i);
            if(err < errMin){
                errMin = err;
                min = i;
            }
        }
        return min;
    }

    private static int findErr(ColorMap i, ColorMap in){
        return (in.r - i.r)*(in.r - i.r) + (in.g - i.g)*(in.g - i.g) + (in.b - i.b)*(in.b - i.b);
    }

}
