package com.app.base.ui.aroundme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.app.base.R
import com.app.base.ui.aroundme.bean.AroundMeResponse
import com.app.base.ui.aroundme.bean.SubCategoryListItem
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_around_me.*
import java.io.InputStream

class AroundMeActivity : AppCompatActivity(), () -> Unit, (List<SubCategoryListItem?>?) -> Unit {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_around_me)

        val gson = Gson()
        val data: AroundMeResponse = gson.fromJson(readJSONFromAsset(), AroundMeResponse::class.java)

        val adapter = AroundMeAdapter(this, data.data)
        rv_aroundme.layoutManager = GridLayoutManager(this, 3)
        rv_aroundme.adapter = adapter
        Log.d("tt", data.toString())
    }

    private fun readJSONFromAsset(): String? {
        val json: String?
        try {
            val inputStream: InputStream = assets.open("category_around.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    override fun invoke(p1: List<SubCategoryListItem?>?) {
        val adapter = AroundMeSubAdapter(this, p1)
        rv_aroundme.layoutManager = GridLayoutManager(this, 3)
        rv_aroundme.adapter = adapter
    }

    override fun invoke() {

    }

}
