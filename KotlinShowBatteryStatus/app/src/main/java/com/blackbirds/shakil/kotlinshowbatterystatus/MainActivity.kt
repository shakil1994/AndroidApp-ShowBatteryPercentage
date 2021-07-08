package com.blackbirds.shakil.kotlinshowbatterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var txtBatteryStatus: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtBatteryStatus = findViewById(R.id.txtBatteryStatus)

        registerReceiver(this.mBatteryInfoReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    private val mBatteryInfoReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val level = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL,-1)
            val scale = intent!!.getIntExtra(BatteryManager.EXTRA_SCALE,-1)

            val batteryPct = level * 100 / scale.toFloat()

            txtBatteryStatus!!.text = "Battery Status: $batteryPct%"
        }
    }
}