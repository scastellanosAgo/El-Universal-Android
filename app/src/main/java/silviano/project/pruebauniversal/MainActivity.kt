package silviano.project.pruebauniversal

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.progess_fill_screen.*
import silviano.project.pruebauniversal.`interface`.OnActionBar
import silviano.project.pruebauniversal.`interface`.OnManagerFragments
import silviano.project.pruebauniversal.`interface`.OnProgress
import silviano.project.pruebauniversal.fragments.NewsFragment
import silviano.project.pruebauniversal.tools.Utils

class MainActivity : AppCompatActivity(), OnManagerFragments, OnProgress, OnActionBar {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(NewsFragment.instance())
    }
    override fun addFragment(fragment: Fragment) {
        try {
            val name = fragment.javaClass.simpleName
            supportFragmentManager.beginTransaction()
                .add(R.id.content_fragment, fragment, name)
                .addToBackStack(name)
                .commit()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.fragments.isNotEmpty())
            supportFragmentManager.fragments[supportFragmentManager.fragments.size - 1].onResume()
        else
            finish()
    }
    override fun findFragmentByTag(fragmentTag: String): Boolean {
        return supportFragmentManager.findFragmentByTag(fragmentTag) != null
    }

    override fun start() {
        if (!rl_progress.isStart) {
            i_progress_view.visibility = View.VISIBLE
            rl_progress.start()
        }
    }

    override fun stop() {

        if (rl_progress.isStart) {
            i_progress_view.visibility = View.GONE
            rl_progress.stop()
        }
    }

    override fun isVisible(): Boolean {
        return i_progress_view.visibility == View.VISIBLE
    }

    override fun changeTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun changeIcon(drawableId: Int?) {
        if (drawableId != null) {
            supportActionBar!!.setHomeAsUpIndicator(drawableId)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }else
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

}