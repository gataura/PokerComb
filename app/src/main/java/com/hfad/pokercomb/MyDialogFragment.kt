package com.hfad.pokercomb

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MyDialogFragment: DialogFragment() {

    lateinit var mPrefs: SharedPreferences

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        mPrefs = this.requireContext().getSharedPreferences("gameData", Context.MODE_PRIVATE)

        var builder:AlertDialog.Builder = AlertDialog.Builder(this.requireActivity())
        var inflater:LayoutInflater = this.requireActivity().layoutInflater

        var layout = inflater.inflate(R.layout.answer_dialog_alert, null)

        var button: Button = layout.findViewById(R.id.continue_button)
        var ansText: TextView = layout.findViewById(R.id.answer)
        var bestCombo: TextView = layout.findViewById(R.id.best_comb)
        var ansIn:TextView = layout.findViewById(R.id.answered_in)
        var averageTime: TextView = layout.findViewById(R.id.average_speed)
        var accuracy: TextView = layout.findViewById(R.id.accuracy)

        var combo = mPrefs.getString("combo", "not")
        var ansCombo = mPrefs.getString("ansCombo", "yes")
        var rightAns = mPrefs.getInt("rightAns", 1)
        var wrongAns = mPrefs.getInt("wrongAns", 1)
        var average = mPrefs.getLong("allTime", 0)/mPrefs.getInt("allClicks", 1)

        bestCombo.text = "Best combination is $combo"
        ansIn.text = "Answered in ${mPrefs.getString("timer", "0.0")} sec"
        averageTime.text = "Average speed is $average sec"
        accuracy.text = "Accuracy: $rightAns/${rightAns+wrongAns}"

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

        var dialog = builder.create()

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window.setGravity(Gravity.BOTTOM)

        return dialog
    }


}