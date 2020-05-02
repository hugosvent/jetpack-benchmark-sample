package com.javent.feature_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_recycler_view.*
import kotlinx.android.synthetic.main.item_image_label.view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    fun updateRecyclerViewData(dataList: List<Pair<String, String>>) {
        recyclerView.adapter = ExampleAdapter(dataList)
    }
}

class ExampleAdapter(val dataList: List<Pair<String, String>>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ExampleViewHolder(private val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image_label, parent, false)

        return ExampleViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        dataList.getOrNull(position).let {
            holder.itemView.textView.text = it?.first
            Picasso.get().load(it?.second).into(holder.itemView.imageView)
        }
    }
}
