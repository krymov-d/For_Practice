package kz.kd.for_practice

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SecondActivity: AppCompatActivity(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val chipGroup: ChipGroup = findViewById(R.id.chip_group)
        val arr = listOf("A", "B", "C")
        arr.forEach{
            (layoutInflater.inflate(R.layout.chip_choice, chipGroup, false) as? Chip)?.let{chip ->
                chip.id = View.generateViewId()
                chip.text = it
                chip.setOnCheckedChangeListener{_, isChecked ->
                    if (isChecked) {
                        Log.d("chip click", "chip id: ${chip.id}, text: $it")
                    }
                }
                chipGroup.addView(chip)
            }
        }
        val chip = chipGroup.getChildAt(4)
        chipGroup.check(chip.id)
    }
}