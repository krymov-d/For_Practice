package kz.kd.for_practice

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onBtnClicked()
    }

    private fun onBtnClicked() {
        val btnDatePicker: Button = findViewById(R.id.btn_date_picker)
        btnDatePicker.setOnClickListener {
            val onDateSetListener =
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    Toast.makeText(
                        this,
                        "Chosen $dayOfMonth/$month/$year",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            DatePickerDialog(this, onDateSetListener, 2023, 1, 19).show()
        }

        val btnTimePicker: Button = findViewById(R.id.btn_time_picker)
        btnTimePicker.setOnClickListener {
            val onTimeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                Toast.makeText(
                    this,
                    "Chosen $hour:$minute",
                    Toast.LENGTH_SHORT
                ).show()
            }
            TimePickerDialog(this, onTimeSetListener, 0, 0, true).show()
        }

        val btnAlertDialog: Button = findViewById(R.id.btn_alert_dialog)
        btnAlertDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("My First Alert Dialog")
                .setPositiveButton("OK") { _, _ ->
                    Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { _, _ ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("I do not know") { _, _ ->
                    Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        val btnAlertDialogList: Button = findViewById(R.id.btn_alert_dialog_list)
        btnAlertDialogList.setOnClickListener {
            val students = arrayOf("Student 1", "Student 2", "Student 3", "Student 4")
            AlertDialog.Builder(this)
                .setTitle("My First Alert Dialog")
                .setPositiveButton("OK") { _, _ ->
                    Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel") { _, _ ->
                    Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("I do not know") { _, _ ->
                    Toast.makeText(this, "Neutral", Toast.LENGTH_SHORT).show()
                }
                .apply {
                    setTitle("Student list")
                    setItems(students) { _, itemIndex ->
                        Toast.makeText(
                            this@MainActivity,
                            "Clicked ${students[itemIndex]}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                .show()
        }

        val btnAlertDialogMultiple: Button = findViewById(R.id.btn_alert_dialog_multiple)
        btnAlertDialogMultiple.setOnClickListener {
            val students = arrayOf("Student 1", "Student 2", "Student 3", "Student 4")
            val studentsStatus = booleanArrayOf(true, false, false, false)
            AlertDialog.Builder(this)
                .apply {
                    setTitle("Student list")
                    setMultiChoiceItems(students, studentsStatus) { _, itemIndex, itemStatus ->
                        val isChecked = if (itemStatus) "Checked" else "Not checked"
                        Toast.makeText(
                            this@MainActivity,
                            "Student ${students[itemIndex]} $isChecked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                .show()
        }

        val btnAlertDialogSingle: Button = findViewById(R.id.btn_alert_dialog_single)
        btnAlertDialogSingle.setOnClickListener {
            val students = arrayOf("Student 1", "Student 2", "Student 3", "Student 4")
            AlertDialog.Builder(this)
                .apply {
                    setTitle("Student list")
                    setSingleChoiceItems(students, 0) { _, itemIndex ->
                        Toast.makeText(
                            this@MainActivity,
                            "Student ${students[itemIndex]} is checked",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                .show()
        }

        val btnDialogCustom: Button = findViewById(R.id.btn_dialog_custom)
        btnDialogCustom.setOnClickListener {
            val customView: View = layoutInflater.inflate(R.layout.dialog_custom, null)
            val dialog: AlertDialog = AlertDialog.Builder(this).apply {
                setView(customView)
            }.create()
            with(customView) {
                findViewById<TextView>(R.id.title).text = "Custom title"
                findViewById<TextView>(R.id.subtitle).text = "Custom subtitle"
                findViewById<Button>(R.id.closeButton).setOnClickListener {
                    dialog.dismiss()
                }
            }
            dialog.show()
        }

        val btnFirstDialogFragment: Button = findViewById(R.id.btn_first_dialog_fragment)
        btnFirstDialogFragment.setOnClickListener {
            FirstDialogFragment().show(supportFragmentManager, null)
        }

        val flSecondDialogFragment: FrameLayout = findViewById(R.id.fl_fragment_container)
        flSecondDialogFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().add(R.id.fl_fragment_container, SecondDialogFragment()).commit()
            FirstDialogFragment().show(supportFragmentManager, null)
        }
    }
}