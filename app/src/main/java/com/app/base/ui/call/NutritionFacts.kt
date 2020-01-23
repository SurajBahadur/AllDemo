package com.app.base.ui.call

class NutritionFacts(val foodName: String,
                     val calories: Int,
                     val protein: Int = 0,
                     val carbohydrates: Int = 0,
                     val fat: Int = 0,
                     val description: String = "") {
}