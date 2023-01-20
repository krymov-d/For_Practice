package kz.kd.for_practice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class SecondDialogFragment: DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  customView2: View = layoutInflater.inflate(R.layout.dialog_custom, null)
        with (customView2) {
            findViewById<TextView>(R.id.title).text = "Custom title 2"
            findViewById<TextView>(R.id.subtitle).text = "Custom subtitle 2"
            findViewById<Button>(R.id.closeButton).setOnClickListener {
                dismiss()
            }
        }
        return customView2
    }
}