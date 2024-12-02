package com.example.myapplicationcourse.firstapp.superheroapp

import io.github.cdimascio.dotenv.dotenv

object ApiConfig {
    private val dotenv = dotenv()

    val baseUrl: String by lazy { dotenv["BASE_URL"] ?: error("BASE_URL is not set") }
    val apiToken: String by lazy { dotenv["API_TOKEN"] ?: error("API_TOKEN is not set") }
}