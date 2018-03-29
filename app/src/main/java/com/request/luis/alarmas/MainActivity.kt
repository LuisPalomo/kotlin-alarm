package com.request.luis.alarmas

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun establecerHora(view: View) {
        val poptime = PopTime()
        val fManager = supportFragmentManager

        poptime.show(fManager, "Establecer hora")
    }

    fun verHora(hora: Int, minutos: Int) {
        txtHora.text = "$hora:$minutos"
        establecerAlarma(hora, minutos)
    }

    fun establecerAlarma(hora: Int, minutos: Int) {
        // crear una instancia del calendario
        val calendario = Calendar.getInstance()
        calendario.set(Calendar.HOUR_OF_DAY, hora)
        calendario.set(Calendar.MINUTE, minutos)
        calendario.set(Calendar.SECOND, 0)
        //invocar el servicio de alarma (interno)
        val alarmManager = applicationContext.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        // programar la alarma
        var intent = Intent()
        intent.putExtra("mensaje", "Alarma configurada")
        intent.setAction("com.request.luis.alarmas.MY_ALARM")
        sendBroadcast(intent)

//        var intent = Intent(this, MyReceiver::class.java)
//        intent.putExtra("mensaje", "Alarma configurada")
//        intent.setAction("com.request.luis.alarmas.MY_ALARM")
//        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
//        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendario.timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent)
    }
}
