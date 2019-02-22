package cafe.adriel.krumbsview.util

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.DrawableCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

fun ViewGroup.forEach(action: (View) -> Unit) {
    (0 until childCount).forEach {
        action(getChildAt(it))
    }
}

fun ImageView.tintDrawable(color: Int) = DrawableCompat.setTint(drawable, color)

fun View.drawable(@DrawableRes resId: Int) = VectorDrawableCompat.create(resources, resId, null)
