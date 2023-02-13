package kz.kd.for_practice

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            UnderlinedTextView(this).apply {
                text = "General Kenobi"
            }
        )
    }
}

class UnderlinedTextView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attr, defStyleAttr) {

    init {
        paint.isUnderlineText = true
    }
}