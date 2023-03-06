package kz.kd.for_practice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity(), IFSelectRightImage {
    private lateinit var tvMain: TextView
    private lateinit var ivLeft: ImageView
    private lateinit var ivRight: ImageView
    private lateinit var btnChoose: Button
    private lateinit var btnMain: Button
    private var leftOption: Int = 0
    private var rightOption: Int = 0
    private var isGameOnRun = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setOnBtnClickListeners()
    }

    private fun initViews() {
        tvMain = findViewById(R.id.tv_main)
        tvMain.text = resources.getString(R.string.choose_weapon)
        ivLeft = findViewById(R.id.iv_left)
        ivRight = findViewById(R.id.iv_right)
        btnChoose = findViewById(R.id.btn_choose)
        btnMain = findViewById(R.id.btn_main)
    }

    private fun setOnBtnClickListeners() {
        btnChoose.setOnClickListener {
            DFSelectRightImage(this).show(supportFragmentManager, null)
        }
        btnMain.setOnClickListener {
            isGameOnRun = if (isGameOnRun) {
                setRandomLeftImage((0..2).random())
                gameEnded()
                !isGameOnRun
            } else {
                newGame()
                !isGameOnRun
            }
        }
    }

    private fun setRandomLeftImage(option: Int) {
        leftOption = option
        when (option) {
            0 -> {
                ivLeft.setImageResource(R.drawable.ic_rock)
            }
            1 -> {
                ivLeft.setImageResource(R.drawable.ic_paper)
            }
            2 -> {
                ivLeft.setImageResource(R.drawable.ic_scissor)
            }
        }
    }

    override fun setSelectedRightImage(option: Int) {
        gameStarted()
        rightOption = option
        when (option) {
            0 -> {
                ivRight.setImageResource(R.drawable.ic_rock)
                tvMain.text = resources.getString(R.string.option_rock)
            }
            1 -> {
                ivRight.setImageResource(R.drawable.ic_paper)
                tvMain.text = resources.getString(R.string.option_paper)
            }
            2 -> {
                ivRight.setImageResource(R.drawable.ic_scissor)
                tvMain.text = resources.getString(R.string.option_scissor)
            }
        }
    }

    private fun gameStarted() {
        ivRight.isVisible = true
        btnChoose.isVisible = false
        btnMain.isVisible = true
        btnMain.text = resources.getString(R.string.duel)
    }

    private fun gameEnded() {
        if (leftOption == rightOption) {
            gameResult(0)
        } else if (leftOption == 0 && rightOption == 2) {
            gameResult(1)
        } else if (leftOption == 2 && rightOption == 0) {
            gameResult(2)
        } else if (leftOption == 1 && rightOption == 2) {
            gameResult(2)
        } else if (leftOption == 2 && rightOption == 1) {
            gameResult(1)
        } else if (leftOption == 0 && rightOption == 1) {
            gameResult(2)
        } else if (leftOption == 1 && rightOption == 0) {
            gameResult(1)
        } else {
            tvMain.text = resources.getString(R.string.game_over)
        }
    }

    private fun gameResult(option: Int) {
        when (option) {
            0 -> {
                tvMain.text = resources.getString(R.string.draw)
            }
            1 -> {
                tvMain.text = resources.getString(R.string.loser)
                tvMain.setTextColor(ContextCompat.getColor(this, R.color.tv_lose_color))
            }
            2 -> {
                tvMain.text = resources.getString(R.string.winner)
                tvMain.setTextColor(ContextCompat.getColor(this, R.color.tv_win_color))
            }
        }
        btnMain.setBackgroundResource(R.drawable.btn_choose_bg)
        btnMain.text = resources.getString(R.string.again)
        btnMain.setTextColor(ContextCompat.getColor(this, R.color.tv_text_color))
    }

    private fun newGame() {
        tvMain.text = resources.getString(R.string.choose_weapon)
        ivLeft.setImageResource(R.drawable.ic_questions)
        ivRight.isVisible = false
        btnChoose.isVisible = true
        btnMain.isVisible = false
    }
}