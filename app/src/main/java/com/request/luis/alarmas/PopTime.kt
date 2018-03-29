package com.request.luis.alarmas

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by kotlin on 29/03/2018.
 */
class PopTime: DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var timeView = inflater!!.inflate(R.layout.poptime, container, false)

        var btnDone = timeView.findViewById<Button>(R.id.btnDone) as Button
        var picker = timeView.findViewById<TimePicker>(R.id.tp) as TimePicker

        btnDone.setOnClickListener {
            val mainActivity = activity as MainActivity
            mainActivity.verHora(picker.hour, picker.minute)
            this.dismiss()
        }

        return timeView
    }
}