package com.app.base.ui.category.pojo

import com.google.gson.annotations.SerializedName

data class CategoryItem(
        @field:SerializedName("site_name")
        val siteName: String? = null,

        @field:SerializedName("site_url")
        val siteUrl: String? = null
)