package com.app.base.ui.facts.favourite

import android.graphics.*
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.base.R
import com.app.base.room.entity.FactData
import com.app.base.ui.facts.FactsViewModel
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_favourite.*
import kotlinx.android.synthetic.main.content_favourite.*

class FavouriteActivity : AppCompatActivity(), (String) -> Unit {
    private val p = Paint()
    private lateinit var viewModel: FactsViewModel
    private lateinit var adapter: FavouriteAdapter
    private lateinit var list: MutableList<FactData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        setSupportActionBar(toolbar)
        viewModel = ViewModelProviders.of(this).get(FactsViewModel::class.java)
        attachObserver()
        viewModel.getFavFacts()
    }

    private fun attachObserver() {
        viewModel.favFacts.observe(this, Observer {
            populateUI(it as MutableList<FactData>?)
        })
    }

    private fun populateUI(it: MutableList<FactData>?) {
        list = it!!
        adapter = FavouriteAdapter(it, this)
        rv_favourite.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_favourite.adapter = adapter
        enableSwipe()
    }


    private fun enableSwipe() {
        val simpleItemTouchCallback =
                object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

                    override fun onMove(
                            recyclerView: RecyclerView,
                            viewHolder: RecyclerView.ViewHolder,
                            target: RecyclerView.ViewHolder
                    ): Boolean {
                        return false
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                        val position = viewHolder.adapterPosition

                        if (direction == ItemTouchHelper.LEFT) {
                            val deletedModel = list[position]
                            adapter.removeItem(position)
                            // showing snack bar with Undo option
                            val snackbar = Snackbar.make(
                                    window.decorView.rootView,
                                    " removed from Recyclerview!",
                                    Snackbar.LENGTH_LONG
                            )
                            snackbar.setAction("UNDO") {
                                // undo is selected, restore the deleted item
                                adapter.restoreItem(deletedModel, position)
                            }
                            snackbar.setActionTextColor(Color.YELLOW)
                            snackbar.show()
                        } else {
                            val deletedModel = list[position]
                            adapter.removeItem(position)
                            // showing snack bar with Undo option
                            val snackbar = Snackbar.make(window.decorView.rootView, " removed from Recyclerview!", Snackbar.LENGTH_LONG)
                            snackbar.setAction("UNDO") {
                                // undo is selected, restore the deleted item
                                adapter.restoreItem(deletedModel, position)
                            }

                            snackbar.addCallback(object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                                override fun onShown(transientBottomBar: Snackbar?) {
                                    super.onShown(transientBottomBar)
                                    displayMessage("onShown")
                                    //transientBottomBar!!.view.findViewById<R.id.snackbar_action>()
                                }

                                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                                    super.onDismissed(transientBottomBar, event)
                                    displayMessage("onDismissed")
                                }
                            })

                            snackbar.setActionTextColor(Color.YELLOW)
                            snackbar.show()
                        }
                    }

                    override fun onChildDraw(
                            c: Canvas,
                            recyclerView: RecyclerView,
                            viewHolder: RecyclerView.ViewHolder,
                            dX: Float,
                            dY: Float,
                            actionState: Int,
                            isCurrentlyActive: Boolean
                    ) {

                        val icon: Bitmap
                        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                            val itemView = viewHolder.itemView
                            val height = itemView.bottom.toFloat() - itemView.top.toFloat()
                            val width = height / 3

                            if (dX > 0) {
                                p.color = Color.parseColor("#388E3C")
                                val background = RectF(itemView.left.toFloat(), itemView.top.toFloat(), dX, itemView.bottom.toFloat())
                                c.drawRect(background, p)
                                icon = BitmapFactory.decodeResource(resources, R.drawable.delete)
                                val icon_dest = RectF(
                                        itemView.left.toFloat() + width,
                                        itemView.top.toFloat() + width,
                                        itemView.left.toFloat() + 2 * width,
                                        itemView.bottom.toFloat() - width
                                )
                                c.drawBitmap(icon, null, icon_dest, p)
                            } else {
                                p.color = Color.parseColor("#D32F2F")
                                val background = RectF(
                                        itemView.right.toFloat() + dX,
                                        itemView.top.toFloat(),
                                        itemView.right.toFloat(),
                                        itemView.bottom.toFloat()
                                )
                                c.drawRect(background, p)
                                icon = BitmapFactory.decodeResource(resources, R.drawable.delete)
                                val icon_dest = RectF(
                                        itemView.right.toFloat() - 2 * width,
                                        itemView.top.toFloat() + width,
                                        itemView.right.toFloat() - width,
                                        itemView.bottom.toFloat() - width
                                )
                                c.drawBitmap(icon, null, icon_dest, p)
                            }
                        }
                        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    }
                }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(rv_favourite)
    }

    private fun displayMessage(txt: String): Unit {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show()
    }

    override fun invoke(p1: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
