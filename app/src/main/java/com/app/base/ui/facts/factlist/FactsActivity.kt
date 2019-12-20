package com.app.base.ui.facts.factlist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.room.entity.FactData
import com.app.base.ui.facts.FactsViewModel
import com.app.base.ui.facts.favourite.FavouriteActivity

import kotlinx.android.synthetic.main.activity_facts.*
import kotlinx.android.synthetic.main.content_facts.*
import org.json.JSONArray
import java.io.InputStream

class FactsActivity : AppCompatActivity(), (Int, Boolean) -> Unit {

    private lateinit var adapter: FactsAdapter
    private lateinit var viewModel: FactsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facts)
        setSupportActionBar(toolbar)
        viewModel = ViewModelProviders.of(this).get(FactsViewModel::class.java)


        /*viewModel.allFacts.observe(this, Observer {
            if (it.size > 0) {
                Log.d("ttt", "data present")
                viewModel.getAllFacts()
            } else {
                Log.d("ttt", "data not present")
                insertDataIntoLocalStorage()
            }
        })*/

        viewModel.facts.observe(this, Observer {
            if (it.isNotEmpty()) {
                progressBar2.visibility = View.GONE
                initAdapter(it)
            } else {
                insertDataIntoLocalStorage()
            }
        })

        viewModel.getAllFacts()
    }

    private fun insertDataIntoLocalStorage() {
        val jsonArray = JSONArray(readJSONFromAsset())
        val list = ArrayList<String>()
        progressBar2.visibility = View.VISIBLE
        for (data in 0 until jsonArray.length()) {
            viewModel.insert(FactData(jsonArray.get(data).toString(), false))
        }
    }

    private fun initAdapter(data: List<FactData>) {
        adapter = FactsAdapter(data, this)
        rv_facts.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_facts.adapter = adapter
    }

    private fun readJSONFromAsset(): String? {
        var json: String? = null
        try {
            val inputStream: InputStream = assets.open("data.json")
            json = inputStream.bufferedReader().use { it.readText() }
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    override fun invoke(id: Int, status: Boolean) {
          viewModel.markFactAsFav(status,id)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_fav -> {
                startActivity(Intent(this, FavouriteActivity::class.java))
            }

        }
        return super.onOptionsItemSelected(item)
    }

}


