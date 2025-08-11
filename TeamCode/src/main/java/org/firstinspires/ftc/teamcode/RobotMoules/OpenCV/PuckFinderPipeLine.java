package org.firstinspires.ftc.teamcode.RobotMoules.OpenCV;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.TermCriteria;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.ArrayList;
import java.util.List;

public class PuckFinderPipeLine extends OpenCvPipeline {
    private static final PuckFinderPipeLine Instance = new PuckFinderPipeLine();
    public static PuckFinderPipeLine getInstance() {
        return Instance;
    }
    public double puckAngle = 0;

    @Override
    public Mat processFrame(Mat input) {

        input = input.reshape(240,240);

        Imgproc.bilateralFilter(input,input,-1,PipeLineConfig.sigmaColorFilter,PipeLineConfig.sigmaSpaceFilter);

        Imgproc.cvtColor(input,input,Imgproc.COLOR_BGR2HSV);

        Core.kmeans(input,PipeLineConfig.K,new Mat(),new TermCriteria(),PipeLineConfig.attemps,Core.KMEANS_PP_CENTERS);

        Mat bin = new Mat();
        Core.inRange(input,PipeLineConfig.downHsv,PipeLineConfig.upHsv,bin);

        List<MatOfPoint> contr = new ArrayList<>();
        Imgproc.findContours(bin,contr,new Mat(),Imgproc.RETR_EXTERNAL,Imgproc.CHAIN_APPROX_SIMPLE);

        List<MatOfPoint> contrPuck = new ArrayList<>();
        for (MatOfPoint i: contr) {
            if(Imgproc.contourArea(i) > PipeLineConfig.puckAreaDown && Imgproc.contourArea(i) < PipeLineConfig.puckAreaUp){
                contrPuck.add(i);
            }
        }

        List<Point> centers = new ArrayList();
        for(MatOfPoint i: contrPuck){
            Moments m = Imgproc.moments(i);
            int cx = (int) (m.m10/m.m00);
            int cy = (int) (m.m01/m.m00);
            centers.add(new Point(cx,cy));
        }


        return null;
    }
}
