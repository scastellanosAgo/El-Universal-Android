package silviano.project.pruebauniversal.presenters.news

import com.android.volley.toolbox.*
import com.google.gson.Gson
import silviano.project.pruebauniversal.App
import silviano.project.pruebauniversal.R
import silviano.project.pruebauniversal.pojos.news.ResponseNewItem
import java.lang.Exception


open class PresenterNews private constructor(private val newsView: ContractNews.View): ContractNews.Presenter{

    var start: Int = 0
    companion object {
        const val ID_1 = 10921
        const val ID_2 = ID_1 + 1
        const val INCREASE = 10
        fun getInstance(newsView: ContractNews.View) = PresenterNews(newsView)
    }

    private fun sendRequest(url: String, id: Int) {
        val queue = Volley.newRequestQueue(App.getInstance())
        val request = JsonArrayRequest(url, { response ->
            try {
                val responseNewItems: Array<ResponseNewItem> = Gson().fromJson(response.toString(), Array<ResponseNewItem>::class.java)
                newsView?.success(responseNewItems, id)
            }
            catch (e: Exception) {
                newsView?.errorResponse(App.getInstance().getString(R.string.error_on_response), id)
                e.printStackTrace()
            }
        })
        {
            newsView?.errorRequest(App.getInstance().getString(R.string.error_on_request), id)
        }
        queue.add(request)
        queue.start()
    }
    override fun sendRequest(start: Int) {
        this.start = start
        sendRequest(buildUrl(start), ID_1)
    }

    override fun sendNext() {
        this.start = start + INCREASE
        sendRequest(buildUrl(start), ID_2)
    }
    fun buildUrl(start: Int) : String = "https://api.eluniversal.com.mx/v3/notes/eluniversal/mxm/json/espectaculos/$start/${start + INCREASE}"
}