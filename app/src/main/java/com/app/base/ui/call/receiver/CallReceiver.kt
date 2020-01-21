package com.app.base.ui.call.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.media.RingtoneManager
import android.telephony.PhoneStateListener
import android.telephony.TelephonyManager
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.app.base.room.database.FactDatabase
import com.app.base.ui.call.CallViewModel
import java.util.*

class CallReceiver : BroadcastReceiver() {
    var numberList: MutableList<String> = ArrayList()
    override fun onReceive(context: Context, intent: Intent) {
        Log.d("tttt", intent.getStringExtra("state"))
        numberList.add("+919149419081")
        numberList.add("+917355173572")

        val contactDao = FactDatabase.getInstance(context)!!.contactDao()
        Log.d("ttttd", contactDao.getNumberDetail("123456789").size.toString())
        val telephony = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        telephony.listen(object : PhoneStateListener() {
            override fun onCallStateChanged(state: Int, Number: String) {
                super.onCallStateChanged(state, Number)
                Log.d("tttt", Number)
                Toast.makeText(context, Number, Toast.LENGTH_SHORT).show()
                // Compare your number to from this `Number` if it is found in you list then make ring state RINGER_MODE_NORMAL
                // else make it to RINGER_MODE_SILENT
                if (!numberList.contains(Number)) { // to make Ring state silent
                    /*AudioManager audiomanager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
                    audiomanager.setRingerMode(AudioManager.RINGER_MODE_SILENT);*/
                } else { // to make Ring state Normal (Ringable)
                    val audiomanager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                    audiomanager.ringerMode = AudioManager.RINGER_MODE_NORMAL
                    audiomanager.setStreamVolume(AudioManager.STREAM_ALARM, 50, 0)
                    val notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
                    val r = RingtoneManager.getRingtone(context, notification)
                    r.play()
                }
            }
        }, PhoneStateListener.LISTEN_CALL_STATE)
    }
}