package org.tensorflow.lite.examples.detection.tflite;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

public class DetectorFactory {

    private static final String TAG = "DetectorFactory";

    public static YoloV5Classifier getDetector(
            final AssetManager assetManager,
            final String modelFilename)
            throws IOException {
        String labelFilename = null;
        boolean isQuantized = false;
        int inputSize = 0;
        int[] output_width = new int[]{0};
        int[][] masks = new int[][]{{0}};
        int[] anchors = new int[]{0};

        Log.d(TAG,  "modelName" + modelFilename);

        if (modelFilename.equals("yolov5s.tflite")) {
            labelFilename = "file:///android_asset/customclasses.txt";
            isQuantized = false;
            inputSize = 256;
            output_width = new int[]{80, 40, 20};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }
        else if (modelFilename.equals("best-fp16.tflite")) {
            labelFilename = "file:///android_asset/customclasses.txt";
            isQuantized = false;
            inputSize = 256;
            output_width = new int[]{40, 20, 10};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }
        else if (modelFilename.equals("best-fp.tflite")) {
            labelFilename = "file:///android_asset/customclasses.txt";
            isQuantized = false;
            inputSize = 640;
            output_width = new int[]{40, 20, 10};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }
        else if (modelFilename.equals("yolov5s-int8.tflite")) {
            labelFilename = "file:///android_asset/customclasses.txt";
            isQuantized = true;
            inputSize = 256;
            output_width = new int[]{40, 20, 10};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }
        else if (modelFilename.equals("ml/best.tflite")) {
            labelFilename = "file:///android_asset/customclasses.txt";
            isQuantized = true;
            inputSize = 256;
            output_width = new int[]{40, 20, 10};
            masks = new int[][]{{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
            anchors = new int[]{
                    10,13, 16,30, 33,23, 30,61, 62,45, 59,119, 116,90, 156,198, 373,326
            };
        }

        return YoloV5Classifier.create(assetManager, modelFilename, labelFilename, isQuantized,
                inputSize);
    }

}
