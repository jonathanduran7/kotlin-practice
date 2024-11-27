package com.example.myapplicationcourse.firstapp.todoApp

data class Task(
    val name: String,
    val category: TaskCategory,
    var isChecked: Boolean = false
)