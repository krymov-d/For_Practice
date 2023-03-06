package kz.kd.for_practice

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

class DFSelectRightImage(private val listener: IFSelectRightImage) :
    DialogFragment(R.layout.df_select_right_image) {
    private lateinit var ivRock: ImageView
    private lateinit var ivPaper: ImageView
    private lateinit var ivScissor: ImageView
    private var listOfOptions: MutableList<ImageView> = mutableListOf()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initImageViews(view)
        initClickListeners()
    }

    private fun initImageViews(view: View) {
        ivRock = view.findViewById(R.id.df_rock)
        ivPaper = view.findViewById(R.id.df_paper)
        ivScissor = view.findViewById(R.id.df_scissor)
        listOfOptions.addAll(listOf(ivRock, ivPaper, ivScissor))
    }

    private fun initClickListeners() {
        for (option in listOfOptions) {
            option.setOnClickListener {
                listener.setSelectedRightImage(listOfOptions.indexOf(option))
                dismiss()
            }
        }
    }
}