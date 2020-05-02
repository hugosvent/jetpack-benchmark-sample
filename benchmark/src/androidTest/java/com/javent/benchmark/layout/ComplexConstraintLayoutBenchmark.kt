package com.javent.benchmark.layout

import android.widget.TextView
import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.javent.benchmark.ActivityTestContract
import com.javent.benchmark.BenchmarkTestContract
import com.javent.benchmark.R
import com.javent.feature_example.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class ComplexConstraintLayoutBenchmark: BenchmarkTestContract, ActivityTestContract<MainActivity> {
    @get:Rule
    override val benchmarkRule: BenchmarkRule = BenchmarkRule()

    @get:Rule
    override val activityRule = ActivityTestRule(MainActivity::class.java)

    @UiThreadTest
    @Test
    fun renderConstraintLayout() {
        activityRule.activity?.let {
            benchmarkRule.measureRepeated {
                it.setContentView(R.layout.activity_complex_constraint_layout)

            }
        }
    }

    @UiThreadTest
    @Test
    fun accessChild() {
        activityRule.activity?.let {
            it.setContentView(R.layout.activity_complex_constraint_layout)
            benchmarkRule.measureRepeated {
                it.findViewById<TextView>(R.id.tv9).text = "text change"
                it.findViewById<TextView>(R.id.tv10).text = "text change"

            }
        }
    }
}
