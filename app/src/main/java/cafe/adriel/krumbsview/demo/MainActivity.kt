package cafe.adriel.krumbsview.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cafe.adriel.krumbsview.model.KrumbsAnimationType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dummyItems = listOf(
        "Cupcake", "Donut", "Eclair", "Froyo", "Gingerbread",
        "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "KitKat",
        "Lollipop", "Marshmallow", "Nougat", "Oreo", "Pie"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vBreadcrumbs.setOnPreviousItemClickListener { title, payload ->
            updateState()
        }

        vAddItem.setOnClickListener {
            if(vBreadcrumbs.size <= dummyItems.size) {
                val nextItem = dummyItems[vBreadcrumbs.size - 1]
                vBreadcrumbs.addItem(nextItem)
            }
            updateState()
        }
        vRemoveLastItem.setOnClickListener {
            vBreadcrumbs.removeLastItem()
            updateState()
        }
        vGoToFirstItem.setOnClickListener {
            vBreadcrumbs.goToFirstItem()
            updateState()
        }

        vAnimationSlide.setOnClickListener { vBreadcrumbs.setAnimationType(KrumbsAnimationType.SLIDE_LEFT_RIGHT) }
        vAnimationFade.setOnClickListener { vBreadcrumbs.setAnimationType(KrumbsAnimationType.FADE_IN_OUT) }
        vAnimationGrow.setOnClickListener { vBreadcrumbs.setAnimationType(KrumbsAnimationType.GROW_SHRINK) }
    }

    override fun onResume() {
        super.onResume()
        updateState()
    }

    private fun updateState(){
        vAddItem.isEnabled = true
        vRemoveLastItem.isEnabled = true
        vGoToFirstItem.isEnabled = true

        if(vBreadcrumbs.size > dummyItems.size){
            vAddItem.isEnabled = false
        } else if(vBreadcrumbs.size == 1){
            vRemoveLastItem.isEnabled = false
            vGoToFirstItem.isEnabled = false
        }
    }
}