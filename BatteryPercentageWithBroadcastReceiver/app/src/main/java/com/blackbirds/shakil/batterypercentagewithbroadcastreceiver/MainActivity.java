package com.blackbirds.shakil.batterypercentagewithbroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

import com.blackbirds.shakil.batterypercentagewithbroadcastreceiver.Service.BatteryReceiver;

public class MainActivity extends AppCompatActivity {

    TextView txtBatteryPercentage;
    BatteryReceiver batteryReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtBatteryPercentage = findViewById(R.id.txtBatteryPercentage);

        batteryReceiver = new BatteryReceiver(txtBatteryPercentage);

        registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(batteryReceiver);
    }
}