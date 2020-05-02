package com.javent.benchmark.list

object ListConfig {
    const val ITEM_COUNT = 10_000
    val IMAGE_URL
    get() = "https://picsum.photos/seed/${Math.random() * 1000}/10"
}
