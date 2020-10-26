package com.github.boybeak.app2

import android.app.IntentService
import android.content.Intent

class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        startActivity(Intent("com.github.boybeak.hellolaunchmode.flag").apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })
    }
}