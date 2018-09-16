package me.chen_wei.recyclerview.samples

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import me.chen_wei.recyclerview.samples.data.Item

/**
 * Created by Hander on 18/9/16.
 *
 * Email : hander_wei@163.com
 */
class ItemAdapter(val list: MutableList<Item>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        val item = list[position]
        holder?.title?.text = item.title
        holder?.msg?.text = item.message
        Picasso.get().load(item.img).into(holder?.img)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_title, parent, false))
    }

    fun swap(new: List<Item>) {
        val result = DiffUtil.calculateDiff(ItemDiffCallback(list, new))
        result.dispatchUpdatesTo(this)
        this.list.clear()
        this.list.addAll(new)
    }

}

class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val title = view.findViewById<TextView>(R.id.title)
    val msg = view.findViewById<TextView>(R.id.message)
    val img = view.findViewById<ImageView>(R.id.icon)
}

class ItemDiffCallback(val old:List<Item>, val new: List<Item>): DiffUtil.Callback() {


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition].img == new[newItemPosition].img
    }

    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

}
