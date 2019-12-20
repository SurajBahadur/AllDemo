package com.app.base.firebase

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.app.base.R
import com.app.base.activity.MainActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.greenrobot.eventbus.EventBus
import java.util.*


class MyFirebaseMessagingService : FirebaseMessagingService() {
    private var notificationManager: NotificationManager? = null
    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)
        Log.d("Message", " " + remoteMessage)
        sendMyNotification(remoteMessage!!.notification!!.body, remoteMessage)

        EventBus.getDefault().post(remoteMessage)
    }

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.d("Token", " " + token)
        //PreferenceClass.setStringPreference(applicationContext, Constants.FCM_TOKEN, token)

    }

    @SuppressLint("ResourceAsColor", "ObsoleteSdkInt")
    private fun sendMyNotification(message: String?, remoteMessage: RemoteMessage) {
        //On click of notification it redirect to this Activity i.e. MainActivity
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("Notification", true);
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        //Setting up Notification channels for android O and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            setupChannels()

        }

        val notificationId = Random().nextInt(60000)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, ADMIN_CHANNEL_ID)
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            notificationBuilder
                    .setSmallIcon(R.drawable.ic_background)  //a resource for your custom small icon
                    .setContentTitle(remoteMessage.notification!!.title) //the "title" value you sent in your notification
                    .setContentText(remoteMessage.data["message"]) //ditto
                    .setContentText(message)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_background))
                    .setAutoCancel(true)  //dismisses the notification on click
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)

        } else {
            notificationBuilder
                    .setSmallIcon(R.drawable.ic_background)  //a resource for your custom small icon
                    .setContentTitle(remoteMessage.notification!!.title) //the "title" value you sent in your notification
                    .setContentText(remoteMessage.data["message"]) //ditto
                    .setContentText(message)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_background))
                    .setAutoCancel(true)  //dismisses the notification on click
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
        }

        notificationManager!!.notify(notificationId /* ID of notification */, notificationBuilder.build())
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private fun setupChannels() {
        val adminChannelName = "Global channel"
        val adminChannelDescription = "Notifications sent from the app admin"
        val adminChannel: NotificationChannel
        adminChannel = NotificationChannel(ADMIN_CHANNEL_ID, adminChannelName, NotificationManager.IMPORTANCE_LOW)
        adminChannel.description = adminChannelDescription
        adminChannel.enableLights(true)
        adminChannel.lightColor = Color.RED
        adminChannel.enableVibration(true)
        if (notificationManager != null) {
            notificationManager!!.createNotificationChannel(adminChannel)
        }
    }

    companion object {
        private val ADMIN_CHANNEL_ID = "admin_channel"
    }
}