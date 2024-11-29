package com.example.myapplicationcourse.firstapp.superheroapp

import retrofit2.http.GET

interface ApiService {

    @GET("")
    suspend fun getSuperHeroes()
}