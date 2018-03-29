package com.example.rudiyanto.styleshop.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.rudiyanto.styleshop.Adapters.CategoryAdapter
import com.example.rudiyanto.styleshop.Model.Category
import com.example.rudiyanto.styleshop.R
import com.example.rudiyanto.styleshop.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    lateinit var adapter : ArrayAdapter<Category>
    lateinit var adapter : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataService.categories)
        adapter = CategoryAdapter(this,DataService.categories)
        categoryListView.adapter = adapter

        categoryListView.setOnItemClickListener { parent, view, position, id ->
            val category = DataService.categories[position]
            Toast.makeText(this,"You clicked on the ${category.title} cell",Toast.LENGTH_SHORT);

        }
    }
}
