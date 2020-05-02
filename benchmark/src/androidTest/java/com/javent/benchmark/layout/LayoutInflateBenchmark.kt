package com.javent.benchmark.layout

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
class LayoutInflateBenchmark: BenchmarkTestContract, ActivityTestContract<MainActivity> {
    @get:Rule
    override val benchmarkRule: BenchmarkRule = BenchmarkRule()

    @get:Rule
    override val activityRule = ActivityTestRule(MainActivity::class.java)

    @UiThreadTest
    @Test
    fun renderConstraintLayout() {
        activityRule.activity.let {
            benchmarkRule.measureRepeated {
                it.setContentView(R.layout.activity_constraint_layout)
            }
        }
    }

    @UiThreadTest
    @Test
    fun renderLinearLayout() {
        activityRule.activity.let {
            benchmarkRule.measureRepeated {
                it.setContentView(R.layout.activity_linear_layout)
            }
        }
    }

    @UiThreadTest
    @Test
    fun renderRelativeLayout() {
        activityRule.activity.let {
            benchmarkRule.measureRepeated {
                it.setContentView(R.layout.activity_relative_layout)
            }
        }
    }
}
