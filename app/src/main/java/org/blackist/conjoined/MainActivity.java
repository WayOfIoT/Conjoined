package org.blackist.conjoined;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.blackist.conjoined.common.entity.DeviceType;
import org.blackist.conjoined.common.entity.Sensor;
import org.blackist.conjoined.common.util.http.OkHttpGetTask;
import org.blackist.conjoined.common.util.http.OkHttpPostTask;
import org.blackist.conjoined.common.util.http.OkHttpTaskEndListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.lever_sensor_display)
    TextView mSensorView;

    private float mTemp = 35;
    private int mHumi = 75;

    private List<Sensor> mSensorList;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mHandler = new Handler(getMainLooper());


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getSensor();
            }
        }, 0, 3 * 1000);
    }

    @OnClick({
            R.id.lever_temp_up,
            R.id.lever_temp_down,
            R.id.lever_humi_up,
            R.id.lever_humi_down,
            R.id.lever_sensor_get
    })
    public void onClick(View view) {
        Log.d(TAG, "onClick: ");

        switch (view.getId()) {
            case R.id.lever_temp_up: {
                Log.d(TAG, "[Sensor]: temp up.");
                mTemp++;
                updateSensor();
            }
            break;

            case R.id.lever_temp_down: {
                Log.d(TAG, "[Sensor]: temp down.");
                mTemp--;
                updateSensor();
            }
            break;

            case R.id.lever_humi_up: {
                Log.d(TAG, "[Sensor]: humi up.");
                mHumi++;
                updateSensor();
            }
            break;

            case R.id.lever_humi_down: {
                Log.d(TAG, "[Sensor]: humi down.");
                mHumi--;
                updateSensor();
            }
            break;

            case R.id.lever_sensor_get: {
                getSensor();
            }
            break;

            default:
        }
    }

    private void updateSensor() {
        JSONArray data = new JSONArray();
        try {
            JSONObject humi = new JSONObject();
            JSONObject temp = new JSONObject();

            humi.put("Name", "demohumi");
            humi.put("Value", mHumi + "");
            temp.put("Name", "demotemp");
            temp.put("Value", mTemp + "");

            data.put(humi);
            data.put(temp);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String[] params = {
                "http://www.lewei50.com/api/V1/gateway/UpdateSensors/02",
                "userkey",
                "1f53e6d37ba243b0baa8146955111f75",
                data.toString()
        };
        new OkHttpPostTask()
                .setHeader(true)
                .setOnTaskEndListener(new OkHttpPostTask.OnTaskEndListener() {
                    @Override
                    public void onTaskEnd(String response) {
                        Log.d(TAG, "[Sensor]: update " + response);
                    }
                })
                .execute(params);
    }

    private String getSensor() {

        String[] params = {
                "http://www.lewei50.com/api/V1/user/getSensorsWithGateway",
                "userkey",
                "1f53e6d37ba243b0baa8146955111f75"
        };

        new OkHttpGetTask()
                .setHeader(true)
                .setOnTaskEndListener(new OkHttpTaskEndListener() {
                    @Override
                    public void onTaskEnd(String response) {
                        Log.d(TAG, "[Sensor]: get " + response);
                        handleGateway(response);
                    }
                })
                .execute(params);

        return null;
    }

    private void handleGateway(String gatewayInfo) {
        try {
            JSONArray gateways = new JSONArray(gatewayInfo);
            for (int i = 0; i < gateways.length(); i++) {
                JSONObject gateway = (JSONObject) gateways.get(i);
                mSensorList = handleSensor(gateway.getString("sensors"));
                refreshSensorView(mSensorList);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private List<Sensor> handleSensor(String sensorsInfo) {
        List<Sensor> sensorList = new ArrayList<>();
        try {
            JSONArray sensors = new JSONArray(sensorsInfo);
            for (int i = 0; i < sensors.length(); i++) {
                JSONObject sensorInfo = (JSONObject) sensors.get(i);
                Sensor sensor = new Gson().fromJson(sensorInfo.toString(), Sensor.class);
                sensorList.add(sensor);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sensorList;
    }

    private void refreshSensorView(List<Sensor> sensors) {
        for (Sensor sensor : sensors) {
            if (!sensor.getType().equals(DeviceType.SENSOR_TEMP))
                continue;
            mTemp = Float.parseFloat(sensor.getValue());
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    mSensorView.setText(mTemp + "");
                }
            });
            break;
        }
    }
}
