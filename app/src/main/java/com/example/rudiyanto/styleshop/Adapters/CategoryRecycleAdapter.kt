package com.example.rudiyanto.styleshop.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rudiyanto.styleshop.Model.Category
import com.example.rudiyanto.styleshop.R
import kotlinx.android.synthetic.main.category_list_item.view.*
import org.w3c.dom.Text

/**
 * Created by Rudi Ranshiin on 3/29/2018.
 */
class CategoryRecycleAdapter(val context: Context, val categories: List<Category>, val itemClick: (Category)-> Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {
    override fun onBindViewHolder(holder: Holder?, position: Int) {
      holder?.bindCategory(categories[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.category_list_item, parent, false)
        return Holder(view,itemClick)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    inner class Holder(itemView: View?, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView?.findViewById(R.id.categoryImage) as ImageView?
        val categoryName = itemView?.findViewById(R.id.categoryName) as TextView?
        fun bindCategory(category: Category, context: Context){
            val resourceId = context.resources.getIdentifier(category.image, "drawable",context.packageName)
            categoryImage?.setImageResource(resourceId)
            categoryName?.text = category.title
            itemView.setOnClickListener { itemClick(category) }
        }

    }
}