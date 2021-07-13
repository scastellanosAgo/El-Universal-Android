package silviano.project.pruebauniversal.tools

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.GsonBuilder
import org.json.JSONObject
import silviano.project.pruebauniversal.App

class Utils {
    companion object {
        const val ERROR = -1
        const val OK = 0
        const val EMPTY = ""

        fun getPreferences(): SharedPreferences? {
            return try {
                App.getInstance().getSharedPreferences("UniversaAndroid", Context.MODE_PRIVATE)
            } catch (e: java.lang.Exception) {
                null
            }
        }
        fun log(TAG: String?, message: String?) {
            if (App.isDebug) Log.e(
                TAG,
                message!!
            )
        }

    }
}