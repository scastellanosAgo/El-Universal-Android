package silviano.project.pruebauniversal.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import silviano.project.pruebauniversal.presenters.adapter.AdapterGeneric
import silviano.project.pruebauniversal.viewHolder.ViewHolderGeneric

class AdapterGenericRecycler<T>(private val adapterGeneric: AdapterGeneric<T>) : RecyclerView.Adapter<ViewHolderGeneric<T>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<T>   = adapterGeneric.getViewHolder(View.inflate(parent.context, adapterGeneric.getLayout(), null))

    override fun onBindViewHolder(holder: ViewHolderGeneric<T>, position: Int) = holder.fillView(adapterGeneric.list[position], position)

    override fun getItemCount(): Int = adapterGeneric.list.size
}
