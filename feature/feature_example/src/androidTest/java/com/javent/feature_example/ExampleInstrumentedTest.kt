package com.javent.jetpackbenchmarksample

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.javent.feature_example.MainActivity
import com.javent.feature_example.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun renderLinearLayout() {
        scenario.onActivity {
            it.setContentView(R.layout.activity_linear_layout)
        }
    }

    @Test
    fun renderRelativeLayout() {
        scenario.onActivity {
            it.setContentView(R.layout.activity_relative_layout)
        }
    }

    @Test
    fun renderConstraintLayout() {
        scenario.onActivity {
            it.setContentView(R.layout.activity_constraint_layout)
        }
    }
}
