package com.github.boybeak.hellolaunchmode.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.github.boybeak.hellolaunchmode.R

class SingleTopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_top)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Toast.makeText(this, "onNewIntent", Toast.LENGTH_SHORT).show()
    }

    fun startMyself(v: View) {
        startActivity(Intent(this, SingleTopActivity::class.java))
    }
}