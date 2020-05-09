package com.javent.benchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.javent.feature_example.MainActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LayoutInflateBenchmark {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Before
    fun setup() {
        scenario = launchActivity()
    }

    @After
    fun teardown() {
        scenario.close()
    }

    @Test
    fun renderConstraintLayout() {
        scenario.onActivity {
            benchmarkRule.measureRepeated {
                it.setContentView(R.layout.activity_constraint_layout)
            }
        }
    }

    @Test
    fun renderLinearLayout() {
        scenario.onActivity {
            benchmarkRule.measureRepeated {
                it.setContentView(R.layout.activity_linear_layout)
            }
        }
    }

    @Test
    fun renderRelativeLayout() {
        scenario.onActivity {
            benchmarkRule.measureRepeated {
                it.setContentView(R.layout.activity_relative_layout)
            }
        }
    }
}
