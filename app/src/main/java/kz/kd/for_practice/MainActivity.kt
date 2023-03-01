package kz.kd.for_practice

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), IFBtnNewGame {
    private lateinit var tvSubtitle: TextView
    private lateinit var subtitleCross: String
    private lateinit var subtitleZero: String
    private var order = true
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button

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
        btnOne = findViewById(R.id.btn_one)
        btnOne.setOnClickListener {
            setBackground(btnOne)
            verifyState()
        }
        btnTwo = findViewById(R.id.btn_two)
        btnTwo.setOnClickListener {
            setBackground(btnTwo)
            verifyState()
        }
        btnThree = findViewById(R.id.btn_three)
        btnThree.setOnClickListener {
            setBackground(btnThree)
            verifyState()
        }
        btnFour = findViewById(R.id.btn_four)
        btnFour.setOnClickListener {
            setBackground(btnFour)
            verifyState()
        }
        btnFive = findViewById(R.id.btn_five)
        btnFive.setOnClickListener {
            setBackground(btnFive)
            verifyState()
        }
        btnSix = findViewById(R.id.btn_six)
        btnSix.setOnClickListener {
            setBackground(btnSix)
            verifyState()
        }
        btnSeven = findViewById(R.id.btn_seven)
        btnSeven.setOnClickListener {
            setBackground(btnSeven)
            verifyState()
        }
        btnEight = findViewById(R.id.btn_eight)
        btnEight.setOnClickListener {
            setBackground(btnEight)
            verifyState()
        }
        btnNine = findViewById(R.id.btn_nine)
        btnNine.setOnClickListener {
            setBackground(btnNine)
            verifyState()
        }
    }

    private fun setBackground(button: Button) {
        button.isClickable = false
        if (order) {
            button.setBackgroundResource(R.drawable.btn_bg_cross)
            button.text = "X"
            tvSubtitle.text = subtitleZero
            order = !order
        } else {
            button.setBackgroundResource(R.drawable.btn_bg_zero)
            button.text = "O"
            tvSubtitle.text = subtitleCross
            order = !order
        }
    }

    private fun verifyState() {
        if (btnOne.text == btnTwo.text && btnTwo.text == btnThree.text && btnOne.text != "") {
            showDialog(btnOne.text.toString())
        } else if (btnOne.text == btnFour.text && btnFour.text == btnSeven.text && btnOne.text != "") {
            showDialog(btnOne.text.toString())
        } else if (btnOne.text == btnFive.text && btnFive.text == btnNine.text && btnOne.text != "") {
            showDialog(btnOne.text.toString())
        } else if (btnTwo.text == btnFive.text && btnFive.text == btnEight.text && btnTwo.text != "") {
            showDialog(btnTwo.text.toString())
        } else if (btnThree.text == btnSix.text && btnSix.text == btnNine.text && btnThree.text != "") {
            showDialog(btnThree.text.toString())
        } else if (btnThree.text == btnFive.text && btnFive.text == btnSeven.text && btnThree.text != "") {
            showDialog(btnThree.text.toString())
        } else if (btnFour.text == btnFive.text && btnFive.text == btnSix.text && btnFour.text != "") {
            showDialog(btnFour.text.toString())
        } else if (btnSeven.text == btnEight.text && btnEight.text == btnNine.text && btnSeven.text != "") {
            showDialog(btnSeven.text.toString())
        }
    }

    private fun showDialog(text: String) {
        DFWin(this, text).show(supportFragmentManager, null)
    }

    override fun btnNewGameClicked() {
        btnOne.setBackgroundResource(R.drawable.btn_bg_default)
        btnOne.isClickable = true
        btnOne.text = ""
        btnTwo.setBackgroundResource(R.drawable.btn_bg_default)
        btnTwo.isClickable = true
        btnTwo.text = ""
        btnThree.setBackgroundResource(R.drawable.btn_bg_default)
        btnThree.isClickable = true
        btnThree.text = ""
        btnFour.setBackgroundResource(R.drawable.btn_bg_default)
        btnFour.isClickable = true
        btnFour.text = ""
        btnFive.setBackgroundResource(R.drawable.btn_bg_default)
        btnFive.isClickable = true
        btnFive.text = ""
        btnSix.setBackgroundResource(R.drawable.btn_bg_default)
        btnSix.isClickable = true
        btnSix.text = ""
        btnSeven.setBackgroundResource(R.drawable.btn_bg_default)
        btnSeven.isClickable = true
        btnSeven.text = ""
        btnEight.setBackgroundResource(R.drawable.btn_bg_default)
        btnEight.isClickable = true
        btnEight.text = ""
        btnNine.setBackgroundResource(R.drawable.btn_bg_default)
        btnNine.isClickable = true
        btnNine.text = ""
        tvSubtitle.text = subtitleCross
    }
}