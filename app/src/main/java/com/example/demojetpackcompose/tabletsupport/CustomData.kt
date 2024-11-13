package com.example.demojetpackcompose.tabletsupport

import com.example.demojetpackcompose.R


data class CustomData(
    val id: String,
    val image: Int,
    val title: String,
    val description: String,
)

fun dummyDataList(): List<CustomData> {
    val list: ArrayList<CustomData> = ArrayList()
    for (i in 1..10) {
        list.add(
            CustomData(
                id = "1 $i++",
                image = R.drawable.ic_favorite,
                title = "Sample Title $i",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"
            )
        )
    }
    return list
}