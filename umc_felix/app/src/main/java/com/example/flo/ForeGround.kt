package com.example.flo

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.Build
import android.os.IBinder

class ForeGround : Service() {
    //foreground가 띄우는 notification이 channel을 사용한다.

    val CHANNEL_ID = "FGS153"

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
        //버전이 oreo이상일 때만 사용 가능하게
        }
    }

    override fun onBind(intent: Intent): IBinder {
        return Binder()
    }
}