package bg.tcom.c12v1gr.demo122applivation;

import android.app.ListActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class SenActivity extends ListActivity implements SensorEventListener {
    TextView tvInfo;
    private SensorManager sensorManager;
    private Sensor mSensor;
    private Sensor mLightSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sen);

        tvInfo = findViewById(R.id.tvInfo);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        String[] arr = new String[sensors.size()];
        int i = 0;
        for(Sensor item : sensors) {
            arr[i] = item.toString();
            i++;
        }

        this.setListAdapter(new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, arr));

        mLightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
    }

    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, mLightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LIGHT) {
            tvInfo.setText(Float.toString(event.values[0]));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
