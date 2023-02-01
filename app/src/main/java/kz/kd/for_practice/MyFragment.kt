package kz.kd.for_practice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment

class MyFragment : Fragment(R.layout.fragment1) {

    private var index = 0

    companion object {
        private const val EXTRA_INDEX = "EXTRA_INDEX"
        private const val KEY_TEXT = "KEY_TEXT"

        fun newInstance(index: Int): MyFragment {
            val fragment = MyFragment()
            val bundle = Bundle()
            bundle.putInt(EXTRA_INDEX, index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        index = arguments?.getInt(EXTRA_INDEX, 0) ?: 0
        Log.d("App", "onViewCreated: $index, $savedInstanceState")

        val storedText = savedInstanceState?.getString(KEY_TEXT, "").orEmpty()
        if (storedText.isNotEmpty()) {
            Toast.makeText(view.context, storedText, Toast.LENGTH_SHORT).show()
        }
        val nameEditText: EditText = view.findViewById(R.id.name_edit_text)
        val helloTextView: TextView = view.findViewById(R.id.tv)
        nameEditText.addTextChangedListener (afterTextChanged = {
            helloTextView.text = reverse(it.toString())
        })
    }

    override fun onDestroyView() {
        Log.d("App", "onDestroyView: $index")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("App", "onDestroy: $index")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("App", "onSaveInstanceState: $index, $outState")
        outState.putString(KEY_TEXT, "Stored text: $index")
        super.onSaveInstanceState(outState)
    }

    private fun reverse(text: String): String =
        text.reversed()
}