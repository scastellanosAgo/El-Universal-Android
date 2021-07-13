package silviano.project.pruebauniversal.presenters.news

import silviano.project.pruebauniversal.pojos.news.ResponseNewItem

class ContractNews {
    interface View {
        fun success(responseNewItem: Array<ResponseNewItem>, id: Int)
        fun errorResponse(mensaje: String, id: Int)
        fun errorRequest(mensaje: String, id: Int)
    }

    interface Presenter {
        fun sendRequest(start: Int)
        fun sendNext()
    }
}