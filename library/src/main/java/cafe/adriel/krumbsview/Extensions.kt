package cafe.adriel.krumbsview

import android.view.View
import android.widget.ImageView
import android.widget.TextSwitcher
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

fun TextSwitcher.forEach(action: (View) -> Unit) {
    (0 until childCount).forEach {
        action(getChildAt(it))
    }
}

fun ImageView.tintDrawable(color: Int) = DrawableCompat.setTint(drawable, color)

fun View.drawable(@DrawableRes resId: Int) = VectorDrawableCompat.create(resources, resId, null)

fun View.color(@ColorRes resId: Int) = ResourcesCompat.getColor(resources, resId, null)