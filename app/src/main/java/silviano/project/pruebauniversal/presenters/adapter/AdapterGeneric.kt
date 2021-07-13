package silviano.project.pruebauniversal.presenters.adapter

import android.view.View
import silviano.project.pruebauniversal.viewHolder.ViewHolderGeneric


abstract class AdapterGeneric<T>{
    var list: ArrayList<T> = ArrayList()
    abstract fun getLayout(): Int
    abstract fun getViewHolder(view: View): ViewHolderGeneric<T>
}