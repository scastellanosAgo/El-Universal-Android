package silviano.project.pruebauniversal.fragments

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_generic_recycler.*
import kotlinx.android.synthetic.main.recycler_view_vertical.*
import silviano.project.pruebauniversal.*
import silviano.project.pruebauniversal.`interface`.OnClickT
import silviano.project.pruebauniversal.adapters.AdapterGenericRecycler
import silviano.project.pruebauniversal.pojos.news.ResponseNewItem
import silviano.project.pruebauniversal.presenters.adapter.AdapterGenericNews
import silviano.project.pruebauniversal.presenters.news.ContractNews
import silviano.project.pruebauniversal.presenters.news.PresenterNews
import silviano.project.pruebauniversal.presenters.news.PresenterNews.Companion.ID_1


class NewsFragment private constructor(): RecyclerGenericFragment(), ContractNews.View, OnClickT {
    var presenterNews: PresenterNews? = null
    var adapterGenericNews: AdapterGenericNews? = null
    companion object {
        fun instance() : NewsFragment = NewsFragment()
    }

    override fun onRefresh() {
        if (!isOnRefreshing && !isVisibleProgressBottom) {
            isOnRefreshing = true
            presenterNews?.sendRequest(0)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenterNews = PresenterNews.getInstance(this)
        srl_main.setOnRefreshListener(this)
        rv_main.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && !isVisibleProgressBottom && !isOnRefreshing) {
                    isVisibleProgressBottom = true
                    presenterNews?.sendNext()
                }
            }
        })
        getOnProgress()?.start()
        presenterNews?.sendRequest(0)
    }

    override fun onResume() {
        super.onResume()
        getOnActionBar()?.changeTitle("Noticias")
        getOnActionBar()?.changeIcon(null)
    }
    override fun success(responseNewItem: Array<ResponseNewItem>, id: Int) {
        val arrayList = responseNewItem.toCollection(ArrayList())
        if (id == ID_1) {
            fillAdapter(arrayList)
            getOnProgress()?.stop()
            isOnRefreshing = false
        }else{
            nextFillAdapter(arrayList)
            isVisibleProgressBottom = false
        }
    }
    private fun nextFillAdapter(arrayList: ArrayList<ResponseNewItem>){
        if (adapterGenericNews == null) {
            fillAdapter(arrayList)
        }else{
            adapterGenericNews?.list!!.addAll(arrayList)
            rv_main.adapter!!.notifyDataSetChanged()
        }
    }
    private fun fillAdapter(arrayList: ArrayList<ResponseNewItem>){
        if (adapterGenericNews == null)
            adapterGenericNews = AdapterGenericNews(R.layout.adapter_item_new, this)
        adapterGenericNews?.list = arrayList
        if (rv_main.adapter == null)
            adapterGenericRecycler = AdapterGenericRecycler(adapterGenericNews!!)
        else
            rv_main.adapter!!.notifyDataSetChanged()
    }
    override fun errorResponse(mensaje: String, id: Int) {
        getOnProgress()?.stop()
        isOnRefreshing = false
    }

    override fun errorRequest(mensaje: String, id: Int) {
        getOnProgress()?.stop()
        isOnRefreshing = false
    }

    override fun onClick(position: Int, tag: String) {
        getOnManagerFragments()?.addFragment(NewsDescription.instance(adapterGenericNews!!.list[position]))
    }
}