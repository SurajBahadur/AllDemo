package com.app.base.ui.aroundme.bean

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("subCategoryList")
	val subCategoryList: List<SubCategoryListItem?>? = null,

	@field:SerializedName("categoryName")
	val categoryName: String? = null
)