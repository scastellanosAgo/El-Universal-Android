package silviano.project.pruebauniversal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.fragment_generic_recycler.*
import kotlinx.android.synthetic.main.recycler_view_vertical.*
import silviano.project.pruebauniversal.App
import silviano.project.pruebauniversal.R
import silviano.project.pruebauniversal.adapters.AdapterGenericRecycler

abstract class RecyclerGenericFragment: GenericFragment(), SwipeRefreshLayout.OnRefreshListener {
    var isOnRefreshing = false

    set(value) {
        field = value
        srl_main.isRefreshing = isOnRefreshing
    }
    var isVisibleProgressBottom = false
    set(value) {
        field = value
        if (isVisibleProgressBottom){
            fl_bottom.visibility = View.VISIBLE
            rl_progress_bottom.start()
        } else {
            fl_bottom.visibility = View.GONE
            rl_progress_bottom.stop()
        }
    }
    var adapterGenericRecycler: AdapterGenericRecycler<*>? = null
    set(value) {
        field = value
        if (value != null){
            rv_main.adapter = adapterGenericRecycler
            rv_main.adapter!!.notifyDataSetChanged()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_generic_recycler, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_main.layoutManager = LinearLayoutManager(
            App.getInstance(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }
    abstract override fun onRefresh()
}