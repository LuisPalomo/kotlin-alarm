package com.request.luis.alarmas

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        if(intent.action.equals("com.request.luis.alarmas.MY_ALARM") || intent.action.equals("android.intent.action.BOOT_COMPLETED")){

            Toast.makeText(context, "Esto no sale...", Toast.LENGTH_SHORT).show()
            Notifications().notify(context, "Notificasionasa")
        }
    }
}
