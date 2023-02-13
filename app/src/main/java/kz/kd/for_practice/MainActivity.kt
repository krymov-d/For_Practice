package kz.kd.for_practice

import android.content.Context
import android.content.res.ColorStateList
import android.os.Bundle
import android.util.AttributeSet
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class MainActivity : AppCompatActivity() {
    private lateinit var rootView: LinearLayoutCompat
    private lateinit var dynamicTitleWithSubtitleView: TitleWithSubtitleItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleWithSubtitleItem: TitleWithSubtitleItem = findViewById(R.id.title_with_subtitle)
        titleWithSubtitleItem.setOnButtonClickListener {
            val subtitle = titleWithSubtitleItem.getSubtitleTextView().text
            Toast.makeText(this, subtitle, Toast.LENGTH_SHORT).show()
            titleWithSubtitleItem.getSubtitleTextView().text = "This is modified subtitle value"
            rootView.removeView(dynamicTitleWithSubtitleView)
        }

        dynamicTitleWithSubtitleView = TitleWithSubtitleItem(this).apply {
            setTitle("It is custom TitleWithSubtitleItem")
            setSubtitle("It is created from code")
            setOnButtonClickListener { finish() }
        }

        rootView = findViewById(R.id.rootView)
        rootView.addView(dynamicTitleWithSubtitleView)
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

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val widthFromParentSpec: Int = MeasureSpec.getSize(widthMeasureSpec)
        val widthMode: Int = MeasureSpec.getMode(widthMeasureSpec)
        val thisViewWidth = when (widthMode) {
            MeasureSpec.AT_MOST -> 500
            MeasureSpec.EXACTLY -> widthFromParentSpec
            MeasureSpec.UNSPECIFIED -> 300
            else -> -1
        }

        val heightFromParentSpec: Int = MeasureSpec.getSize(heightMeasureSpec)
        val heightMode: Int = MeasureSpec.getMode(heightMeasureSpec)
        val thisViewHeight = 50
        setMeasuredDimension(thisViewWidth, thisViewHeight)
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
                borderSize =
                    getDimensionPixelSize(R.styleable.CircledButton_borderSize, 0).toFloat()
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
    private var button: CircledButton
    private var textTitle: TextView
    private var textSubtitle: TextView

    init {
        val view = inflate(context, R.layout.item_title_with_subtitle, this)
        textTitle = view.findViewById(R.id.title)
        textSubtitle = view.findViewById(R.id.subTitle)
        button = view.findViewById(R.id.c_btn)

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

    fun setOnButtonClickListener(onButtonClick: () -> Unit) {
        button.setOnClickListener { onButtonClick() }
    }

    fun getSubtitleTextView(): TextView = textSubtitle

    fun setTitle(title: String) {
        textTitle.text = title
    }

    fun setSubtitle(subtitle: String) {
        textSubtitle.text = subtitle
    }
}