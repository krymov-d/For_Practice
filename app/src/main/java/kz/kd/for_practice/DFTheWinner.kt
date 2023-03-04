package kz.kd.for_practice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class DFTheWinner(private val listener: IFBtnNewGame, private val winnerText: String) :
    DialogFragment(R.layout.dialog_win) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvWinner: TextView = view.findViewById(R.id.tv_win)
        if (winnerText == "X") {
            tvWinner.text = resources.getString(R.string.win_cross)
        } else if (winnerText == "O") {
            tvWinner.text = resources.getString(R.string.win_zero)
        }
        val btnNewGame: Button = view.findViewById(R.id.btn_new_game)
        btnNewGame.setOnClickListener {
            listener.btnNewGameClicked()
            dismiss()
        }
    }
}