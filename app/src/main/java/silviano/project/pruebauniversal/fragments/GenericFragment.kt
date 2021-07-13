package silviano.project.pruebauniversal.fragments

import android.app.Activity
import androidx.fragment.app.Fragment
import silviano.project.pruebauniversal.`interface`.OnActionBar
import silviano.project.pruebauniversal.`interface`.OnManagerFragments
import silviano.project.pruebauniversal.`interface`.OnProgress

open class GenericFragment: Fragment() {

    private var onActionBar: OnActionBar? = null
    private var onProgress: OnProgress? = null
    private var onManagerFragments: OnManagerFragments? = null

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        if (activity is OnManagerFragments) {
            onManagerFragments = activity
        }
        if (activity is OnProgress) {
            onProgress = activity
        }
        if (activity is OnActionBar) {
            onActionBar = activity
        }
    }
    fun getOnProgress() : OnProgress? = onProgress
    fun getOnActionBar() : OnActionBar? = onActionBar
    fun getOnManagerFragments() : OnManagerFragments? = onManagerFragments
}