package com.javent.benchmark.list

import android.widget.ListView
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.javent.benchmark.ActivityTestContract
import com.javent.benchmark.BenchmarkTestContract
import com.javent.benchmark.R
import com.javent.benchmark.list.ListConfig.IMAGE_URL
import com.javent.benchmark.list.ListConfig.ITEM_COUNT
import com.javent.feature_example.ListViewActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class ListViewBenchmark: BenchmarkTestContract, ActivityTestContract<ListViewActivity> {
    @get:Rule
    override val benchmarkRule: BenchmarkRule = BenchmarkRule()

    @get:Rule
    override val activityRule = ActivityTestRule(ListViewActivity::class.java)

    @Before
    fun setup() {
        val dataList = {
            val mutableStrings = mutableListOf<Pair<String, String>>()

            for (i in 0..ITEM_COUNT) {
                mutableStrings.add(
                    Pair(
                        i.toString(),
                        IMAGE_URL
                    )
                )
            }

            mutableStrings
        }.invoke()

        activityRule.let {
            it.runOnUiThread {
                it.activity.updateListViewData(dataList)
            }
        }
    }

    @Test
    fun scrollBenchmark() {
        activityRule.activity.let {
            val listView = it.findViewById<ListView>(R.id.listView)

            benchmarkRule.measureRepeated {
                activityRule.activity.runOnUiThread {
                    listView.scrollBy(0, listView.getLastChild().height)
                }
            }
        }
    }
}

