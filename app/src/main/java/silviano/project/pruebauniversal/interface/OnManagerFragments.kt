package silviano.project.pruebauniversal.`interface`

import androidx.fragment.app.Fragment

interface OnManagerFragments {

    fun addFragment(fragment: Fragment)

    fun findFragmentByTag(fragmentTag: String): Boolean
}