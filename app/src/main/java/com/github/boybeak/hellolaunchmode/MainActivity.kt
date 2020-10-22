package com.github.boybeak.hellolaunchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.github.boybeak.hellolaunchmode.activity.SingleInstanceActivity
import com.github.boybeak.hellolaunchmode.activity.SingleTaskActivity
import com.github.boybeak.hellolaunchmode.activity.SingleTopActivity
import com.github.boybeak.hellolaunchmode.activity.StandardActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startNewActivityStandard(v: View) {
        startActivity(Intent(this, StandardActivity::class.java))
    }

    fun startNewActivitySingleTop(v: View) {
        startActivity(Intent(this, SingleTopActivity::class.java))
    }

    fun startNewActivitySingleTask(v: View) {
        startActivity(Intent(this, SingleTaskActivity::class.java))
    }

    fun startNewActivitySingleInstance(v: View) {
        startActivity(Intent(this, SingleInstanceActivity::class.java))
    }

}