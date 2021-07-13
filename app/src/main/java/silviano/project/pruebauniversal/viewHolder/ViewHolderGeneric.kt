package silviano.project.pruebauniversal.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView


abstract class ViewHolderGeneric<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var position_ = -1
    abstract fun fillView(item: T, position: Int)

}