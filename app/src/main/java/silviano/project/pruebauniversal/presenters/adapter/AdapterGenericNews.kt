package silviano.project.pruebauniversal.presenters.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import silviano.project.pruebauniversal.App
import silviano.project.pruebauniversal.R
import silviano.project.pruebauniversal.`interface`.OnClickT
import silviano.project.pruebauniversal.pojos.news.ResponseNewItem
import silviano.project.pruebauniversal.viewHolder.ViewHolderGeneric

class AdapterGenericNews(private val layoutId: Int, private val onClickT: OnClickT?) : AdapterGeneric<ResponseNewItem>(){
    override fun getLayout(): Int = layoutId
    override fun getViewHolder(view: View): ViewHolderGeneric<ResponseNewItem> {
        val vh = ViewHolderNew(view)
        if (onClickT != null)
            vh.itemView.setOnClickListener { onClickT.onClick(vh.position_, "AdapterGenericNews") }
        return vh
    }

    class ViewHolderNew(itemView: View) : ViewHolderGeneric<ResponseNewItem>(itemView) {
        private val tvHeaderTitle: TextView = itemView.findViewById(R.id.tv_header_title)
        private val tvHeaderSubtitle: TextView = itemView.findViewById(R.id.tv_header_subtitle)
        private val tvFirstDescription: TextView = itemView.findViewById(R.id.tv_first_description)
        private val tvSecondDescription: TextView = itemView.findViewById(R.id.tv_second_description)
        private val ivItem: ImageView = itemView.findViewById(R.id.iv_item)
        override fun fillView(item: ResponseNewItem, position: Int) {
            position_ = position
            tvHeaderTitle.text = App.getInstance().getString(R.string.title_universal)
            tvHeaderSubtitle.text = item.pubdate + " " + item.pubtime
            tvFirstDescription.text = item.title
            tvSecondDescription.text = item.summary
            Picasso.with(App.getInstance())
                    .load(item.imageSmallSize)
                    .placeholder(R.drawable.ic_el_universal)
                    .error(R.drawable.ic_el_universal)
                    .into(ivItem)

        }
    }
}