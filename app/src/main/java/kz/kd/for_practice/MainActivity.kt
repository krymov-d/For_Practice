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
    private var btnList: MutableList<Button> = mutableListOf()

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
        btnTwo = findViewById(R.id.btn_two)
        btnThree = findViewById(R.id.btn_three)
        btnFour = findViewById(R.id.btn_four)
        btnFive = findViewById(R.id.btn_five)
        btnSix = findViewById(R.id.btn_six)
        btnSeven = findViewById(R.id.btn_seven)
        btnEight = findViewById(R.id.btn_eight)
        btnNine = findViewById(R.id.btn_nine)

        btnList.addAll(
            listOf(
                btnOne,
                btnTwo,
                btnThree,
                btnFour,
                btnFive,
                btnSix,
                btnSeven,
                btnEight,
                btnNine
            )
        )

        for (button in btnList) {
            button.setOnClickListener {
                onButtonClicked(button)
            }
        }
    }

    private fun onButtonClicked(button: Button) {
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

        determineTheWinner()
    }

    private fun determineTheWinner() {
        if (btnOne.text == btnTwo.text && btnTwo.text == btnThree.text && btnOne.text != "") {
            showDFTheWinner(btnOne.text.toString())
        } else if (btnOne.text == btnFour.text && btnFour.text == btnSeven.text && btnOne.text != "") {
            showDFTheWinner(btnOne.text.toString())
        } else if (btnOne.text == btnFive.text && btnFive.text == btnNine.text && btnOne.text != "") {
            showDFTheWinner(btnOne.text.toString())
        } else if (btnTwo.text == btnFive.text && btnFive.text == btnEight.text && btnTwo.text != "") {
            showDFTheWinner(btnTwo.text.toString())
        } else if (btnThree.text == btnSix.text && btnSix.text == btnNine.text && btnThree.text != "") {
            showDFTheWinner(btnThree.text.toString())
        } else if (btnThree.text == btnFive.text && btnFive.text == btnSeven.text && btnThree.text != "") {
            showDFTheWinner(btnThree.text.toString())
        } else if (btnFour.text == btnFive.text && btnFive.text == btnSix.text && btnFour.text != "") {
            showDFTheWinner(btnFour.text.toString())
        } else if (btnSeven.text == btnEight.text && btnEight.text == btnNine.text && btnSeven.text != "") {
            showDFTheWinner(btnSeven.text.toString())
        }
    }

    private fun showDFTheWinner(text: String) {
        DFTheWinner(this, text).show(supportFragmentManager, null)
    }

    override fun btnNewGameClicked() {
        for (button in btnList) {
            button.setBackgroundResource(R.drawable.btn_bg_default)
            button.isClickable = true
            button.text = ""
        }
        tvSubtitle.text = subtitleCross
    }
}