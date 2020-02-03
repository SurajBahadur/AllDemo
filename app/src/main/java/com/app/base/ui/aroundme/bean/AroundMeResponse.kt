package com.app.base.ui.aroundme.bean

import com.google.gson.annotations.SerializedName

data class AroundMeResponse(

        @field:SerializedName("data")
        val data: List<DataItem?>? = null
)