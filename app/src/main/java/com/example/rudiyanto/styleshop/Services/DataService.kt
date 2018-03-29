package com.example.rudiyanto.styleshop.Services

import com.example.rudiyanto.styleshop.Model.Category
import com.example.rudiyanto.styleshop.Model.Product

/**
 * Created by Rudi Ranshiin on 3/28/2018.
 */
object DataService {
    val categories = listOf(
            Category(  "SHIRTS", "shirtimage"),
            Category("HOODIES", "hoodieimage"),
            Category("HATS","hatimage"),
            Category( "DIGITAL","digitalgoodsimage")
    )
    val hats = listOf(
            Product("Devslopes Graphic Beanie","$18", "hat1"),
            Product("Devslopes Hat Black",  "$20", "hat2"),
            Product("Devslopes Hat White",  "$18", "hat3"),
            Product("Devslopes Hat Snapback",  "$22", "hat4")
    )
    val hoodies = listOf(
            Product("Devslopes Hoodie Gray","$28","hoodie1"),
            Product("Devslopes Gray Hoodie", "$28", "hoodie3"),
            Product("Devslopes Hoodie Red", "$32", "hoodie1"),
            Product("Devslopes Black Hoodie", "$32", "hoodie4")
    )
    val shirts = listOf(
            Product("Devslopes Shirt Black", "$18","shirt1"),
            Product("Devslopes Badge Light Gray", "$20","shirt2"),
            Product("Devslopes Logo Shirt Red", "$22","shirt3"),
            Product("Devslopes Hustle", "$22","shirt4"),
            Product("Kickflip Studios","$18","shirt5")
    )
    val digitalGood = listOf<Product>()
    fun getProducts(category: String) : List<Product>{
        return when(category){
            "SHIRTS" -> return shirts
            "HATS" -> return hats
            "HOODIES" -> return hoodies
            else -> return digitalGood
        }

//        if(category == "HATS"){
//            return hats
//        } else if (category == "SHIRTS"){
//            return shirts
//        }
    }
}