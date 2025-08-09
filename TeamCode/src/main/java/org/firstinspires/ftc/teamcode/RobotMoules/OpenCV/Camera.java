package org.firstinspires.ftc.teamcode.RobotMoules.OpenCV;
import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

/*
  Writing by EgorKhvostikov
*/
public class Camera {
    public OpenCvWebcam camera;
    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    public void init(LinearOpMode opMode) {
        int cameraMonitorViewId = opMode.hardwareMap.appContext.getResources()
                .getIdentifier("cameraMonitorViewId", "id", opMode.hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(
                opMode.hardwareMap.get(WebcamName.class, "Webcam 1"),
                cameraMonitorViewId);
        camera.setPipeline(PuckFinderPipeLine.getInstance());
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                startStream();
            }

            @Override
            public void onError(int errorCode) {
            }
        });
    }

    private void startStream() {
        camera.startStreaming(WIDTH, HEIGHT, OpenCvCameraRotation.SIDEWAYS_LEFT);
        FtcDashboard.getInstance().startCameraStream(camera, 30);
    }

}