package com.request.luis.alarmas

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat

/**
 * Created by kotlin on 29/03/2018.
 */
class Notifications {
    fun notify(context: Context, message: String) {
        val builder = NotificationCompat.Builder(context)
                .setDefaults(Notification.DEFAULT_ALL)
                .setContentTitle(context.resources.getString(R.string.notif_title))
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_media_play)
                .setAutoCancel(true)
                .setContentIntent(PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), 0))

        val notificator = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificator.notify("NOTIF_TAG", 0, builder.build())

    }
}