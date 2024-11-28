package com.example.myapplicationcourse.firstapp.todoApp

sealed class TaskCategory(var isSelected: Boolean = true) {
    object Business : TaskCategory()
    object Personal : TaskCategory()
    object Other : TaskCategory()
}