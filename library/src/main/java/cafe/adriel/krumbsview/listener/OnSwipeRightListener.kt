package cafe.adriel.krumbsview.listener

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

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

        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            val distanceX = e2.x - e1.x
            val distanceY = e2.y - e1.y
            if (Math.abs(distanceX) > Math.abs(distanceY)
                    && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD
                    && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD
                    && distanceX > 0) {
                onSwipeRight()
                return true
            }
            return false
        }

    }
}