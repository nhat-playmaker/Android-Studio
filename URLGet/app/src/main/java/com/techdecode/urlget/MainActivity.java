package com.techdecode.urlget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import java.nio.charset.Charset;

public class MainActivity extends AppCompatActivity {

    public static TextView txtOut;
    MQTTHelper mqttHelper;
    TextView txtTopic, txtData;
    EditText editText;
    Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        txtOut = findViewById(R.id.txtOut);
//
//        fetchData process = new fetchData();
//        process.execute();
        txtTopic = findViewById(R.id.topic);
        txtData = findViewById(R.id.data);
        editText = findViewById(R.id.editText);
        buttonSend = findViewById(R.id.buttonSend);
        startMQTT();

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToMQTT("C001", editText.getText().toString());
            }
        });

    }

    private void startMQTT() {
        mqttHelper = new MQTTHelper(getApplicationContext());
        mqttHelper.setCallback(new MqttCallbackExtended() {
            @Override
            public void connectComplete(boolean reconnect, String serverURI) {

            }

            @Override
            public void connectionLost(Throwable cause) {

            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                txtTopic.setText(topic);
                txtData.setText(message.toString());
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }
        });
    }

    private void sendDataToMQTT(String ID, String value) {

        MqttMessage msg = new MqttMessage();
        // Id của message, có thể trùng nhau
        msg.setId(1234);
        // QoS = 0 là nhanh nhất, nhưng tỉ lệ lỗi cao, lỗi thì gửi lại
        // Có các mức từ 0 -> 4 (gần như là HTTP và chậm)
        msg.setQos(0);
        //
        msg.setRetained(true);

        String data = ID + ":" + value;

        byte[] b = data.getBytes(Charset.forName("UTF-8"));
        msg.setPayload(b);

        try {
            mqttHelper.mqttAndroidClient.publish("nhat_playmaker/feeds/test-iot-19-slash-04-slash-2021", msg);
        }
        catch (MqttException e) {
            // Do nothing
        }
    }


    }