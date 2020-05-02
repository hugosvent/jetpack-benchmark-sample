package com.javent.feature_example

import android.content.Context
import android.database.DataSetObserver
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.item_image_label.view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
    }

    fun updateListViewData(dataList: List<Pair<String, String>>) {
        listView.adapter = ExampleArrayAdapter(this, R.layout.item_image_label, dataList)
    }
}


class ExampleArrayAdapter(
    private val context: Context,
    private val layoutResourceId: Int,
    val dataList: List<Pair<String, String>>
) : ListAdapter  {
    override fun isEmpty(): Boolean {
        return false
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return LayoutInflater.from(context).inflate(layoutResourceId, null).apply {
            Picasso.get().load(dataList.get(position).second).into(imageView)
            textView.text = dataList[position].first
        }
    }

    override fun registerDataSetObserver(observer: DataSetObserver?) {

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getViewTypeCount(): Int {
        return dataList.size
    }

    override fun isEnabled(position: Int): Boolean {
        return true
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun areAllItemsEnabled(): Boolean {
        return true
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
    }

    override fun getCount(): Int {
        return dataList.size
    }
}
