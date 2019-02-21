package cafe.adriel.krumbsview.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cafe.adriel.krumbsview.model.Krumb
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

        vDefaultBreadcrumbs.setOnPreviousItemClickListener {
            vCustomBreadcrumbs.removeLastItem()
            updateState()
        }
        vCustomBreadcrumbs.setOnPreviousItemClickListener {
            vDefaultBreadcrumbs.removeLastItem()
            updateState()
        }

        vAddItem.setOnClickListener {
            if(vDefaultBreadcrumbs.size <= dummyItems.size) {
                val nextItem = dummyItems[vDefaultBreadcrumbs.size - 1]
                vDefaultBreadcrumbs.addItem(Krumb(nextItem))
                vCustomBreadcrumbs.addItem(Krumb(nextItem))
            }
            updateState()
        }
        vRemoveLastItem.setOnClickListener {
            vDefaultBreadcrumbs.removeLastItem()
            vCustomBreadcrumbs.removeLastItem()
            updateState()
        }
        vGoToFirstItem.setOnClickListener {
            vDefaultBreadcrumbs.goToFirstItem()
            vCustomBreadcrumbs.goToFirstItem()
            updateState()
        }
    }

    override fun onResume() {
        super.onResume()
        updateState()
    }

    private fun updateState(){
        vAddItem.isEnabled = true
        vRemoveLastItem.isEnabled = true
        vGoToFirstItem.isEnabled = true

        if(vDefaultBreadcrumbs.size > dummyItems.size){
            vAddItem.isEnabled = false
        } else if(vDefaultBreadcrumbs.size == 1){
            vRemoveLastItem.isEnabled = false
            vGoToFirstItem.isEnabled = false
        }
    }

}