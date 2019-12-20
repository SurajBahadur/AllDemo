package com.app.base.ui.category

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.ui.category.adapter.CategoryLabelAdapter
import com.app.base.ui.category.pojo.CategoryItem
import com.app.base.ui.category.pojo.CategorySectionModel
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.thefinestartist.finestwebview.FinestWebView
import kotlinx.android.synthetic.main.activity_category_updated.*
import kotlinx.android.synthetic.main.content_category_updated.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream


class CategoryUpdatedActivity : AppCompatActivity(), ItemClickListener, SearchView.OnQueryTextListener {

    var subCatKeysArraylist: ArrayList<CategoryItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_updated)
        setSupportActionBar(toolbar)
        parseJson(JSONObject(readJSONFromAsset()))
        searchView.setOnQueryTextListener(this)
    }


    lateinit var sectionModelArrayList: ArrayList<CategorySectionModel>
    lateinit var filteredArrayList: ArrayList<CategorySectionModel>
    lateinit var adapter: CategoryLabelAdapter
    private fun parseJson(data: JSONObject?) {
        val keysIterator = data!!.keys()
        val gson = GsonBuilder().create()
        sectionModelArrayList = ArrayList()

        while (keysIterator.hasNext()) {
            val keyStr = keysIterator.next() as String
            subCatKeysArraylist = ArrayList()
            val key = data.opt(keyStr) as JSONArray
            val listType = object : TypeToken<List<CategoryItem>>() {
            }.type
            subCatKeysArraylist = gson.fromJson(key.toString(), listType)
            sectionModelArrayList.add(CategorySectionModel(keyStr, subCatKeysArraylist))
        }

        rv_category_list.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        adapter = CategoryLabelAdapter(sectionModelArrayList, this)
        rv_category_list.adapter = adapter
    }


    private fun readJSONFromAsset(): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = assets.open("category.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    override fun onItemClick(pos: Int, url: String) {
        FinestWebView.Builder(this).show(url)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        adapter.filter!!.filter(newText.toString())
        return false
    }

}
