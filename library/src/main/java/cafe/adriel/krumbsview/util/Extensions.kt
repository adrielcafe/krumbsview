package cafe.adriel.krumbsview.util

import android.view.View
import android.widget.ImageView
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.DrawableCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

fun TextSwitcher.forEach(action: (TextView) -> Unit) {
    (0 until childCount).forEach {
        val childView = getChildAt(it)
        if(childView is TextView)
            action(childView)
    }
}

fun ImageView.tintDrawable(color: Int) = DrawableCompat.setTint(drawable, color)

fun View.drawable(@DrawableRes resId: Int) = VectorDrawableCompat.create(resources, resId, null)
