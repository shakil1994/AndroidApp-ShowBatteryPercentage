package com.blackbirds.shakil.batterypercentagewithbroadcastreceiver.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class BatteryReceiver extends BroadcastReceiver {

    TextView textView;

    public BatteryReceiver(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int percentage = intent.getIntExtra("level", 0);
        if (percentage != 0){
            textView.setText(percentage + " %");
        }
    }
}
