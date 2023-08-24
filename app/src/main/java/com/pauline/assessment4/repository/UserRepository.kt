package com.pauline.assessment4.repository

import com.pauline.assessment4.api.ApiClient
import com.pauline.assessment4.api.ApiInterface
import com.pauline.assessment4.model.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)

    suspend fun getUsers():Response<UserResponse>{
        return withContext(Dispatchers.IO){
            apiClient.getUsers()
        }
    }
}
