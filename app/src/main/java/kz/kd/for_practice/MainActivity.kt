package kz.kd.for_practice

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.AttributeSet
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

class UnderlinedTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        paint.isUnderlineText = true
    }
}

private const val COLOR_NONE = -1

class CircledButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {
    private var radius = 0f
    private var hasBorder = false
    private var borderColor = COLOR_NONE
    private var borderSize = 0f
    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CircledButton,
            0, 0
        ).apply {
            try {
                radius = getDimensionPixelSize(R.styleable.CircledButton_radius, 0).toFloat()
                hasBorder = getBoolean(R.styleable.CircledButton_hasBorder, false)
                borderColor = getColor(R.styleable.CircledButton_borderColor, COLOR_NONE)
                borderSize = getDimensionPixelSize(R.styleable.CircledButton_borderSize, 0).toFloat()
            } finally {
                recycle()
            }
        }

        val shapeAppearanceModel: ShapeAppearanceModel = ShapeAppearanceModel().toBuilder().apply {
            if (radius > 0) {
                setAllCorners(
                    CornerFamily.ROUNDED,
                    radius
                )
            }
        }.build()

        val shapeDrawable = MaterialShapeDrawable(shapeAppearanceModel).apply {

            if (hasBorder && borderColor != COLOR_NONE) {
                strokeWidth = borderSize
                strokeColor = ColorStateList.valueOf(borderColor)
            }

            fillColor = ColorStateList.valueOf(androidx.appcompat.R.attr.colorPrimary)
        }

        background = shapeDrawable
    }
}

class TitleWithSubtitleItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    init {
        val view  = inflate(context, R.layout.item_title_with_subtitle, this)
        val textTitle = view.findViewById<TextView>(R.id.title)
        val textSubtitle = view.findViewById<TextView>(R.id.subTitle)

        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TitleWithSubtitleItem,
            0, 0
        ).apply {
            try {
                textTitle.text = this.getString(R.styleable.TitleWithSubtitleItem_textTitle)
                textSubtitle.text = this.getString(R.styleable.TitleWithSubtitleItem_textSubTitle)
            } finally {
                recycle()
            }
        }
    }
}