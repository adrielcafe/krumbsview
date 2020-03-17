package cafe.adriel.krumbsview.listener

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs

abstract class OnSwipeRightListener(private val context: Context) : View.OnTouchListener {

    companion object {
        private const val SWIPE_DISTANCE_THRESHOLD = 100
        private const val SWIPE_VELOCITY_THRESHOLD = 100
    }

    private val gestureDetector by lazy { GestureDetector(context, GestureListener()) }

    override fun onTouch(v: View?, event: MotionEvent?) = gestureDetector.onTouchEvent(event)

    abstract fun onSwipeRight()

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener(){

        override fun onDown(e: MotionEvent?) = true

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            val distanceX = (e2?.x ?: 0F) - (e1?.x ?: 0F)
            val distanceY = (e2?.y ?: 0F) - (e1?.y ?: 0F)
            
            if (abs(distanceX) > abs(distanceY)
                && abs(distanceX) > SWIPE_DISTANCE_THRESHOLD
                && abs(velocityX) > SWIPE_VELOCITY_THRESHOLD
                && distanceX > 0) {
                onSwipeRight()
                return true
            }
            
            return false
        }
    }
}