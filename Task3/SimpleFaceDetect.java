import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import nu.pattern.OpenCV;

public class SimpleFaceDetect {

    public static void main(String[] args) {

        OpenCV.loadLocally();

        CascadeClassifier faceCascade = new CascadeClassifier("haarcascade_frontalface_default");

        Mat originalImage = Imgcodecs.imread("input.jpg");

        if (originalImage.empty()) {
            System.out.println("Cannot read the image file!");
            return;
        }

        MatOfRect detectedFaces = new MatOfRect();

        faceCascade.detectMultiScale(originalImage, detectedFaces);

        for (Rect face : detectedFaces.toArray()) {
            Point topLeft = new Point(face.x, face.y);
            Point bottomRight = new Point(face.x + face.width, face.y + face.height);

            Imgproc.rectangle(originalImage, topLeft, bottomRight, new Scalar(0, 200, 0), 3);
        }

        Imgcodecs.imwrite("output.jpg", originalImage);

        System.out.println("Number of faces found: " + detectedFaces.toArray().length);
    }
}
