package cafe.adriel.krumbsview.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

open class NonFocusableTextView(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent?) = false
}