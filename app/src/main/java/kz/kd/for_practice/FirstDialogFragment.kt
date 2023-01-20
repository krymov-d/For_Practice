package kz.kd.for_practice

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class FirstDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val customView: View = layoutInflater.inflate(R.layout.dialog_custom, null)
        val dialog: AlertDialog = AlertDialog.Builder(requireContext()).apply {
            setView(customView)
        }.create()
        with(customView) {
            findViewById<TextView>(R.id.title).text = "Custom title"
            findViewById<TextView>(R.id.subtitle).text = "Custom subtitle"
            findViewById<Button>(R.id.closeButton).setOnClickListener {
                dialog.dismiss()
            }
        }
        return dialog
    }
}