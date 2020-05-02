package com.javent.benchmark

import android.util.Log
import androidx.benchmark.junit4.BenchmarkRule
import org.junit.After
import org.junit.Before
import org.junit.Rule

interface BenchmarkTestContract {
    /**
     * Annotate with [@get:Rule] on implementation
     */
    val benchmarkRule: BenchmarkRule

    @Before
    fun systemGC() {
        System.gc()
    }
}
