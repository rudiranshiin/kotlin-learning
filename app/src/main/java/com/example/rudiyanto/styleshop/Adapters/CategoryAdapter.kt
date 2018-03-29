package com.example.rudiyanto.styleshop.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.rudiyanto.styleshop.Model.Category
import com.example.rudiyanto.styleshop.R
import kotlinx.android.synthetic.main.category_list_item.view.*

/**
 * Created by Rudi Ranshiin on 3/28/2018.
 */
class CategoryAdapter(context: Context, categories: List<Category>) : BaseAdapter(){

    val context = context
    val categories = categories
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView: View
        val holder : ViewHolder
        if(convertView == null){
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryImage) as ImageView?
            holder.categoryName = categoryView.findViewById(R.id.categoryName) as TextView?
            categoryView.tag = holder
        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

//        val categoryImage : ImageView = categoryView.findViewById(R.id.categoryImage) as ImageView
//        val categoryName : TextView = categoryView.findViewById(R.id.categoryName) as TextView

        val category = categories[position]

        val resourceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)
        holder.categoryImage?.setImageResource(resourceId)

        holder.categoryName?.text = category.title
        return categoryView
     }
    override fun getItem(position: Int): Any {
      return categories[position]
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getCount(): Int {
     return categories.count()
    }

    private class ViewHolder(){
        var categoryImage : ImageView? = null
        var categoryName : TextView? = null
    }



}