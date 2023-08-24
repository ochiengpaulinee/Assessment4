package com.pauline.assessment4.api

import com.pauline.assessment4.model.User
import com.pauline.assessment4.model.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/user")
    suspend fun getUsers():Response<UserResponse>

    @GET("/user/{id}")
    suspend fun getUserById(@Path("id")itemId:Int):Response<User>

}

//@GET("/product")
//suspend fun getProducts(): Response<ProductsResponse>
//
//@GET("/product/{id}")
//suspend fun getProductById(@Path("id")productId: Int): Response<Product>