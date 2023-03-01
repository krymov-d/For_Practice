package kz.kd.for_practice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var tvSubtitle: TextView
    private lateinit var subtitleCross: String
    private lateinit var subtitleZero: String
    private var order = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initSubtitleText()
        initButtons()
    }

    private fun initSubtitleText() {
        tvSubtitle = findViewById(R.id.tv_subtitle)
        subtitleCross = resources.getString(R.string.step_cross)
        subtitleZero = resources.getString(R.string.step_zero)
        tvSubtitle.text = subtitleCross
    }

    private fun initButtons() {
        val btnOne: Button = findViewById(R.id.btn_one)
        btnOne.setOnClickListener {
            setBackground(btnOne)
        }
        val btnTwo: Button = findViewById(R.id.btn_two)
        btnTwo.setOnClickListener {
            setBackground(btnTwo)
        }
        val btnThree: Button = findViewById(R.id.btn_three)
        btnThree.setOnClickListener {
            setBackground(btnThree)
        }
        val btnFour: Button = findViewById(R.id.btn_four)
        btnFour.setOnClickListener {
            setBackground(btnFour)
        }
        val btnFive: Button = findViewById(R.id.btn_five)
        btnFive.setOnClickListener {
            setBackground(btnFive)
        }
        val btnSix: Button = findViewById(R.id.btn_six)
        btnSix.setOnClickListener {
            setBackground(btnSix)
        }
        val btnSeven: Button = findViewById(R.id.btn_seven)
        btnSeven.setOnClickListener {
            setBackground(btnSeven)
        }
        val btnEight: Button = findViewById(R.id.btn_eight)
        btnEight.setOnClickListener {
            setBackground(btnEight)
        }
        val btnNine: Button = findViewById(R.id.btn_nine)
        btnNine.setOnClickListener {
            setBackground(btnNine)
        }
    }

    private fun setBackground(button: Button) {
        if (order) {
            button.setBackgroundResource(R.drawable.btn_bg_cross)
            tvSubtitle.text = subtitleZero
            order = !order
        } else {
            button.setBackgroundResource(R.drawable.btn_bg_zero)
            tvSubtitle.text = subtitleCross
            order = !order
        }
    }
}