package cafe.adriel.krumbsview.view

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatTextView

class NonFocusableTextView(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {

    override fun onTouchEvent(ev: MotionEvent?) = false

}