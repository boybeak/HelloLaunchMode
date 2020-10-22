package com.github.boybeak.hellolaunchmode.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.boybeak.hellolaunchmode.R

class SingleTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_task)
    }
}