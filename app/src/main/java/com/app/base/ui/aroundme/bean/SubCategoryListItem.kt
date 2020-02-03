package com.app.base.ui.aroundme.bean


import com.google.gson.annotations.SerializedName

data class SubCategoryListItem(

        @field:SerializedName("categoryIcon")
        val categoryIcon: String? = null,

        @field:SerializedName("categoryName")
        val categoryName: String? = null
)