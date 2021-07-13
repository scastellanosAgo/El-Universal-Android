package silviano.project.pruebauniversal.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_news_description.*
import kotlinx.android.synthetic.main.header_new.view.*
import silviano.project.pruebauniversal.App
import silviano.project.pruebauniversal.R
import silviano.project.pruebauniversal.pojos.news.ResponseNewItem


class NewsDescription private constructor(private val responseNewItem: ResponseNewItem): GenericFragment(),
    View.OnClickListener {
    companion object {
        fun instance(responseNewItem: ResponseNewItem) : NewsDescription = NewsDescription(responseNewItem)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_news_description, container, false)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        fillView()
    }

    private fun fillView() {
        i_header.tv_header_title.text = App.getInstance().getString(R.string.title_universal)
        i_header.tv_header_subtitle.text = responseNewItem.pubdate + " " + responseNewItem.pubtime
        tv_first_description.text = responseNewItem.title
        tv_second_description.text = responseNewItem.body
        tv_link.text = responseNewItem.link
        tv_link.setOnClickListener(this)
        Picasso.with(App.getInstance())
            .load(responseNewItem.image)
            .placeholder(R.drawable.ic_el_universal)
            .error(R.drawable.ic_el_universal)
            .into(iv_item)
    }

    override fun onResume() {
        super.onResume()
        getOnActionBar()?.changeTitle("Descripción")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_description, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val message = responseNewItem.link
        val share = Intent(Intent.ACTION_SEND)
        share.type = "text/plain"
        share.putExtra(Intent.EXTRA_TEXT, message)

        startActivity(Intent.createChooser(share, "Compartido desde " + getString(R.string.app_name)))
        return super.onOptionsItemSelected(item)
    }
    override fun onClick(p0: View?) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(responseNewItem.link))
        startActivity(browserIntent)
    }
}