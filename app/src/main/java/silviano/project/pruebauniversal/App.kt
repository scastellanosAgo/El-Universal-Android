package silviano.project.pruebauniversal

import android.app.Application

public class App: Application() {

    companion object {
        const val isDebug = true
        private var instance: App? = null
        fun getInstance(): App = instance!!
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}