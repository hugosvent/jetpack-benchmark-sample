package com.javent.benchmark.list

import android.view.View
import android.view.ViewGroup
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.javent.benchmark.ActivityTestContract
import com.javent.benchmark.BenchmarkTestContract
import com.javent.benchmark.R
import com.javent.benchmark.list.ListConfig.IMAGE_URL
import com.javent.feature_example.RecyclerViewActivity
import org.junit.*
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class RecyclerViewBenchmark: BenchmarkTestContract, ActivityTestContract<RecyclerViewActivity> {
    @get:Rule
    override val benchmarkRule: BenchmarkRule = BenchmarkRule()

    @get:Rule
    override val activityRule = ActivityTestRule(RecyclerViewActivity::class.java)

    @Before
    fun setup() {
        val dataList = {
            val mutableStrings = mutableListOf<Pair<String, String>>()

            for (i in 0..ListConfig.ITEM_COUNT) {
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
                it.activity.updateRecyclerViewData(dataList)
            }
        }
    }

    @Test
    fun scrollBenchmark() {
        activityRule.activity.let {
            val recyclerView = it.findViewById<RecyclerView>(R.id.recyclerView)

            benchmarkRule.measureRepeated {
                activityRule.activity.runOnUiThread {
                    recyclerView.scrollBy(0, recyclerView.getLastChild().height)
                }
            }
        }
    }
}

fun ViewGroup.getLastChild(): View = getChildAt(childCount - 1)

