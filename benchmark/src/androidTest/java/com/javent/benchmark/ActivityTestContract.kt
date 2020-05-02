package com.javent.benchmark

import android.app.Activity
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.benchmark.junit4.BenchmarkRule
import androidx.test.rule.ActivityTestRule
import com.javent.feature_example.MainActivity
import org.junit.After
import org.junit.Rule

interface ActivityTestContract<T: AppCompatActivity> {
    /**
     * Annotate with [@get:Rule] on implementation
     */
    val activityRule: ActivityTestRule<T>

    @After
    fun finishActivity() {
        activityRule.activity.finish()
    }
}
