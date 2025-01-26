package com.example.fooddeliveryapp.data

import androidx.annotation.DrawableRes
import com.example.fooddeliveryapp.R

data class ProductFlavourState(
    val name : String,
    val price : String,
    @DrawableRes val imgRes : Int
)


val ProductFlavoursData = listOf(
    ProductFlavourState(
        name = "Cheese",
        price = "$0.79",
        imgRes = R.drawable.img_cheese
    ),
    ProductFlavourState(
        name = "Bacon",
        price = "$0.56",
        imgRes = R.drawable.img_bacon
    ),
    ProductFlavourState(
        name = "Onion",
        price = "$0.28",
        imgRes = R.drawable.img_onion
    )
)
