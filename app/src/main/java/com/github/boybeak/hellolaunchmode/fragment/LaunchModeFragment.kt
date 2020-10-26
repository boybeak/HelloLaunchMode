package com.github.boybeak.hellolaunchmode.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatSpinner
import com.github.boybeak.hellolaunchmode.R
import com.github.boybeak.hellolaunchmode.activity.*

class LaunchModeFragment : Fragment() {

    companion object {
        private val TAG = LaunchModeFragment::class.java.simpleName
    }

    private val FLAGS = listOf(
        Flag(Intent.FLAG_ACTIVITY_NEW_TASK),
        Flag(Intent.FLAG_ACTIVITY_CLEAR_TASK),
        Flag(Intent.FLAG_ACTIVITY_CLEAR_TOP),
        Flag(Intent.FLAG_ACTIVITY_SINGLE_TOP),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_launch_mode, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<View>(R.id.start_standard).setOnClickListener(::startNewActivityStandard)
        view.findViewById<View>(R.id.start_single_top)
            .setOnClickListener(::startNewActivitySingleTop)
        view.findViewById<View>(R.id.start_single_task)
            .setOnClickListener(::startNewActivitySingleTask)
        view.findViewById<View>(R.id.start_single_instance)
            .setOnClickListener(::startNewActivitySingleInstance)

        val flagGroup = view.findViewById<ViewGroup>(R.id.flagRG)
        val onChecked = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            val index = flagGroup.indexOfChild(buttonView)
            FLAGS[index].checked = isChecked
        }
        view.findViewById<CheckBox>(R.id.cb_new_task).setOnCheckedChangeListener(onChecked)
        view.findViewById<CheckBox>(R.id.cb_clear_task).setOnCheckedChangeListener(onChecked)
        view.findViewById<CheckBox>(R.id.cb_clear_top).setOnCheckedChangeListener(onChecked)
        view.findViewById<CheckBox>(R.id.cb_single_top).setOnCheckedChangeListener(onChecked)

        view.findViewById<View>(R.id.goBTN).setOnClickListener {
            val intent = Intent(requireContext(), FlagActivity::class.java)
            FLAGS.forEach {
                if (it.checked) {
                    intent.addFlags(it.flag)
                }
            }
            startActivity(intent)
        }
        view.findViewById<View>(R.id.go4ResultBTN).setOnClickListener {
            val intent = Intent(requireContext(), FlagActivity::class.java)
            FLAGS.forEach {
                if (it.checked) {
                    intent.addFlags(it.flag)
                }
            }
            startActivityForResult(intent, 100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            Log.v(TAG, "onActivityResult activity=${requireActivity()} resultCode=$resultCode")
            Toast.makeText(requireContext(), "onActivityResult", Toast.LENGTH_SHORT).show()
        }
    }

    fun startNewActivityStandard(v: View) {
        startActivity(Intent(requireContext(), StandardActivity::class.java))
    }

    fun startNewActivitySingleTop(v: View) {
        startActivity(Intent(requireContext(), SingleTopActivity::class.java))
    }

    fun startNewActivitySingleTask(v: View) {
        startActivity(Intent(requireContext(), SingleTaskActivity::class.java))
    }

    fun startNewActivitySingleInstance(v: View) {
        startActivity(Intent(requireContext(), SingleInstanceActivity::class.java))
    }

    private data class Flag(val flag: Int, var checked: Boolean = false)

}