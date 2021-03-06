package com.github.boybeak.hellolaunchmode.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.github.boybeak.hellolaunchmode.R

class StandardActivity : AppCompatActivity() {

    companion object {
        private val TAG = StandardActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_mode)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "onNewIntent(${this::class.java.simpleName})", Toast.LENGTH_SHORT).show()
    }

    override fun finish() {
        super.finish()
        Log.v(TAG, "standard onDestroy ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(TAG, "standard onDestroy ")
    }

}