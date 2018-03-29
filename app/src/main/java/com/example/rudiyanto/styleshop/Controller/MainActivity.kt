package com.example.rudiyanto.styleshop.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.rudiyanto.styleshop.Adapters.CategoryAdapter
import com.example.rudiyanto.styleshop.Adapters.CategoryRecycleAdapter
import com.example.rudiyanto.styleshop.Model.Category
import com.example.rudiyanto.styleshop.R
import com.example.rudiyanto.styleshop.Services.DataService
import com.example.rudiyanto.styleshop.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    lateinit var adapter : ArrayAdapter<Category>
    lateinit var adapter : CategoryRecycleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryRecycleAdapter(this,DataService.categories){
            category ->
//            println(category.title)
            val productIntent = Intent(this,ProductsActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)

    }
}
