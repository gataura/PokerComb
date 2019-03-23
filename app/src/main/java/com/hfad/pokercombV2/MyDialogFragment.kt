package com.hfad.pokercombV2

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.TextView

class MyDialogFragment: DialogFragment() {

    lateinit var mPrefs: SharedPreferences

    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        mPrefs = this.requireContext().getSharedPreferences("gameData", Context.MODE_PRIVATE)

        val builder:AlertDialog.Builder = AlertDialog.Builder(this.requireActivity())
        val inflater:LayoutInflater = this.requireActivity().layoutInflater

        val layout = inflater.inflate(R.layout.answer_dialog_alert, null)

        val button: Button = layout.findViewById(R.id.continue_button)
        val ansText: TextView = layout.findViewById(R.id.answer)
        val bestCombo: TextView = layout.findViewById(R.id.best_comb)
        val ansIn:TextView = layout.findViewById(R.id.answered_in)
        val averageTime: TextView = layout.findViewById(R.id.average_speed)
        val accuracy: TextView = layout.findViewById(R.id.accuracy)

        val combo = mPrefs.getString("combo", "not")
        val ansCombo = mPrefs.getString("ansCombo", "yes")
        val rightAns = mPrefs.getInt("rightAns", 1)
        val wrongAns = mPrefs.getInt("wrongAns", 1)
        val average = mPrefs.getLong("allTime", 0)/mPrefs.getInt("allClicks", 1)

        bestCombo.text = "Лучшая комбинация: $combo"
        ansIn.text = "Отвечено за ${mPrefs.getString("timer", "0.0")} сек"
        averageTime.text = "Средняя скорость: $average сек"
        accuracy.text = "Точность: $rightAns/${rightAns+wrongAns}"

        if (ansCombo == combo) {
            ansText.text = "Correct!"
        } else {
            ansText.text = "Nope!"
        }

        button.setOnClickListener {
            (this.requireActivity() as GameActivity).initialize()
            dismiss()
        }

        builder.setView(layout)

        val dialog = builder.create()

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window?.setGravity(Gravity.BOTTOM)

        return dialog
    }


}