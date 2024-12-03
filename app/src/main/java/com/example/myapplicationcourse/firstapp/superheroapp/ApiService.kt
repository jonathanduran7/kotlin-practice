package com.example.myapplicationcourse.firstapp.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/api/4702bd2a23dd7cdb1daa92bb0bbd880f/search/{name}")
    suspend fun getSuperHeroes(@Path("name") superheroName: String): Response<SuperHeroDataResponse>

    @GET("/api/4702bd2a23dd7cdb1daa92bb0bbd880f/{id}")
    suspend fun getSuperheroById(@Path("id") id: String): Response<SuperHeroDetailResponse>
}