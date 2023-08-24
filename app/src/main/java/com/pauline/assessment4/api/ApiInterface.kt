package com.pauline.assessment4.api

import com.pauline.assessment4.model.User
import com.pauline.assessment4.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    suspend fun getPosts():Response<List<User>>
}
