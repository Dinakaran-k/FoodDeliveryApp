package com.example.fooddeliveryapp.data

data class ProductNutritionState (
    val calories : Calories,
    val nutrition : List<NutritionState>
)

val ProductNutritionData = ProductNutritionState(
    calories = Calories(
        value = "200",
        unit = "Kcal"
    ),
    nutrition = listOf(
        NutritionState(
            amount = "10",
            unit = "g",
            title = "Total Fat (45% DV)"
        ),
        NutritionState(
            amount = "20",
            unit = "g",
            title = "Total Carbs (16% DV)"
        ),
        NutritionState(
            amount = "30",
            unit = "g",
            title = "Protein"
        )
    )
)

data class Calories(
    val value : String,
    val unit : String
)

data class NutritionState(
    val amount : String,
    val unit : String,
    val title : String
)