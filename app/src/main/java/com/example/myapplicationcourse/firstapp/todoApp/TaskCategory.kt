package com.example.myapplicationcourse.firstapp.todoApp

sealed class TaskCategory {
    object Business : TaskCategory()
    object Personal : TaskCategory()
    object Other : TaskCategory()
}