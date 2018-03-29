package com.example.rudiyanto.styleshop.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.rudiyanto.styleshop.Model.Product
import com.example.rudiyanto.styleshop.R
import kotlinx.android.synthetic.main.product_list_item.view.*

/**
 * Created by Rudi Ranshiin on 3/29/2018.
 */
class ProductsAdapter( val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder?, position: Int) {
    holder?.bindProduct(products[position],context)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    inner class ProductHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView?.findViewById(R.id.productImage) as ImageView
        val productName = itemView?.findViewById(R.id.productName) as TextView
        val productPrice = itemView?.findViewById(R.id.productPrice) as TextView

        fun bindProduct(product: Product, context: Context){
            val resourceId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = product.title
            productPrice?.text = product.price
        }
    }
}