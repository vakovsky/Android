package bg.tcom.c12v1gr.demo122applivation;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//https://developer.android.com/training/camera/cameradirect

public class AndroidSurfaceviewExample extends Activity {

    SurfaceHolder.Callback scb;

    TextView testView;

    TextView tv0;
    TextView tv1;
    TextView tv2;

    Camera camera;
    SurfaceView surfaceView;
    SurfaceHolder surfaceHolder;

    PictureCallback rawCallback;
    ShutterCallback shutterCallback;
    PictureCallback jpegCallback;

    SensorManager mSensorManager;
    Sensor mSensor;
    SensorEventListener sensorEventListener;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_android_surfaceview_example);


        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();

        tv0 = findViewById(R.id.tv0);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);


        scb = new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                try {
                    // open the camera
                    camera = Camera.open();
                } catch (RuntimeException e) {
                    // check for exceptions
                    System.err.println(e);
                    return;
                }
                Camera.Parameters param;
                param = camera.getParameters();
                // modify parameter
                param.setPreviewSize(352, 288);
                camera.setParameters(param);
                try {
                    // The Surface has been created, now tell the camera where to draw
                    // the preview.
                    camera.setPreviewDisplay(surfaceHolder);
                    camera.startPreview();
                } catch (Exception e) {
                    // check for exceptions
                    System.err.println(e);
                    return;
                }
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
                // Now that the size is known, set up the camera parameters and begin
                // the preview.
                refreshCamera();
            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
                // stop preview and release camera
                camera.stopPreview();
                camera.release();
                camera = null;
            }
        };

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        surfaceHolder.addCallback(scb);

        // deprecated setting, but required on Android versions prior to 3.0
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        jpegCallback = new PictureCallback() {
            public void onPictureTaken(byte[] data, Camera camera) {
                FileOutputStream outStream = null;
                try {
                    outStream = new FileOutputStream(String.format("/sdcard/%d.jpg", System.currentTimeMillis()));
                    outStream.write(data);
                    outStream.close();
                    Log.d("Log", "onPictureTaken - wrote bytes: " + data.length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                }
                Toast.makeText(getApplicationContext(), "Picture Saved", Toast.LENGTH_LONG).show();
                refreshCamera();
            }
        };

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    //if (event.values[0] == 0) {
                        tv0.setText(Float.toString(event.values[0]));
                        tv1.setText(Float.toString(event.values[0]));
                        tv2.setText(Float.toString(event.values[0]));
                        //Camera.Parameters param;
                        //param = camera.getParameters();
                        //param.setRotation((int)event.values[0]);
                        //camera.setDisplayOrientation((int)event.values[0]);
                        //mp.start();
                        //iv1.setImageResource(R.drawable.bddoc);
                    //} else {
                        //iv1.setImageResource(R.drawable.omar);
                        //mp.stop();
                    //}
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

    }

    public void captureImage(View v) throws IOException {
        //take the picture
        camera.takePicture(null, null, jpegCallback);
    }

    public void refreshCamera() {
        if (surfaceHolder.getSurface() == null) {
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            camera.stopPreview();
        } catch (Exception e) {
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here
        // start preview with new settings
        try {
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();
        } catch (Exception e) {

        }
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
     }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }

}
