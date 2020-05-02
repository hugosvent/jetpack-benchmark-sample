package com.javent.benchmark.layout

import android.widget.TextView
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.javent.benchmark.ActivityTestContract
import com.javent.benchmark.BenchmarkTestContract
import com.javent.benchmark.R
import com.javent.feature_example.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ComplexLinearLayoutBenchmark: BenchmarkTestContract, ActivityTestContract<MainActivity> {
    @get:Rule
    override val benchmarkRule: BenchmarkRule = BenchmarkRule()

    @get:Rule
    override val activityRule = ActivityTestRule(MainActivity::class.java)

    @UiThreadTest
    @Test
    fun renderLinearLayout() {
        activityRule.activity.let {
            benchmarkRule.measureRepeated {
                it.setContentView(R.layout.activity_complex_linear_layout)

            }
        }
    }

    @UiThreadTest
    @Test
    fun accessNestedChild() {
        activityRule.activity.let {
            it.setContentView(R.layout.activity_complex_linear_layout)
            benchmarkRule.measureRepeated {
                it.findViewById<TextView>(R.id.tvNested).text = "text change"
                it.findViewById<TextView>(R.id.tvNested2).text = "text change"

            }
        }
    }
}
